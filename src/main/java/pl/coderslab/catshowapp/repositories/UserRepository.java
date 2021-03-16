package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.catshowapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
