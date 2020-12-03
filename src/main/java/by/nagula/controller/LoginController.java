package by.nagula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/login")
public class LoginController {

    @GetMapping
    public ModelAndView getPage(){
        return new ModelAndView("login");
    }
}
