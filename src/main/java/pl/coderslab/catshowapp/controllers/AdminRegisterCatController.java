package pl.coderslab.catshowapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.repositories.CatRepository;
import pl.coderslab.catshowapp.repositories.ContestantRepository;
import pl.coderslab.catshowapp.repositories.ExhibitorRepository;
import pl.coderslab.catshowapp.services.RegisterCatCmd;

@Controller
@RequestMapping("/user/register/cat")
public class AdminRegisterCatController {

    CatRepository catRepository;
    ExhibitorRepository exhibitorRepository;
    ContestantRepository contestantRepository;

    public AdminRegisterCatController(CatRepository catRepository, ExhibitorRepository exhibitorRepository,
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
    public String submitForm( RegisterCatCmd registerCatCmd) {

        catRepository.save(registerCatCmd.getCat());
        exhibitorRepository.save(registerCatCmd.getExhibitor());
        return "user/cat-register-success";

    }
}
