package pl.coderslab.catshowapp.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Show;
import pl.coderslab.catshowapp.entities.ShowDates;
import pl.coderslab.catshowapp.repositories.ShowDatesRepository;
import pl.coderslab.catshowapp.repositories.ShowRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return "user/show-register";
    }

    @PostMapping
    public String saveShow(Show show) {
        Show savedShow = showRepository.save(show);
        return "redirect:/user/register/show/" + savedShow.getId();
    }

    @GetMapping("/{id}")
    public String assignDatesToShowDisplay(Model model, @PathVariable Long id) {
        Optional<Show> show = showRepository.findById(id);
        Show foundShow = new Show();
        int dateSum = 0;
        List<ShowDates> showDates = new ArrayList<>();


        if (show.isPresent()) {
            foundShow = show.get();
            dateSum = showDatesRepository.countShowDatesByShow(foundShow);
            showDates = showDatesRepository.findShowDatesByShow(foundShow);
            model.addAttribute("showId", id);
        }

        model.addAttribute("show", foundShow);
        model.addAttribute("dateSum", dateSum);
        model.addAttribute("dates", showDates);
        model.addAttribute("dateToAdd", new ShowDates());
        return "user/show-register-date";
    }

    @PostMapping("/{id}")
    public String assignDatesToShowAdd(@PathVariable Long id, ShowDates showDates) {

        showDatesRepository.save(showDates);
        return "redirect:/user/register/show/" + id;
    }
}
