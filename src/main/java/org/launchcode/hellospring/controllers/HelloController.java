package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*To know to handle HTTP requests*/
@Controller
@ResponseBody
@RequestMapping("hello") //any additional getmapping will be a subfolder
public class HelloController {
   /*  Handles requests at /hello (lives at this path)
    @GetMapping ("hello2") //specifies the method should use getrequests
    @ResponseBody //will return a plain HTML response
    public String hello(){
        return "Hello, Spring!";
    }*/

    @GetMapping ("goodbye") /*specifies the method should use getrequests*/
    //@ResponseBody /*will return a plain HTML response*/
    public String goodbye(){
        return "Goodbye, Spring!";
    }

//Handle that requests form /hello?name=LaunchCode
    @RequestMapping (method = {RequestMethod.GET, RequestMethod.POST}/*, value = "hello"*/) //handles both Get and Post requests
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping ("{name}")
    public String helloWithPath(@PathVariable String name){
        return "Hello, " + name + "!!";
    }

//to display the form
    @GetMapping ("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello'>" + //submits a request to /hello
                "<input type = 'text' name='name' label = 'Name'>" +
                "<input type = 'submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
