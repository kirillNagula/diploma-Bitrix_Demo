package by.nagula.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "First name is empty")
    @NotBlank(message = "First name is empty")
    @Size(min = 2, message = "First name lesser then 2 char")
    private String firstName;

    @NotEmpty(message = "Last name is empty")
    @NotBlank(message = "Last name is empty")
    @Size(min = 2, message = "Last name lesser then 2 char")
    private String lastName;
    private String position;

    @NotEmpty(message = "Login ie empty")
    @NotBlank(message = "Login ie empty")
    @Size(min = 3, message = "Login lesser then 3 char")
    private String username;

    @NotEmpty(message = "Password is empty")
    @NotBlank(message = "Password is empty")
    @Size(min = 8, message = "Password must be greater then 8 char!")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Task> taskList = new ArrayList<>();

    public User(long id,String firstName, String lastName, String position, String username, String password, List<Task> taskList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.username = username;
        this.password = password;
        this.taskList = taskList;
    }

    public User() {
    }

    public User(String firstName, String lastName, String position,  String username,  String password, List<Task> taskList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.username = username;
        this.password = password;
        this.taskList = taskList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
