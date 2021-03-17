package pl.coderslab.catshowapp.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Show;
import pl.coderslab.catshowapp.repositories.ShowDatesRepository;
import pl.coderslab.catshowapp.repositories.ShowRepository;

@Controller
@RequestMapping("user/register/show")
public class RegisterShowController {

    private ShowRepository showRepository;
    private ShowDatesRepository showDatesRepository;

    public RegisterShowController(ShowRepository showRepository, ShowDatesRepository showDatesRepository) {
        this.showRepository = showRepository;
        this.showDatesRepository = showDatesRepository;
    }

    @GetMapping
    public String displayForm(Model model) {
        model.addAttribute("show", new Show());
        return "user/register-show";
    }
}
