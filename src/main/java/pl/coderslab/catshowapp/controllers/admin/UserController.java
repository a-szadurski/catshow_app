package pl.coderslab.catshowapp.controllers.admin;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.exceptions.UserAlreadyExistException;
import pl.coderslab.catshowapp.services.UserDto;
import pl.coderslab.catshowapp.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/users/add")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayForm(Model model) {

        model.addAttribute("usersList", userService.findAll(Sort.by(Sort.Direction.DESC, "id")));
        model.addAttribute("user", new UserDto());

        return "user/admin/user-register";
    }

    @PostMapping
    public String registerUser(Model model, @Valid @ModelAttribute("user") UserDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("usersList", userService.findAll(Sort.by(Sort.Direction.DESC, "id")));
            return "user/admin/user-register";
        }

        try {
            userService.saveUser(userDto);
            model.addAttribute("usersList", userService.findAll(Sort.by(Sort.Direction.DESC, "id")));
            model.addAttribute("user", new UserDto());
        } catch (UserAlreadyExistException e) {
            model.addAttribute("existsMessage", "User with this email already exists.");
            model.addAttribute("usersList", userService.findAll(Sort.by(Sort.Direction.DESC, "id")));
            model.addAttribute("user", new UserDto());
            return "user/admin/user-register";
        }
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
