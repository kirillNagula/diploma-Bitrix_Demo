package by.nagula.service;

import by.nagula.entity.Task;
import by.nagula.entity.User;
import by.nagula.repository.TaskRepository;
import by.nagula.repository.UserRepository;
import by.nagula.service.exception.WrongIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public void createTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Task> showAllTasksByUserId(long userId) {
        if (userId > 0){
            return taskRepository.findAllByExecutorId(userId);
        } else {
            throw new WrongIdException("Wrong id");
        }
    }

    @Override
    public void closeTask(long id) {
        if (id > 0){
            taskRepository.deleteById(id);
        } else {
            throw new WrongIdException("Wrong id");
        }
    }
}
