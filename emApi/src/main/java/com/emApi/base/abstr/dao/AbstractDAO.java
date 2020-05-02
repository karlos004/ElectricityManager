package com.emApi.base.abstr.dao;

import com.emApi.base.entity.AbstractEntity;
import com.emApi.base.abstr.basicComponent.BaseAbstractComponent;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractDAO<T extends AbstractEntity> extends BaseAbstractComponent {

    private EntityManager entityManager;
    private JdbcTemplate jdbc;

    public abstract T findById(Long id);
    public abstract void deleteById(Long id);
    public abstract void saveOrUpdate(T entity);

    public AbstractDAO(EntityManager entityManager, JdbcTemplate jdbc) {
        this.entityManager = entityManager;
        this.jdbc = jdbc;
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

}
