package by.nagula.service.exception;

public class NoUserById extends RuntimeException {
    public NoUserById() {
    }

    public NoUserById(String message) {
        super(message);
    }

    public NoUserById(String message, Throwable cause) {
        super(message, cause);
    }

    public NoUserById(Throwable cause) {
        super(cause);
    }

    public NoUserById(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
