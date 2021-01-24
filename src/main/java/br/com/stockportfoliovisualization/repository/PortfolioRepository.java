package br.com.stockportfoliovisualization.repository;

import br.com.stockportfoliovisualization.client.HGFinanceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class PortfolioRepository {

    private static final String ONLY_RESULTS = "only_results";

    @Autowired
    HGFinanceClient hgFinanceClient;

    @Value("${hg-finance.key}")
    String key;

    @Cacheable(value = "currentStockValue", key = "#stockName")
    public BigDecimal getCurrentStockValue(String stockName) {

        return hgFinanceClient
                .getStockPrice(key, stockName, ONLY_RESULTS).
                        get(stockName)
                .getPrice();
    }
}
