package by.nagula.dto;

public class ChatUserDto {
    private long userId;

    public ChatUserDto(long userId) {
        this.userId = userId;
    }

    public ChatUserDto() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
