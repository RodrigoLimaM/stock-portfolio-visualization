package br.com.stockportfoliovisualization.controller;

import br.com.stockportfoliovisualization.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    //TODO
    @PostMapping
    public String getPortfolioValues(@RequestParam("stock") String[] stocks,
                                     @RequestParam("stockValue") BigDecimal[] stockValues,
                                     @RequestParam("quantity") Integer[] quantities,
                                     @RequestParam("fees") BigDecimal[] fees) {

        return portfolioService.calculatePortfolio(stocks, stockValues, quantities, fees);
    }
}
