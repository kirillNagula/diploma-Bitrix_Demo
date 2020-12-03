package by.nagula.service.exception;

public class NoChatException extends RuntimeException {

    public NoChatException() {
    }

    public NoChatException(String message) {
        super(message);
    }

    public NoChatException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoChatException(Throwable cause) {
        super(cause);
    }

    public NoChatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
