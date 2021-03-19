package pl.coderslab.catshowapp.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Cat;
import pl.coderslab.catshowapp.entities.Contestant;
import pl.coderslab.catshowapp.entities.Exhibitor;
import pl.coderslab.catshowapp.repositories.CatRepository;
import pl.coderslab.catshowapp.repositories.ContestantRepository;
import pl.coderslab.catshowapp.repositories.ExhibitorRepository;
import pl.coderslab.catshowapp.services.RegisterCatDto;

import java.util.Optional;

@Controller
@RequestMapping("/user/register/cat")
public class RegisterCatController {

    CatRepository catRepository;
    ExhibitorRepository exhibitorRepository;
    ContestantRepository contestantRepository;

    @GetMapping
    public String displayForm(Model model) {
        model.addAttribute(new RegisterCatDto());
        return "user/user-register-cat";
    }

    @PostMapping
    public String submitForm(RegisterCatDto registerCatDto) {

        Cat cat = catRepository.save(registerCatDto.getCat());
        Exhibitor exhibitor = exhibitorRepository.save(registerCatDto.getExhibitor());
        Contestant contestant = new Contestant();
        registerCatDto.setContestant(contestant);
        contestant.setCat(cat);
        contestant.setExhibitor(exhibitor);
        contestantRepository.save(contestant);
        return "redirect:/user/register/cat/" + cat.getId();
    }

    @GetMapping("/{id}")
    public String formSuccess(Model model, @PathVariable Long id){
        Optional<Cat> optionalCat = catRepository.findById(id);
        Cat cat = new Cat();

        if(optionalCat.isPresent()){
            model.addAttribute("cat", cat);
            return "user/cat-register-success";
        } else {
            return "user/dahboard-save-error";
        }

    }


}
