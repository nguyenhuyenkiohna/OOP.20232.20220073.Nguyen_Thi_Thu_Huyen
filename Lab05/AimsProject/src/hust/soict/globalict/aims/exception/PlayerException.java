package hust.soict.globalict.aims.exception;

public class PlayerException extends Exception{
    public PlayerException(String s){
        System.err.println(s);
    }
    public PlayerException(String message, Throwable cause){
        super(message, cause);
    }
    public PlayerException(Throwable cause){
        super(cause);
    }
    public PlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}