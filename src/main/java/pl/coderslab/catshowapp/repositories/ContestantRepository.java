package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.catshowapp.entities.Contestant;

public interface ContestantRepository extends JpaRepository<Contestant, Long> {
}
