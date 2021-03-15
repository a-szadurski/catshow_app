package pl.coderslab.catshowapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Contestant;
import pl.coderslab.catshowapp.entities.Show;
import pl.coderslab.catshowapp.entities.ShowDates;
import pl.coderslab.catshowapp.repositories.ContestantRepository;
import pl.coderslab.catshowapp.repositories.ShowDatesRepository;
import pl.coderslab.catshowapp.repositories.ShowRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private ContestantRepository contestantRepository;
    private ShowRepository showRepository;
    private ShowDatesRepository showDatesRepository;

    public HomeController(ContestantRepository contestantRepository, ShowRepository showRepository,
                          ShowDatesRepository showDatesRepository) {
        this.contestantRepository = contestantRepository;
        this.showRepository = showRepository;
        this.showDatesRepository = showDatesRepository;
    }

    @GetMapping
    public String startPage(Model model) {
        Show upcomingClosest = showRepository.upcomingShowClosest();
        List<ShowDates> upcomingDates = showDatesRepository.findShowDatesByShowId(upcomingClosest.getId());
        Show latestIdConcluded = showRepository.latestShowConcluded();
        List<ShowDates> latestDates = showDatesRepository.findShowDatesByShowId(latestIdConcluded.getId());
        List<Contestant> contestants = new ArrayList<>();
        for (ShowDates latestDate : latestDates) {
            contestants.addAll(contestantRepository.getContestantsByShowDateId(latestDate.getId()));
        }

        model.addAttribute("upcomingShow", upcomingClosest);
        model.addAttribute("upcomingDates", upcomingDates);
        model.addAttribute("latestShow", latestIdConcluded);
        model.addAttribute("latestDates", latestDates);
        model.addAttribute("contestants", contestants);
        return "public/home";
    }
}
