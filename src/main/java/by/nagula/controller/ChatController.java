package by.nagula.controller;

import by.nagula.dto.ChatDto;
import by.nagula.dto.ChatUserDto;
import by.nagula.entity.Chat;
import by.nagula.entity.User;
import by.nagula.service.ChatService;
import by.nagula.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/home")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/chat")
    public ModelAndView getPage(ModelAndView modelAndView){
        modelAndView.addObject("newChat", new ChatDto());
        modelAndView.addObject("userList", userService.showAllUser());
        modelAndView.setViewName("chat");
        return modelAndView;
    }

    @PostMapping(path = "/chat")
    public ModelAndView post(@ModelAttribute("newChat") @Valid ChatDto chat, BindingResult bindingResult, ModelAndView modelAndView, Authentication authentication){
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("chat");
        } else {
            Chat chat1 = new Chat();
            List<User> userList = new ArrayList<>();
            userList.add(userService.showUserById(((User) authentication.getPrincipal()).getId()));
            chat1.setUserList(userList);
            chat1.setName(chat.getName());
            chat1.setCommentList(null);
            chatService.createChat(chat1);
            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }
    @GetMapping(path = "/chatAdd/{id}")
    public ModelAndView getPageUser(@PathVariable long id, ModelAndView modelAndView){
        modelAndView.addObject("chatUserList", chatService.showChatById(id).getUserList());
        modelAndView.addObject("chatUserId", id);
        modelAndView.addObject("nameChat", chatService.showChatById(id).getName());
        modelAndView.addObject("userId", new ChatUserDto());
        modelAndView.setViewName("addUserInChat");
        modelAndView.addObject("userList", userService.showAllUser());
        return modelAndView;
    }

    @PostMapping(path = "/chatAdd/{id}")
    public ModelAndView postAdd(@PathVariable long id, @ModelAttribute("userId") ChatUserDto chatUserDto,  ModelAndView modelAndView){
        System.out.println(id);
        Chat chat = chatService.showChatById(id);
        chat.getUserList().add(userService.showUserById(chatUserDto.getUserId()));
        chatService.updateChat(chat);
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

}
