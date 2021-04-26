package springbootexception.springbootexception;

public class CustomExceptionOne extends Throwable{

    private String message;

    public CustomExceptionOne(String message) {
        this.message = message;
    }
}
