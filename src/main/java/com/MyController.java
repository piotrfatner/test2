package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(){
        return new Greeting("Hello Vegas!");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginMethod(){
        return "hello";
    }
}
