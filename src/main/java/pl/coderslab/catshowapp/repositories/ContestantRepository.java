package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.catshowapp.entities.Contestant;

import java.util.List;

public interface ContestantRepository extends JpaRepository<Contestant, Long> {

    @Query("SELECT c from Contestant c WHERE c.showDate.id = ?1 ORDER BY c.cat.ems")
    List<Contestant> getContestantsByShowDateId(Long id);
}
