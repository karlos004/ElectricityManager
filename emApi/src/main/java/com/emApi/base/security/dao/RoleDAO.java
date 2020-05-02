package com.emApi.base.security.dao;

import com.emApi.base.abstr.dao.AbstractDAO;
import com.emApi.base.security.entity.Role;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RoleDAO extends AbstractDAO<Role> {

    @Autowired
    public RoleDAO(EntityManager entityManager, JdbcTemplate jdbc) {
        super(entityManager, jdbc);
    }

    @Override
    public Role findById(Long id) {
        return getSession().get(Role.class, id);
    }

    @Override
    public void deleteById(Long id) {
        Query<Role> query = getSession().createQuery("delete from Role where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void saveOrUpdate(Role entity) {
        getSession().saveOrUpdate(entity);
    }

}
