package pl.coderslab.catshowapp.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.ShowDates;
import pl.coderslab.catshowapp.repositories.ShowDatesRepository;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/user/main")
public class OverviewController {

    private ShowDatesRepository showDatesRepository;

    public OverviewController(ShowDatesRepository showDatesRepository) {
        this.showDatesRepository = showDatesRepository;
    }

    @GetMapping
    public String dashboardMainDisplay(Model model) {

        List<ShowDates> upcomingAllShowDates = showDatesRepository.findAllUpcomingShows(LocalDate.now());
        List<ShowDates> pastAllShowDates = showDatesRepository.findAllPastShows(LocalDate.now());

        model.addAttribute("upcomingAllShowDates", upcomingAllShowDates);
        model.addAttribute("pastAllShowDates", pastAllShowDates);

        return "user/dashboard-main";
    }


}
