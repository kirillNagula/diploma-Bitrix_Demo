package by.nagula.controller;

import by.nagula.dto.ChatDto;
import by.nagula.entity.Chat;
import by.nagula.entity.User;
import by.nagula.service.ChatService;
import by.nagula.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView post(@ModelAttribute("newChat") ChatDto chat, ModelAndView modelAndView){
        System.out.println(chat);
        Chat chat1 = new Chat();
        List<User> userList = new ArrayList<>();
        userList.add(userService.showUserById(chat.getUserId()));
        chat1.setUserList(userList);
        chat1.setName(chat.getName());
        chat1.setCommentList(null);
        chatService.createChat(chat1);
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

}
