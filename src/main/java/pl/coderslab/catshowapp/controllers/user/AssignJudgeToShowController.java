package pl.coderslab.catshowapp.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Judge;
import pl.coderslab.catshowapp.entities.ShowDates;
import pl.coderslab.catshowapp.repositories.JudgeRepository;
import pl.coderslab.catshowapp.repositories.ShowDatesRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user/judge/assign/show")
public class AssignJudgeToShowController {

    private final JudgeRepository judgeRepository;
    private final ShowDatesRepository showDatesRepository;

    public AssignJudgeToShowController(JudgeRepository judgeRepository, ShowDatesRepository showDatesRepository) {
        this.judgeRepository = judgeRepository;
        this.showDatesRepository = showDatesRepository;
    }

    @GetMapping
    public String selectJudge(Model model) {
        model.addAttribute("judgesList", judgeRepository.findAll());
        model.addAttribute("judge", new Judge());
        return "user/judge-select-judge";
    }

    @GetMapping("/{id}")
    public String selectShow(Model model, @PathVariable Long id) {

        Optional<Judge> optionalJudge = judgeRepository.findById(id);
        Judge judge;

        if (optionalJudge.isPresent()) {

            judge = optionalJudge.get();
            model.addAttribute("judge", judge);
            List<ShowDates> upcomingAllShowDates = showDatesRepository.findAllUpcomingShows(LocalDate.now());
            model.addAttribute("upcomingAllShowDates", upcomingAllShowDates);
            model.addAttribute("showDates", new ShowDates());

            return "user/judge-select-show";
        } else {
            return "user/dahboard-select-error";
        }
    }

    @PostMapping("/{id}")
    public String selectShowExecute(Model model, ShowDates showDates, @PathVariable Long id) {

        Optional<Judge> optionalJudge = judgeRepository.findById(id);
        Judge judge;

        if (optionalJudge.isPresent()) {

            judge = optionalJudge.get();
            model.addAttribute("judge", judge);
            List<ShowDates> upcomingAllShowDates = showDatesRepository.findAllUpcomingShows(LocalDate.now());
            model.addAttribute("upcomingAllShowDates", upcomingAllShowDates);
            model.addAttribute("showDates", new ShowDates());

            Optional<ShowDates> optionalShowDates = showDatesRepository.findShowDatesById(showDates.getId());
            Set<ShowDates> judgeDates = judge.getShowDates().stream()
                    .filter(showDates1 -> showDates1.getDate().isAfter(LocalDate.now()))
                    .collect(Collectors.toSet());

            model.addAttribute("judgeDates", judgeDates);

            if (optionalShowDates.isPresent()) {

                showDates = optionalShowDates.get();
                showDates.getJudges().add(judge);
                showDatesRepository.save(showDates);
            }

            return "user/judge-select-show";
        } else {
            return "user/dahboard-select-error";
        }
    }
}
