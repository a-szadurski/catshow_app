package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.catshowapp.entities.Exhibitor;

public interface ExhibitorRepository extends JpaRepository<Exhibitor, Long> {
}
