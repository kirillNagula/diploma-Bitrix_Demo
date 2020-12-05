package by.nagula.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CommentDto {
    @NotEmpty(message = "Comment is empty")
    @NotBlank(message = "Comment is empty")
    public String message;

    public CommentDto(String message) {
        this.message = message;
    }

    public CommentDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
