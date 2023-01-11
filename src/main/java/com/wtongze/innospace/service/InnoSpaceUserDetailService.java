package com.wtongze.innospace.service;

import com.wtongze.innospace.entity.User;
import com.wtongze.innospace.model.InnoSpaceUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InnoSpaceUserDetailService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public InnoSpaceUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findById(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found."));
        return user.map(InnoSpaceUserDetails::new).get();
    }
}
