package by.nagula.controller;

import by.nagula.entity.User;
import by.nagula.service.ChatService;
import by.nagula.service.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/home")
public class HomeController {
    private final TaskService taskService;
    private final ChatService chatService;

    public HomeController(TaskService taskService, ChatService chatService) {
        this.taskService = taskService;
        this.chatService = chatService;
    }

    @GetMapping
    public ModelAndView getPage(ModelAndView modelAndView, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        modelAndView.addObject("chatList", chatService.showChatsByUserId(user.getId()));
        modelAndView.addObject("user", user);
        modelAndView.addObject("taskNum", taskService.showAllTasksByUserId(user.getId()).size());
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
