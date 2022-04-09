package az.softsolution.bookingsystem.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }
}
