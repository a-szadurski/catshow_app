package pl.coderslab.catshowapp.controllers.user;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.catshowapp.entities.Judge;
import pl.coderslab.catshowapp.repositories.JudgeRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user/judge/register")
public class RegisterJudgeController {

    private final JudgeRepository judgeRepository;

    public RegisterJudgeController(JudgeRepository judgeRepository) {
        this.judgeRepository = judgeRepository;
    }

    @GetMapping
    public String displayForm(Model model) {

        List<Judge> judgeList = judgeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        model.addAttribute("judge", new Judge());
        model.addAttribute("judgesList", judgeList);

        return "user/judge-register";
    }

    @PostMapping
    public String saveJudge(Judge judge) {

        judgeRepository.save(judge);

        return "redirect:/user/judge/register" + judge.getId();
    }

    @GetMapping("/{id}")
    public String formSuccess(Model model, @PathVariable Long id) {
        Optional<Judge> optionalJudge = judgeRepository.findById(id);

        if (optionalJudge.isPresent()) {
            return "redirect:/user/judge/register";
        } else {
            model.addAttribute("objectType", "JUDGE");
            return "user/dahboard-save-error";
        }
    }
}
