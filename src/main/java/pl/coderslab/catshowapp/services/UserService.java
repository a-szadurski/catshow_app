package pl.coderslab.catshowapp.services;

import pl.coderslab.catshowapp.entities.User;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}