package br.com.stockportfoliovisualization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    //TODO
    @GetMapping
    public String getPortfolioValues(@RequestParam("stock") List<String> stocks) {
        String stockNames = "";

        for (String stock : stocks) {
            stockNames += stock +" ";
        }

        return stockNames.trim();
    }
}
