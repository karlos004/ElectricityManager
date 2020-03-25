package com.emApi.base.security.dao;

import com.emApi.base.abstr.AbstractDAO;
import com.emApi.base.security.entity.User;
import com.emApi.base.rowMapper.DefaultEntityMapper;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO extends AbstractDAO<User> {

    @Autowired
    public UserDAO(EntityManager entityManager, JdbcTemplate jdbc) {
        super(entityManager, jdbc);
    }

    public User findByUsername(String userName) {
        return getJdbc().queryForObject("SELECT * FROM user WHERE user_name=?"
                , new DefaultEntityMapper<User>(User.class), userName).getFirst();
    }

    @Override
    public User findById(Long id) {
        return getJdbc().queryForObject("SELECT * FROM user WHERE user_id=?"
                , new DefaultEntityMapper<User>(User.class), id).getFirst();
    }

    @Override
    public List<User> findById(List<Long> ids) {
        List<User> resultList = new ArrayList<>();
        ids.forEach(id -> resultList.add(getSession().get(User.class, id)));
        return resultList;
    }

    @Override
    public void deleteById(Long id) {
        Query<User> query = getSession().createQuery("delete from User where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void save(User entity) {
        getSession().saveOrUpdate(entity);
    }

}
