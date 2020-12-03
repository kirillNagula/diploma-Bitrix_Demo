package by.nagula.controller;

import by.nagula.dto.CommentDto;
import by.nagula.entity.Comment;
import by.nagula.entity.User;
import by.nagula.service.ChatService;
import by.nagula.service.CommentService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(path = "/home")
public class CommentController {
    private final CommentService commentService;
    private final ChatService chatService;

    public CommentController(CommentService commentService, ChatService chatService) {
        this.commentService = commentService;
        this.chatService = chatService;
    }

    @GetMapping(path = "/comment/{id}")
    public ModelAndView getPageAgain(@PathVariable long id, ModelAndView modelAndView){
        modelAndView.addObject("chatObject", chatService.showChatById(id));
        modelAndView.addObject("commentList", commentService.showAllCommentsByChatId(id));
        modelAndView.addObject("comment", new CommentDto());
        modelAndView.setViewName("comment");
        return modelAndView;
    }

    @PostMapping(path = "/comment/add/{id}")
    public ModelAndView addPost(@PathVariable long id, @ModelAttribute("comment") CommentDto commentDto, ModelAndView modelAndView, Authentication authentication){
        Comment comment = new Comment();
        comment.setChatId(id);
        comment.setText(commentDto.message);
        comment.setUser(((User) authentication.getPrincipal()));
        comment.setDateTime(LocalDateTime.now());
        commentService.createComment(comment);
        modelAndView.setViewName("redirect:/home/comment/" + id);
        return modelAndView;
    }
}
