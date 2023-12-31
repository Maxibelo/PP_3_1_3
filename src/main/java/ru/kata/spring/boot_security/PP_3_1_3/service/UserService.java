package ru.kata.spring.boot_security.PP_3_1_3.service;

import ru.kata.spring.boot_security.PP_3_1_3.model.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    List<User> index();

    User show(int id);

    User showOne(Principal principal);

    void delete(int id);

    void update(User user);

    void save(User user);

}