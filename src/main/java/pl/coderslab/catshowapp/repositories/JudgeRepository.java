package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.catshowapp.entities.Judge;

public interface JudgeRepository extends JpaRepository<Judge, Long> {
}
