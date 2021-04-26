package springbootexception.springbootexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorDetails getRuntimeException(RuntimeException ex){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode("5000");
        errorDetails.setErrorMessage(ex.getMessage());
        return errorDetails;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomExceptionOne.class)
    ErrorDetails getCustomExceptionOne(CustomExceptionOne ex){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode("5001");
        errorDetails.setErrorMessage(ex.getMessage());
        return errorDetails;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResourceAccessException.class)
    ErrorDetails getIllegalArgumentException(ResourceAccessException ex){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode("5002");
        errorDetails.setErrorMessage(ex.getMessage());
        return errorDetails;

    }

}
