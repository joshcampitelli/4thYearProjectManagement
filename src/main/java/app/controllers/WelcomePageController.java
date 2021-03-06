package app.controllers;

import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import app.repositories.UserRepository;

import javax.servlet.http.HttpServletResponse;

@Controller
public class WelcomePageController{

    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String welcome(HttpServletResponse response, Model model){

//        model.addAttribute("user", temp);
        model.addAttribute("view", "index");
        return "layout";
    }
}
