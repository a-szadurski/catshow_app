package pl.coderslab.catshowapp.services;

import org.springframework.data.domain.Sort;
import pl.coderslab.catshowapp.entities.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);

    void saveUser(User user);

    List<User> findAll(Sort sort);
}