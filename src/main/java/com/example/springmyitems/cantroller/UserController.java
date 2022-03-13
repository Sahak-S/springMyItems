package com.example.springmyitems.cantroller;

import com.example.springmyitems.entity.User;
import com.example.springmyitems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String addUserPage() {
        return "saveUser";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/editUser/{id}")
    public String editUserPage(ModelMap map,
                               @PathVariable("id") int id) {
        map.addAttribute("user", userService.findById(id));
        return "saveUser";

    }



//    @GetMapping("/searchUsers")
//    public String searchUser(@ModelAttribute User user) {
//        userRepository.searchUserByName("keyword");
//        return "main";
//    }



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
