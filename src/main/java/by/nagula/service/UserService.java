package by.nagula.service;

import by.nagula.entity.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    User showUserById(long id);
    User showUserByLogin(String login);
    void removeUser(long id);
    void updateUser(long id);
    boolean containsUser(String login);
    List<User> showAllUser();
    void update(User user);

}
