package pl.coderslab.catshowapp.controllers.user;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Cat;
import pl.coderslab.catshowapp.repositories.CatRepository;
import pl.coderslab.catshowapp.repositories.ContestantRepository;
import pl.coderslab.catshowapp.repositories.ExhibitorRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user/cat/register")
public class RegisterCatController {

    public final CatRepository catRepository;
    public final ExhibitorRepository exhibitorRepository;
    public final ContestantRepository contestantRepository;

    public RegisterCatController(CatRepository catRepository, ExhibitorRepository exhibitorRepository, ContestantRepository contestantRepository) {
        this.catRepository = catRepository;
        this.exhibitorRepository = exhibitorRepository;
        this.contestantRepository = contestantRepository;
    }

    @GetMapping
    public String displayForm(Model model) {

        List<Cat> catsList = catRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("catsList", catsList);
        model.addAttribute("cat", new Cat());

        return "user/cat-register";
    }

    @PostMapping
    public String submitForm(Cat cat) {

        catRepository.save(cat);

        return "redirect:/user/cat/register/" + cat.getId();
    }

    @GetMapping("/{id}")
    public String formSuccess(Model model, @PathVariable Long id) {

        Optional<Cat> optionalCat = catRepository.findById(id);

        if (optionalCat.isPresent()) {
            return "redirect:/user/cat/register";
        } else {
            model.addAttribute("objectType", "CAT");
            return "user/dahboard-save-error";
        }

    }


}
