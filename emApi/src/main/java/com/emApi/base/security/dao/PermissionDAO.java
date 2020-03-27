package com.emApi.base.security.dao;

import com.emApi.base.abstr.dao.AbstractDAO;
import com.emApi.base.security.entity.Permission;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PermissionDAO extends AbstractDAO<Permission> {

    @Autowired
    public PermissionDAO(EntityManager entityManager, JdbcTemplate jdbc) {
        super(entityManager, jdbc);
    }

    @Override
    public Permission findById(Long id) {
        return getSession().get(Permission.class, id);
    }

    @Override
    public void deleteById(Long id) {
        Query<Permission> query = getSession().createQuery("delete from Permission where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void saveOrUpdate(Permission entity) {
        getSession().saveOrUpdate(entity);
    }
}
