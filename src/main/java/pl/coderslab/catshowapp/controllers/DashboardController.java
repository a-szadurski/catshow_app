package pl.coderslab.catshowapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Cat;
import pl.coderslab.catshowapp.entities.Contestant;
import pl.coderslab.catshowapp.entities.Exhibitor;
import pl.coderslab.catshowapp.repositories.CatRepository;
import pl.coderslab.catshowapp.repositories.ContestantRepository;
import pl.coderslab.catshowapp.repositories.ExhibitorRepository;
import pl.coderslab.catshowapp.services.RegisterCatCmd;

@Controller
@RequestMapping("/user/dashboard")
public class DashboardController {

    private CatRepository catRepository;
    private ExhibitorRepository exhibitorRepository;
    private ContestantRepository contestantRepository;

    public DashboardController(CatRepository catRepository, ExhibitorRepository exhibitorRepository,
                               ContestantRepository contestantRepository) {
        this.catRepository = catRepository;
        this.exhibitorRepository = exhibitorRepository;
        this.contestantRepository = contestantRepository;
    }

    @GetMapping("/main")
    public String dashboardMainDisplay() {
        return "user/dashboard-main";
    }

    @GetMapping("/register/cat")
    public String displayForm(Model model) {
        model.addAttribute(new RegisterCatCmd());
        return "user/user-register-cat";
    }

    @PostMapping("/register/cat")
    public String submitForm(RegisterCatCmd registerCatCmd) {

        Cat cat = catRepository.save(registerCatCmd.getCat());
        Exhibitor exhibitor = exhibitorRepository.save(registerCatCmd.getExhibitor());
        Contestant contestant = new Contestant();
        registerCatCmd.setContestant(contestant);
        contestant.setCat(cat);
        contestant.setExhibitor(exhibitor);
        contestantRepository.save(contestant);
        return "user/cat-register-success";

    }

}
