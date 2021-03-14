package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.catshowapp.entities.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
