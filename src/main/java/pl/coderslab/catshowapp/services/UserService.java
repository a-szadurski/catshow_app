package pl.coderslab.catshowapp.services;

import pl.coderslab.catshowapp.entities.User;

public interface UserService {

    User findByEmail(String email);

    void saveUser(User user);
}