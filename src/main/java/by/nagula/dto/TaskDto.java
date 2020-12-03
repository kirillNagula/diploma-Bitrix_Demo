package by.nagula.dto;

public class TaskDto {
    private String taskText;
    private long authorId;
    private long executorId;
    private String dateTime;

    public TaskDto() {
    }

    public TaskDto(String taskText, long authorId, long executorId, String dateTime) {
        this.taskText = taskText;
        this.authorId = authorId;
        this.executorId = executorId;
        this.dateTime = dateTime;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getExecutorId() {
        return executorId;
    }

    public void setExecutorId(long executorId) {
        this.executorId = executorId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "taskText='" + taskText + '\'' +
                ", authorId=" + authorId +
                ", executorId=" + executorId +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
