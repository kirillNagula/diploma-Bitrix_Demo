package by.nagula.entity;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Valid
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Wrong First name")
    @NotBlank(message = "Wrong First name")
    @Size(min = 2, message = "Wrong First name")
    private String firstName;

    @NotEmpty(message = "Wrong Last name")
    @NotBlank(message = "Wrong Last name")
    @Size(min = 2, message = "Wrong Last name")
    private String lastName;
    private String position;

    @NotEmpty(message = "Wrong Login")
    @NotBlank(message = "Wrong Login")
    @Size(min = 5, message = "Wrong Login")
    private String username;

    @NotEmpty(message = "Wrong Password")
    @NotBlank(message = "Wrong Password")
    @Size(min = 8, message = "Wrong Password")
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
