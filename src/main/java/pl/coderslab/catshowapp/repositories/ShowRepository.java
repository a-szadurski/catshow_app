package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.catshowapp.entities.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query(value = "select * from shows where concluded = true ORDER BY show_id DESC limit 1",
            nativeQuery = true)
    Show latestShowConcluded();

    @Query(value = "SELECT * FROM shows WHERE concluded = false ORDER BY show_id ASC LIMIT 1",
            nativeQuery = true)
    Show upcomingShowClosest();
}
