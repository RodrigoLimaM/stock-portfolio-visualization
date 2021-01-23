package br.com.stockportfoliovisualization.controller;

import br.com.stockportfoliovisualization.model.UserDTO;
import br.com.stockportfoliovisualization.model.UserPortfolio;
import br.com.stockportfoliovisualization.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    PortfolioService portfolioService;

    @GetMapping
    public ModelAndView registerForm() {
        return new ModelAndView("register-form")
                .addObject("userDTO", new UserDTO());
    }

    @PostMapping
    public ModelAndView registerUser(UserDTO userDTO) {
        portfolioService.registerUser(userDTO);

        return new ModelAndView("redirect:/login-form");
    }
}
