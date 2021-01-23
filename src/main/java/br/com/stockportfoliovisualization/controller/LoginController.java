package br.com.stockportfoliovisualization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login-form")
public class LoginController {

    @GetMapping
    public ModelAndView loginForm() {
        return new ModelAndView("login-form");
    }

}
