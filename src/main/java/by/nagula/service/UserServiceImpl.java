package by.nagula.service;

import by.nagula.entity.User;
import by.nagula.repository.UserRepository;
import by.nagula.service.exception.NoUserById;
import by.nagula.service.exception.UserAlreadyExistException;
import by.nagula.service.exception.WrongIdException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }else {
            throw new UserAlreadyExistException("User with this Login is already exist");
        }

    }

    @Override
    public User showUserById(long id) {
        if (id > 0){
            if (userRepository.findById(id).isPresent()){
                return userRepository.findById(id).get();
            } else {
                throw new NoUserById("No user with this id");
            }
        } else {
            throw new WrongIdException("Wrong id");
        }
    }

    @Override
    public User showUserByLogin(String login) {
        if (userRepository.findByUsername(login).isEmpty()) {
            throw new UsernameNotFoundException("No user in Db");
        } else {
            return userRepository.findByUsername(login).get();
        }
    }

    @Override
    public void removeUser(long id) {
        if (id > 0){
            userRepository.deleteById(id);
        } else {
            throw new WrongIdException("Wrong id");
        }
    }

    @Override
    public void updateUser(long id) {
    }

    @Override
    public boolean containsUser(String login) {
        if (login != null){
            return userRepository.findByUsername(login).isPresent();
        } else {
            throw new WrongIdException("Wrong login");
        }
    }

    @Override
    public List<User> showAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void update(User user) {
        if (user == null){
            throw new NullPointerException("Null from controller");
        }
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (userRepository.findByUsername(s).isPresent()){
            return userRepository.findByUsername(s).get();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
