package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.catshowapp.entities.ShowDates;

public interface ShowDatesRepository extends JpaRepository<ShowDates, Long> {
}
