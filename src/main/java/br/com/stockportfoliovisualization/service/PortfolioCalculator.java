package br.com.stockportfoliovisualization.service;

import br.com.stockportfoliovisualization.client.HGFinanceClient;
import br.com.stockportfoliovisualization.model.StockInfo;
import br.com.stockportfoliovisualization.model.UserPortfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PortfolioCalculator {

    private static final String ONLY_RESULTS = "only_results";

    @Autowired
    HGFinanceClient hgFinanceClient;

    @Value("${hg-finance.key}")
    String key;

    @Cacheable(value = "portfolio", key = "#userPortfolio._id")
    public UserPortfolio buildCalculatedPortfolio(UserPortfolio userPortfolio) {
        System.out.println("BATEU AQUI");
        List<StockInfo> stockInfos = userPortfolio.getStockInfos();

        stockInfos.forEach(stockInfo -> {
            String stockName = stockInfo.getStock();
            stockInfo.setStockTotalPurchaseValue(stockInfo.getStockPurchaseValue().multiply(BigDecimal.valueOf(stockInfo.getQuantity())));
            stockInfo.setCurrentStockValue(hgFinanceClient.getStockPrice(key, stockName, ONLY_RESULTS).get(stockName.toUpperCase()).getPrice());
            stockInfo.setCurrentTotalStockValue(stockInfo.getCurrentStockValue().multiply(BigDecimal.valueOf(stockInfo.getQuantity())));
            stockInfo.setTotalSpentValue(stockInfo.getStockTotalPurchaseValue().add(stockInfo.getFees()));
        });

        userPortfolio.setTotalSpentValue(stockInfos.stream().map(StockInfo::getTotalSpentValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        userPortfolio.setAllStocksCurrentValue(stockInfos.stream().map(StockInfo::getCurrentTotalStockValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        userPortfolio.setCurrentProfit(userPortfolio.getAllStocksCurrentValue().subtract(userPortfolio.getTotalSpentValue()));

        return userPortfolio;
    }
}
