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

        userPortfolio.setTotalStocksPurchaseValue(stockInfos.stream().map(StockInfo::getStockPurchaseValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        userPortfolio.setTotalStocksQuantity(stockInfos.stream().map(StockInfo::getQuantity).reduce(0, Integer::sum));
        userPortfolio.setTotalAllStocksPurchaseValue(stockInfos.stream().map(StockInfo::getStockTotalPurchaseValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        userPortfolio.setTotalFees(stockInfos.stream().map(StockInfo::getFees).reduce(BigDecimal.ZERO, BigDecimal::add));
        userPortfolio.setTotalCurrentStockValue(stockInfos.stream().map(StockInfo::getCurrentStockValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        userPortfolio.setTotalSpentValue(stockInfos.stream().map(StockInfo::getTotalSpentValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        userPortfolio.setTotalAllCurrentStockValue(stockInfos.stream().map(StockInfo::getCurrentTotalStockValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        userPortfolio.setCurrentProfit(userPortfolio.getTotalAllCurrentStockValue().subtract(userPortfolio.getTotalSpentValue()));

        return userPortfolio;
    }
}
