package com.example.springmyitems.cantroller;

import com.example.springmyitems.entity.User;
import com.example.springmyitems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Controller
@Service
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String addUserPage() {
        return "saveUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/editUser/{id}")
    public String editUserPage(ModelMap map, @PathVariable("id") int id) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            map.addAttribute("user", userById.get());
            return "saveUser";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/searchUsers")
    public String searchUser(@ModelAttribute User user) {
        userRepository.searchUserByName("keyword");
        return "main";
    }



    ////////////////////////////////////////////


//    @GetMapping("/searchUser")
//    public String readAllUsers(@RequestParam(required = false, defaultValue = "") String search,
//            ModelMap map) {
//        Page<User> searchUser = userRepository.findByName(search);
//        map.addAttribute("url", "/searchUsers");
//        map.addAttribute("search", search);
//        return "main";
//    }


//    @PostMapping("/searchUser/{name}")
//    public String searchUser(ModelMap map, @PathVariable("name") String user) {
//        List<User> userByName = userRepository.findAllByName("name");
//        if (userByName.isEmpty()) {
//            map.addAttribute("user", userByName);
//            return "searchUser";
//        }else {
//            return "redirect:/";
//        }
//    }
//
//    public List<User> listAll(String keyword) {
//        if (keyword != null) {
//            return userRepository.search(keyword);
//        }
//        return (List<User>) userRepository.findAll();
//    }
//    @RequestMapping("/")
//    public String userHomePage(ModelMap map, @PathVariable("keyword") String keyword) {
//        List<User> userList = userRepository.search(keyword);
//        map.addAttribute("userList", userList);
//        map.addAttribute("keyword", keyword);
//
//        return "searchUser";
//    }
}
