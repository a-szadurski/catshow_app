package pl.coderslab.catshowapp.services;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.catshowapp.entities.Judge;
import pl.coderslab.catshowapp.entities.Show;
import pl.coderslab.catshowapp.repositories.JudgeRepository;
import pl.coderslab.catshowapp.repositories.ShowRepository;

import java.util.List;

@Getter
@Setter
public class RegisterJudgeDto {

    private JudgeRepository judgeRepository;
    private ShowRepository showRepository;

    private Judge judge;
    private List<Show> shows;
    private Show show;
}
