package springbootexception.springbootexception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

@RestController
public class DemoController {

    @RequestMapping("exception")
    String exception(){
        throw new RuntimeException("From method exception");
    }

    @RequestMapping("custom")
    String customExceptionOne() throws CustomExceptionOne {
        throw new CustomExceptionOne("From customExceptionOne exception");
    }

    @RequestMapping("access")
    String customExceptionTwo() throws ResourceAccessException {
        throw new ResourceAccessException("From ResourceAccessException exception");
    }
}
