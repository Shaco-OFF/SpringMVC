package ru.shaco.springMVC_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/first")
@EnableWebMvc
public class CalculatorController {
    @GetMapping("/calculator")
    public String calculate(@RequestParam("a") int a,
                            @RequestParam("b") int b,
                            @RequestParam("action") ArithmeticOperations action,
                            Model model) {

        double result;

        switch (action) {
            case MULTIPLICATION:
                result = a * b;
                break;
            case ADDITION:
                result = a + b;
                break;
            case SUBTRACTION:
                result = a - b;
                break;
            case DIVISION:
                result = (double) a / b;
                break;
            default: result = 0;
        }
        model.addAttribute("result", result);

        return "/third/calculate";
    }
}
