package by.nagula.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ChatDto {
    @NotEmpty(message = "Chat is empty")
    @NotBlank(message = "Chat is empty")
    private String name;

    public ChatDto(String name) {
        this.name = name;
    }

    public ChatDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChatDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
