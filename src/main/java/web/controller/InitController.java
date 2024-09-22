package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {

    @GetMapping(value = "/")
    public String init() {
        return "redirect:/users";
    }
}