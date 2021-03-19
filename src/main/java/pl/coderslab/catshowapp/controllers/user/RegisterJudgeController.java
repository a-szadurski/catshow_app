package pl.coderslab.catshowapp.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Judge;
import pl.coderslab.catshowapp.repositories.JudgeRepository;

import java.util.Optional;

@Controller
@RequestMapping("/user/register/judge")
public class RegisterJudgeController {

    private JudgeRepository judgeRepository;

    public RegisterJudgeController(JudgeRepository judgeRepository) {
        this.judgeRepository = judgeRepository;
    }

    @GetMapping
    public String displayForm(Model model) {

        model.addAttribute("judge", new Judge());
        return "user/register-judge";
    }

    @PostMapping
    public String saveJudge(Judge judge) {
        judgeRepository.save(judge);
        return "redirect:/user/register/judge/" + judge.getId();
    }

    @GetMapping("/{id}")
    public String formSuccess(Model model, @PathVariable Long id) {
        Optional<Judge> optionalJudge = judgeRepository.findById(id);
        Judge judge = new Judge();

        if (optionalJudge.isPresent()) {
            model.addAttribute("judge", judge);
            return "user/judge-register-success";
        } else {
            model.addAttribute("objectType", "JUDGE");
            return "user/dahboard-save-error";
        }
    }
}
