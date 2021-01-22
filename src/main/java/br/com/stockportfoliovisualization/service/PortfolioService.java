package br.com.stockportfoliovisualization.service;

import br.com.stockportfoliovisualization.model.in.StockInfo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {

    public String save(String[] stocks, BigDecimal[] stockValues, Integer[] quantities, BigDecimal[] fees) {

        return buildStockInfos(stocks, stockValues, quantities, fees).toString();
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
