package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.catshowapp.entities.ShowDates;

import java.util.List;

public interface ShowDatesRepository extends JpaRepository<ShowDates, Long> {

//    @Query(value="SELECT show_date_id FROM show_dates WHERE show_id = ?1",
//            nativeQuery = true)
//    List<Long> findShowDatesByShowId(Long id);

    @Query("SELECT sd FROM ShowDates sd WHERE sd.id=?1 order by sd.id")
    List<ShowDates> findShowDatesByShowId(Long id);
}
