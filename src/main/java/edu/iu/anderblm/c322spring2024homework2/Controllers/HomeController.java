package edu.iu.anderblm.c322spring2024homework2.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to c322-spring2024-homework2!";
    }
}
