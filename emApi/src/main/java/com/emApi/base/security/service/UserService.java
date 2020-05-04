package com.emApi.base.security.service;

import com.emApi.base.abstr.service.AbstractEntityService;
import com.emApi.base.security.dao.UserDAO;
import com.emApi.base.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends AbstractEntityService<User> implements UserDetailsService {

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

    @Override
    @Transactional
    public User read(Long id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional
    public List<User> read(List<Long> ids) {
        List<User> resultList = new ArrayList<>();
        ids.forEach(id -> resultList.add(userDAO.findById(id)));
        return resultList;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(List<Long> ids) {
        ids.forEach(id -> userDAO.deleteById(id));
    }

    @Override
    @Transactional
    public void saveOrUpdate(User entity) {
        userDAO.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void saveOrUpdate(List<User> entities) {
        entities.forEach(entity -> userDAO.saveOrUpdate(entity));
    }
}
