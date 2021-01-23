package br.com.stockportfoliovisualization.service;

import br.com.stockportfoliovisualization.model.StockInfo;
import br.com.stockportfoliovisualization.model.UserDTO;
import br.com.stockportfoliovisualization.model.UserPortfolio;
import br.com.stockportfoliovisualization.repository.PortfolioMongoTemplateRepository;
import br.com.stockportfoliovisualization.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    PortfolioMongoTemplateRepository portfolioMongoTemplateRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserPortfolio updatePortfolioStocks(String[] stocks, BigDecimal[] stockPurchaseValues, Integer[] quantities, BigDecimal[] fees) {

        return portfolioMongoTemplateRepository.pushStockInfosBy_Id(this.getCustomerId(), buildStockInfos(stocks, stockPurchaseValues, quantities, fees));
    }

    private String getCustomerId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof UserPortfolio) {
                return ((UserPortfolio) principal).get_id();
            }
        }
        return null;
    }

    private List<StockInfo> buildStockInfos(String[] stocks, BigDecimal[] stockPurchaseValues, Integer[] quantities, BigDecimal[] fees) {
        List<StockInfo> stockInfos = new ArrayList<>();

        int length = stocks.length;

        for (int i = 0; i < length; i++) {
            stockInfos.add(StockInfo
                    .builder()
                    .stock(stocks[i])
                    .stockPurchaseValue(stockPurchaseValues[i])
                    .quantity(quantities[i])
                    .fees(fees[i])
                    .build());
        }

        return stockInfos;
    }

    public UserPortfolio registerUser(UserDTO userDTO) {
        return portfolioRepository.save(UserPortfolio.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(encoder.encode(userDTO.getPassword()))
                .stockInfos(Collections.emptyList())
                .build());
    }
}
