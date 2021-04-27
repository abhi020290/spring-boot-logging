package com.logging.resource;

import com.logging.exception.CustomExceptionOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import java.util.concurrent.ExecutionException;

@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

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
    @RequestMapping("errorStack")
    void errorStack() {

        try{
           int i = 10;
           int j = i /0;
        } catch (RuntimeException e){
           log.error(String.valueOf(e));
        }
    }

    @GetMapping(value = "/")
    public String test(){
        log.debug("debug message");
        log.info("This is an info message");
        log.warn("Warning for this application");
        log.error("Seems some error in the application");
        return "test";
    }
}
