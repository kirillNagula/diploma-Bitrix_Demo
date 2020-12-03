package by.nagula.dto;

public class CommentDto {
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
