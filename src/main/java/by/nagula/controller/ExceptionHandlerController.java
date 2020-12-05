package by.nagula.controller;

import by.nagula.service.exception.EmptyDataFromControllerException;
import by.nagula.service.exception.UserAlreadyExistException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserAlreadyExistException.class)
    public String exceptionWithLogin(Model model, UserAlreadyExistException ex){
        model.addAttribute("messageInReg", ex.getMessage());
        return "registration";
    }

    @ExceptionHandler(EmptyDataFromControllerException.class)
    public String emptyData(Model model, EmptyDataFromControllerException ex){
        model.addAttribute("messageInReg2", ex.getMessage());
        return "registration";
    }
}
