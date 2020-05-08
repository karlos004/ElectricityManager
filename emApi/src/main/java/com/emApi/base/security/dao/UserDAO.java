package com.emApi.base.security.dao;

import com.emApi.base.abstr.dao.AbstractDAO;
import com.emApi.base.security.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDAO extends AbstractDAO<User> {

    @Autowired
    public UserDAO(EntityManager entityManager, JdbcTemplate jdbc) {
        super(entityManager, jdbc);
    }

    public User findByUsername(String userName) {
        Query<User> query = getSession().createQuery("from User where username = :username", User.class);
        query.setParameter("username", userName);
        User result =  query.getSingleResult();
        Hibernate.initialize(result.getAuthorities());
        return result;
    }

    @Override
    public User findById(Long id) {
        return getSession().get(User.class, id);
    }

    @Override
    public void deleteById(Long id) {
        Query<User> query = getSession().createQuery("delete from User where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void saveOrUpdate(User entity) {
        getSession().saveOrUpdate(entity);
    }

}
