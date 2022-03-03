package com.example.springmyitems.cantroller;

import com.example.springmyitems.entity.User;
import com.example.springmyitems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String main(ModelMap map){
        Iterable<User> users = userRepository.findAll();
        map.addAttribute("users",users);
        return "main";
    }
}
