package by.nagula.service.exception;

public class EmptyDataFromControllerException extends RuntimeException {

    public EmptyDataFromControllerException() {
    }

    public EmptyDataFromControllerException(String message) {
        super(message);
    }

    public EmptyDataFromControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyDataFromControllerException(Throwable cause) {
        super(cause);
    }

    public EmptyDataFromControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
