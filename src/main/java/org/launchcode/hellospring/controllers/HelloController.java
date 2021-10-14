package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello, Spring!";
    }
    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {

        return "Goodbye, Spring!";
    }

    // lives at hello/hello
    //Handles request for form /hello?name= LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParams(@RequestParam String name){
        return "Hello " + name + "!";
    }


    //Handles request for form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParams(@PathVariable String name){
        return "Hello " + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
