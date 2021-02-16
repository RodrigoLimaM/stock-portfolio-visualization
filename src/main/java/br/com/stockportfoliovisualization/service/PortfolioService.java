package br.com.stockportfoliovisualization.service;

import br.com.stockportfoliovisualization.config.exception.UserAlreadyExistsException;
import br.com.stockportfoliovisualization.model.StockInfo;
import br.com.stockportfoliovisualization.model.UserDTO;
import br.com.stockportfoliovisualization.model.UserPortfolio;
import br.com.stockportfoliovisualization.model.mapper.PortfolioMapper;
import br.com.stockportfoliovisualization.repository.PortfolioMongoTemplateRepository;
import br.com.stockportfoliovisualization.repository.PortfolioMongoRepository;
import br.com.stockportfoliovisualization.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    PortfolioMongoRepository portfolioMongoRepository;

    @Autowired
    PortfolioMongoTemplateRepository portfolioMongoTemplateRepository;

    @Autowired
    PortfolioMapper portfolioMapper;

    @Autowired
    PortfolioCalculator portfolioCalculator;

    @Autowired
    PortfolioRepository portfolioRepository;

    public UserPortfolio updatePortfolioStocks(String[] stocks, BigDecimal[] stockPurchaseValues, Integer[] quantities, BigDecimal[] fees) {

        return portfolioMongoTemplateRepository.pushStockInfosBy_Id(this.getCurrent_Id(), this.buildStockInfos(stocks, stockPurchaseValues, quantities, fees));
    }

    public UserPortfolio deletePortfolioStockByIndex(int stockIndex) {
        UserPortfolio userPortfolio = portfolioMongoRepository.findById(this.getCurrent_Id())
                .orElseThrow(() -> { throw new UsernameNotFoundException(""); });
        List<StockInfo> stockInfos = userPortfolio.getStockInfos();

        stockInfos.remove(stockIndex);

        return portfolioMongoRepository.save(userPortfolio);
    }

    public String getCurrent_Id() {
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
            if(portfolioRepository.getCurrentStockValue(stocks[i]) != null) {
                stockInfos.add(StockInfo
                        .builder()
                        .stock(stocks[i])
                        .stockPurchaseValue(stockPurchaseValues[i])
                        .quantity(quantities[i])
                        .fees(fees[i])
                        .build());
            }
        }

        return stockInfos;
    }

    public UserPortfolio registerUser(UserDTO userDTO) {
        if(!portfolioMongoRepository.existsByEmail(userDTO.getEmail()))
            return portfolioMongoRepository.save(portfolioMapper.mapUserDTOToUserPortfolio(userDTO));
        else
            throw new UserAlreadyExistsException();

    }

    public UserPortfolio getUserPortfolioByCurrent_Id() {
        return portfolioCalculator.buildCalculatedPortfolio(
                portfolioMongoRepository.findById(this.getCurrent_Id())
                        .orElseThrow(() -> {
                            throw new UsernameNotFoundException("");
                        }
                        )
        );
    }

}
