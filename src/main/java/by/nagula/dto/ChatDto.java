package by.nagula.dto;


public class ChatDto {
    private String name;
    private long userId;

    public ChatDto(String name, long userId) {
        this.name = name;
        this.userId = userId;
    }

    public ChatDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ChatDto{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
