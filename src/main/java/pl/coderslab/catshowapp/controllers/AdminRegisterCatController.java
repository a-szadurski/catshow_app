package pl.coderslab.catshowapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Cat;

@Controller
@RequestMapping("/user/admin/register/cat")
public class AdminRegisterCatController {

    @GetMapping
    public String displayForm(Model model){
        model.addAttribute(new Cat());
        return "user/admin/admin-register-cat";
    }
}
