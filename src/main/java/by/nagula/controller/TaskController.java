package by.nagula.controller;

import by.nagula.dto.TaskDto;
import by.nagula.entity.Task;
import by.nagula.entity.User;
import by.nagula.service.TaskService;
import by.nagula.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/home")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping(path = "/task")
    public ModelAndView getPage(ModelAndView modelAndView, Authentication authentication){
        modelAndView.addObject("userList", userService.showAllUser());
        modelAndView.addObject("taskList", taskService.showAllTasksByUserId(((User) authentication.getPrincipal()).getId()));
        modelAndView.addObject("task", new TaskDto());
        modelAndView.addObject("author", ((User) authentication.getPrincipal()).getFirstName());
        modelAndView.setViewName("task");
        return modelAndView;
    }

    @PostMapping(path = "/task")
    public ModelAndView post(@ModelAttribute("task") @Valid TaskDto task, BindingResult bindingResult, ModelAndView modelAttribute, Authentication authentication){
        if(bindingResult.hasErrors()){
            modelAttribute.setViewName("task");
        } else {
            Task task1 = new Task();
            task1.setAuthor(userService.showUserById(((User) authentication.getPrincipal()).getId()));
            task1.setExecutor(userService.showUserById(task.getExecutorId()));
            task1.setDateTime(task.getDateTime());
            task1.setDescription(task.getTaskText());
            taskService.createTask(task1);
        }
        return getPage(modelAttribute, authentication);
    }

    @GetMapping (path = "/task/{id}")
    public ModelAndView postAndClose(@PathVariable long id, ModelAndView modelAndView,  Authentication authentication){
        taskService.closeTask(id);
        return getPage(modelAndView, authentication);
    }
}
