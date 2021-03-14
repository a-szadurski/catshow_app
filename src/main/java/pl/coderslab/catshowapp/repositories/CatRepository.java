package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.catshowapp.entities.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
