package by.nagula.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Valid
public class UserDto {
    @NotEmpty(message = "First name is empty")
    @NotBlank(message = "First name is empty")
    @Size(min = 2, message = "First name lesser then 2 char")
    private String firstName;

    @NotEmpty(message = "Last name is empty")
    @NotBlank(message = "Last name is empty")
    @Size(min = 2, message = "Last name lesser then 2 char")
    private String lastName;

    @NotEmpty(message = "Password is empty")
    @NotBlank(message = "Password is empty")
    @Size(min = 8, message = "Password must be greater then 8 char!")
    private String password;

    public UserDto(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public UserDto() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
