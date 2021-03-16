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
@RequestMapping("/user/register/cat")
public class UserRegisterCatController {

    CatRepository catRepository;
    ExhibitorRepository exhibitorRepository;
    ContestantRepository contestantRepository;

    public UserRegisterCatController(CatRepository catRepository, ExhibitorRepository exhibitorRepository,
                                     ContestantRepository contestantRepository) {
        this.catRepository = catRepository;
        this.exhibitorRepository = exhibitorRepository;
        this.contestantRepository = contestantRepository;
    }

    @GetMapping
    public String displayForm(Model model) {
        model.addAttribute(new RegisterCatCmd());
        return "user/user-register-cat";
    }

    @PostMapping
    public String submitForm( RegisterCatCmd registerCatCmd, Contestant contestant) {

        Cat cat = catRepository.save(registerCatCmd.getCat());
        Exhibitor exhibitor =exhibitorRepository.save(registerCatCmd.getExhibitor());
        contestant = new Contestant();
        registerCatCmd.setContestant(contestant);
        contestant.setCat(cat);
        contestant.setExhibitor(exhibitor);
        contestantRepository.save(contestant);
        return "user/cat-register-success";

    }
}
