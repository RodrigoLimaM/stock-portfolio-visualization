package br.com.stockportfoliovisualization.controller;

import br.com.stockportfoliovisualization.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @GetMapping
    public ModelAndView getPortfolioForm() {
        return new ModelAndView("portfolio-form");
    }

    //TODO
    @PostMapping
    public ModelAndView savePortfolioInfo(@RequestParam("stock") String[] stocks,
                                    @RequestParam("stockPurchaseValue") BigDecimal[] stockPurchaseValues,
                                    @RequestParam("quantity") Integer[] quantities,
                                    @RequestParam("fees") BigDecimal[] fees) {

        return new ModelAndView("home")
                .addObject("portfolioInfo", portfolioService.save(stocks, stockPurchaseValues, quantities, fees));
    }
}
