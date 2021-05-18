package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControleer {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
