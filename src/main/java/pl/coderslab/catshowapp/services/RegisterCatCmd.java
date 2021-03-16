package pl.coderslab.catshowapp.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.coderslab.catshowapp.entities.Cat;
import pl.coderslab.catshowapp.entities.Contestant;
import pl.coderslab.catshowapp.entities.Exhibitor;
import pl.coderslab.catshowapp.repositories.CatRepository;
import pl.coderslab.catshowapp.repositories.ContestantRepository;
import pl.coderslab.catshowapp.repositories.ExhibitorRepository;

@Getter
@Setter
public class RegisterCatCmd {


    private CatRepository catRepository;
    private ContestantRepository contestantRepository;
    private ExhibitorRepository exhibitorRepository;

    private Cat cat;
    private Contestant contestant;
    private Exhibitor exhibitor;

}
