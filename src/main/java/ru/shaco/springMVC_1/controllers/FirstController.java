package ru.shaco.springMVC_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        //Добавление параметров пользователя в МОДЕЛЬ в виде сообщения через пару ("ключ", значение)
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    /*
    Хорошей практикой считается создавать отдельную директорию представлений (view) для каждого контроллера
    Папки first и second в директории views для FirstController и SecondController
    */
}
