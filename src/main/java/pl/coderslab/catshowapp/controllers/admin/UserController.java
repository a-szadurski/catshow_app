package pl.coderslab.catshowapp.controllers.admin;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.User;
import pl.coderslab.catshowapp.services.UserService;

@Controller
@RequestMapping("/admin/user/register")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayForm(Model model) {

        model.addAttribute("usersList", userService.findAll(Sort.by(Sort.Direction.DESC, "id")));
        model.addAttribute("user", new User());

        return "user/admin/user-register";
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
