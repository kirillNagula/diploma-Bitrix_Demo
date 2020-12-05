package by.nagula.controller;

import by.nagula.entity.User;
import by.nagula.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView getPage(ModelAndView modelAndView){
        modelAndView.addObject("user",new User() );
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView getPost(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, ModelAndView modelAndView){
        if (bindingResult.hasErrors()){
           modelAndView.setViewName("registration");
        } else {
            userService.createUser(user);
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }
}
