package com.yellowmovement.site.services;

import com.yellowmovement.site.security.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findUserByEmail(String email);
    void saveUser(User user);
}
