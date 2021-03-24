package pl.coderslab.catshowapp.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.catshowapp.entities.Show;
import pl.coderslab.catshowapp.entities.ShowDates;
import pl.coderslab.catshowapp.repositories.ShowDatesRepository;
import pl.coderslab.catshowapp.repositories.ShowRepository;

import javax.validation.Valid;
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
    public String saveShow(@Valid Show show, BindingResult result) {

        if (result.hasErrors()) {
            return "user/show-register";
        }

        Show savedShow = showRepository.save(show);
        return "redirect:/user/show/register/" + savedShow.getId();
    }

    @GetMapping("/{id}")
    public String assignDatesToShowDisplay(Model model, @PathVariable Long id) {

        Optional<Show> show = showRepository.findById(id);

        if (show.isPresent()) {
            model.addAttribute("show", show.get());
            model.addAttribute("dateSum", showDatesRepository.countShowDatesByShow(show.get()));
            model.addAttribute("dates", showDatesRepository.findShowDatesByShow(show.get()));
            model.addAttribute("dateToAdd", new ShowDates());
            return "user/show-register-date";
        }
        return "user/show-register-date";
    }

    @PostMapping("/{id}")
    public String assignDatesToShowExecute(Model model, @PathVariable Long id,
                                           @Valid @ModelAttribute("dateToAdd") ShowDates showDates,
                                           BindingResult result) {

        if (result.hasErrors()) {
            Optional<Show> show = showRepository.findById(id);
            if (show.isPresent()) {
                model.addAttribute("show", show.get());
                model.addAttribute("dateSum", showDatesRepository.countShowDatesByShow(show.get()));
                model.addAttribute("dates", showDatesRepository.findShowDatesByShow(show.get()));
                return "user/show-register-date";
            }
        }

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
