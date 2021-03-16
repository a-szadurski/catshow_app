package pl.coderslab.catshowapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.catshowapp.entities.User;
import pl.coderslab.catshowapp.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


// --creating test users--

//    @GetMapping("/create-user")
//    @ResponseBody
//    public String createUser() {
//        User user = new User();
//        user.setEmail("admin");
//        user.setPassword("adminCatShow");
//        userService.saveUser(user);
//
//        User user2 = new User();
//        user2.setEmail("user");
//        user2.setPassword("userCatShow");
//        userService.saveUser(user2);
//
//        return "admin, user";
//    }
}
