package pl.coderslab.catshowapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.catshowapp.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
