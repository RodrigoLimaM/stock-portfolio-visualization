package br.com.stockportfoliovisualization.controller;

import br.com.stockportfoliovisualization.model.StockInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping
    public ModelAndView home() {
        return new ModelAndView("home")
                .addObject("stockInfo", new StockInfo());
    }
}
