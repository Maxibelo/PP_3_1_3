package ru.kata.spring.boot_security.PP_3_1_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.kata.spring.boot_security.PP_3_1_3.model.User;
import ru.kata.spring.boot_security.PP_3_1_3.repository.UserRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Service
@Validated
public class UsersDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UsersDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(s);

        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return user.get();

        //return user.get();
        //return new org.springframework.security.core.userdetails.User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), getGrantedAuth(user));
    }


}