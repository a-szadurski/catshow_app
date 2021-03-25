package pl.coderslab.catshowapp.controllers.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Cat;
import pl.coderslab.catshowapp.repositories.CatRepository;
import pl.coderslab.catshowapp.repositories.ContestantRepository;
import pl.coderslab.catshowapp.repositories.ExhibitorRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/cat/register")
public class RegisterCatController {

    public final CatRepository catRepository;
    public final ExhibitorRepository exhibitorRepository;
    public final ContestantRepository contestantRepository;
    final Logger logger
            = LoggerFactory.getLogger(this.getClass());

    public RegisterCatController(CatRepository catRepository, ExhibitorRepository exhibitorRepository,
                                 ContestantRepository contestantRepository) {

        this.catRepository = catRepository;
        this.exhibitorRepository = exhibitorRepository;
        this.contestantRepository = contestantRepository;

    }

    @GetMapping
    public String displayForm(Model model) {

        model.addAttribute("catsList", catRepository.findAll(Sort.by(Sort.Direction.DESC, "id")));
        model.addAttribute("cat", new Cat());

        return "user/cat-register";
    }

    @PostMapping
    public String submitForm(Model model, @Valid Cat cat, BindingResult result) {

        if (result.hasErrors()) {

            model.addAttribute("catsList", catRepository.findAll(Sort.by(Sort.Direction.DESC, "id")));
            logger.debug("RegisterCat binding result: " + cat.toString());
            return "user/cat-register";
        }

        catRepository.save(cat);
        model.addAttribute("catsList", catRepository.findAll(Sort.by(Sort.Direction.DESC, "id")));
        model.addAttribute("cat", new Cat());

        return "user/cat-register";
    }


}
