package by.nagula.controller;

import by.nagula.dto.UserDto;
import by.nagula.entity.User;
import by.nagula.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/home")
public class AccountController {
    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping (path = "/account")
    public ModelAndView getPage(ModelAndView modelAndView){
        modelAndView.addObject("userAc", new UserDto());
        modelAndView.setViewName("account");
        return modelAndView;
    }

    @PostMapping("/account")
    public ModelAndView postPage(@ModelAttribute("userAc") UserDto userDto, BindingResult bindingResult, ModelAndView modelAndView, Authentication authentication){
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("account");
        } else {
            User user = (User)authentication.getPrincipal();
            System.out.println(user);
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPassword(userDto.getPassword());
            userService.update(user);
            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }
}
