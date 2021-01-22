package br.com.stockportfoliovisualization.service;

import br.com.stockportfoliovisualization.model.StockInfo;
import br.com.stockportfoliovisualization.model.UserPortfolio;
import br.com.stockportfoliovisualization.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    PortfolioRepository portfolioRepository;

    public UserPortfolio save(String[] stocks, BigDecimal[] stockValues, Integer[] quantities, BigDecimal[] fees) {

        return portfolioRepository.save(UserPortfolio.builder()
                        .email("teste@teste.com")
                        .stockInfos(buildStockInfos(stocks, stockValues, quantities, fees))
                        .build());
    }

    private List<StockInfo> buildStockInfos(String[] stocks, BigDecimal[] stockValues, Integer[] quantities, BigDecimal[] fees) {
        List<StockInfo> stockInfos = new ArrayList<>();

        int length = stocks.length;

        for (int i = 0; i < length; i++) {
            stockInfos.add(StockInfo
                    .builder()
                    .stock(stocks[i])
                    .stockValues(stockValues[i])
                    .quantity(quantities[i])
                    .fees(fees[i])
                    .build());
        }

        return stockInfos;
    }
}
