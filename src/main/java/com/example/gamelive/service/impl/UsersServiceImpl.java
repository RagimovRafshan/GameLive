package com.example.gamelive.service.impl;

import com.example.gamelive.dao.UserRepository;
import com.example.gamelive.model.entity.User;
import com.example.gamelive.service.abstr.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    private UserRepository userRepository;

    @Autowired
    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.getUserByUsername(username);
        if(user.isPresent()) {
            return userRepository.getUserByUsername(username).get();
        } else {
            throw new UsernameNotFoundException("Error: User not found by username");
        }
    }
}
