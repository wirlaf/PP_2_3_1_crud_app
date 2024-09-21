package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String printCars(ModelMap model) {

        userService.add(new User("Ivan", "Deduskin", "ivan@mail.ru"));
        userService.add(new User("Maria", "Babushkina", "maria@mail.ru"));
        userService.add(new User("Pavel", "Lisicin", "pavel4@mail.ru"));
        userService.add(new User("Artur", "Kolobkov", "artur@mail.ru"));

        model.addAttribute("users", userService.listUsers());
        return "user";
    }
}
