package by.nagula.controller;

import by.nagula.service.exception.EmptyDataFromControllerException;
import by.nagula.service.exception.NoChatException;
import by.nagula.service.exception.UserAlreadyExistException;
import by.nagula.service.exception.WrongIdException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

    @ExceptionHandler(WrongIdException.class)
    public String wrongId(Model model, WrongIdException ex){
        model.addAttribute("wrongId", ex.getMessage());
        return "chat";
    }

    @ExceptionHandler(WrongIdException.class)
    public String wrongId2(Model model, WrongIdException ex){
        model.addAttribute("wrongId", ex.getMessage());
        return "task";
    }

    @ExceptionHandler(WrongIdException.class)
    public String wrongId3(Model model, WrongIdException ex){
        model.addAttribute("wrongId", ex.getMessage());
        return "addUserInChat";
    }

    @ExceptionHandler(NoChatException.class)
    public String wrongChat(Model model, NoChatException ex){
        model.addAttribute("wrongChat", ex.getMessage());
        return "chat";
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public  String userNot(Model model, UsernameNotFoundException ex){
        model.addAttribute("not found", ex.getMessage());
        return "login";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullEr(Model model, NullPointerException ex){
        model.addAttribute("null from controller", ex.getMessage());
        return "account";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullEr2(Model model, NullPointerException ex){
        model.addAttribute("null from controller", ex.getMessage());
        return "registration";
    }
}
