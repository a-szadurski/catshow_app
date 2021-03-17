package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.catshowapp.entities.ShowDates;

import java.time.LocalDate;
import java.util.List;

public interface ShowDatesRepository extends JpaRepository<ShowDates, Long> {

    @Query("SELECT sd FROM ShowDates sd WHERE sd.show.id=?1 order by sd.id")
    List<ShowDates> findShowDatesByShowId(Long id);

    @Query("SELECT sd FROM ShowDates sd WHERE sd.show.concluded=false AND sd.date >= ?1 " +
            "AND sd.show.published=true ORDER BY sd.date")
    List<ShowDates> findUpcomingShowsPublished(LocalDate today);

    @Query("SELECT sd FROM ShowDates sd WHERE sd.show.concluded=false AND sd.date < ?1 " +
            "AND sd.show.published=true ORDER BY sd.date")
    List<ShowDates> findPastShowsPublished(LocalDate today);

    @Query("SELECT sd FROM ShowDates sd WHERE sd.date >= ?1 ORDER BY sd.date")
    List<ShowDates> findAllUpcomingShows(LocalDate today);

    @Query("SELECT sd FROM ShowDates sd WHERE sd.date < ?1 ORDER BY sd.date")
    List<ShowDates> findAllPastShows(LocalDate today);
}
