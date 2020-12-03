package by.nagula.service;

import by.nagula.entity.Task;

import java.util.List;

public interface TaskService {
    void createTask(Task task);
    List<Task> showAllTasksByUserId(long userId);
    void closeTask(long id);
}
