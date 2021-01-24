package br.com.stockportfoliovisualization.service;

import br.com.stockportfoliovisualization.model.StockInfo;
import br.com.stockportfoliovisualization.model.UserPortfolio;
import br.com.stockportfoliovisualization.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PortfolioCalculator {

    @Autowired
    PortfolioRepository portfolioRepository;

    public UserPortfolio buildCalculatedPortfolio(UserPortfolio userPortfolio) {
        List<StockInfo> stockInfos = userPortfolio.getStockInfos();

        stockInfos.forEach(stockInfo -> {
            stockInfo.setStockTotalPurchaseValue(stockInfo.getStockPurchaseValue().multiply(BigDecimal.valueOf(stockInfo.getQuantity())));
            stockInfo.setCurrentStockValue(portfolioRepository.getCurrentStockValue(stockInfo.getStock().toUpperCase()));
            stockInfo.setCurrentTotalStockValue(stockInfo.getCurrentStockValue().multiply(BigDecimal.valueOf(stockInfo.getQuantity())));
            stockInfo.setTotalSpentValue(stockInfo.getStockTotalPurchaseValue().add(stockInfo.getFees()));
        });

        userPortfolio.setTotalSpentValue(stockInfos.stream().map(StockInfo::getTotalSpentValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        userPortfolio.setAllStocksCurrentValue(stockInfos.stream().map(StockInfo::getCurrentTotalStockValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        userPortfolio.setCurrentProfit(userPortfolio.getAllStocksCurrentValue().subtract(userPortfolio.getTotalSpentValue()));

        return userPortfolio;
    }
}
