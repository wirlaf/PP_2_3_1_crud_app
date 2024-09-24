package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listUsers(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/")
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "/edit";
    }

    @PostMapping("/")
    public String update(@ModelAttribute("user") User user, @RequestParam Long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @GetMapping("/delete/")
    public String delete(@RequestParam Long id, Model model) {
        userService.delete(id);
        model.addAttribute("user", userService.listUsers());
        return "redirect:/users";
    }
}
