package by.nagula.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Valid
public class UserDto {
    @NotEmpty(message = "Wrong First name")
    @NotBlank(message = "Wrong First name")
    @Size(min = 2, message = "Wrong First name")
    private String firstName;

    @NotEmpty(message = "Wrong Last name")
    @NotBlank(message = "Wrong Last name")
    @Size(min = 2, message = "Wrong Last name")
    private String lastName;

    @NotEmpty(message = "Wrong Password")
    @NotBlank(message = "Wrong Password")
    @Size(min = 8, message = "Wrong Password")
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
