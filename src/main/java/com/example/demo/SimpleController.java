package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SimpleController {

    @Autowired
    private IUserService userService;

    @GetMapping("/showUsers")
    public String findUsers(Model model) {
        model.addAttribute("usersArray", userService.findAll());
        return "showUsers";
    }

    @GetMapping("/countUsers")
    public String countUsers(Model model) {
        model.addAttribute("count", userService.count());
        return "countUsers";
    }
}
