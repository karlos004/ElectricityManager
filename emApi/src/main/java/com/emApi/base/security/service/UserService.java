package com.emApi.base.security.service;

import com.emApi.base.security.dao.UserDAO;
import com.emApi.base.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
public class UserService implements UserDetailsService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(s);
        if(user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User: " + s + " not found.");
    }

    @Transactional
    public User findUserById(Long id) {
        return userDAO.findById(id);
    }
}
