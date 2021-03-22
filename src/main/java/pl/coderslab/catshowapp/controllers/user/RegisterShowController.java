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
@RequestMapping("user/show/register")
public class RegisterShowController {

    private final ShowRepository showRepository;
    private final ShowDatesRepository showDatesRepository;

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
        return "redirect:/user/show/register/" + savedShow.getId();
    }

    @GetMapping("/{id}")
    public String assignDatesToShowDisplay(Model model, @PathVariable Long id) {

        Optional<Show> show = showRepository.findById(id);
        Show foundShow;
        int dateSum;
        List<ShowDates> showDatesList;


        if (show.isPresent()) {

            foundShow = show.get();
            dateSum = showDatesRepository.countShowDatesByShow(foundShow);
            showDatesList = showDatesRepository.findShowDatesByShow(foundShow);

            model.addAttribute("show", foundShow);
            model.addAttribute("dateSum", dateSum);
            model.addAttribute("dates", showDatesList);
            model.addAttribute("dateToAdd", new ShowDates());
            return "user/show-register-date";
        }
        return "user/show-register-date";
    }

    @PostMapping("/{id}")
    public String assignDatesToShowExecute(Model model, @PathVariable Long id, ShowDates showDates) {

        Optional<Show> optionalShow = showRepository.findById(id);
        Show show;

        if (optionalShow.isPresent()) {
            System.out.println(showDates);
            show = optionalShow.get();
            showDates.setShow(show);
            showDates.setId(null);
            showDatesRepository.save(showDates);
            return "redirect:/user/show/register/" + id;
        } else {
            model.addAttribute("objectType", "SHOW DATE");
            return "user/dahboard-save-error";
        }

    }
}
