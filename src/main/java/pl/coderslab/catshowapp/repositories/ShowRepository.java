package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.catshowapp.entities.Show;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    @Query(value = "SELECT * FROM shows WHERE concluded = TRUE ORDER BY show_id DESC limit 1",
            nativeQuery = true)
    Show latestShowConcluded();

    @Query(value = "SELECT * FROM shows WHERE concluded = FALSE ORDER BY show_id ASC LIMIT 1",
            nativeQuery = true)
    Show upcomingShowClosest();

    @Query("SELECT sd.show FROM ShowDates sd WHERE sd.date >= ?1 ORDER BY sd.date")
    List<Show> findAllUpcomingShows(LocalDate today);
}
