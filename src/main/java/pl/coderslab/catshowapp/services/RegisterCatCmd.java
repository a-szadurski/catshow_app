package pl.coderslab.catshowapp.services;

import lombok.Getter;
import pl.coderslab.catshowapp.entities.Cat;
import pl.coderslab.catshowapp.entities.Contestant;
import pl.coderslab.catshowapp.entities.Exhibitor;
import pl.coderslab.catshowapp.repositories.CatRepository;
import pl.coderslab.catshowapp.repositories.ContestantRepository;
import pl.coderslab.catshowapp.repositories.ExhibitorRepository;

@Getter
public class RegisterCatCmd {


    private CatRepository catRepository;
    private ContestantRepository contestantRepository;
    private ExhibitorRepository exhibitorRepository;

    private Cat cat;
    private Contestant contestant;
    private Exhibitor exhibitor;

    public void setCatRepository(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void setContestantRepository(ContestantRepository contestantRepository) {
        this.contestantRepository = contestantRepository;
    }

    public void setExhibitorRepository(ExhibitorRepository exhibitorRepository) {
        this.exhibitorRepository = exhibitorRepository;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public void setContestant(Contestant contestant) {
        this.contestant = contestant;
    }

    public void setExhibitor(Exhibitor exhibitor) {
        this.exhibitor = exhibitor;
    }
}
