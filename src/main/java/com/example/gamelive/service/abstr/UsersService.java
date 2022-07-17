package com.example.gamelive.service.abstr;

import com.example.gamelive.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    User save(User user);
}
