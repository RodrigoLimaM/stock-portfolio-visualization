package br.com.stockportfoliovisualization.controller;

import br.com.stockportfoliovisualization.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    PortfolioService portfolioService;

    @GetMapping
    public ModelAndView getHomePage() {
        return new ModelAndView("home")
                .addObject("userPortfolio", portfolioService.getUserPortfolioByCurrent_Id());
    }
}
