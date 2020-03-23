package com.emApi.base.security.dao;

import com.emApi.base.abstr.AbstractDAO;
import com.emApi.base.security.entity.User;
import com.emApi.base.rowMapper.DefaultEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDAO extends AbstractDAO {

    @Autowired
    public UserDAO(EntityManager entityManager, JdbcTemplate jdbc) {
        super(entityManager, jdbc);
    }

    public User findByUsername(String userName) {
        return getJdbc().queryForObject("SELECT * FROM user WHERE user_name=?"
                , new DefaultEntityMapper<User>(User.class), userName).getFirst();
    }

    public User findById(Long id) {
        return getJdbc().queryForObject("SELECT * FROM user WHERE user_id=?"
                , new DefaultEntityMapper<User>(User.class), id).getFirst();
    }

}
