package com.emApi.base.abstr;

import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractDAO<T extends AbstractEntity> extends BaseAbstract {

    private EntityManager entityManager;
    private JdbcTemplate jdbc;

    public abstract T findById(Long id);
    public abstract List<T> findById(List<Long> ids);
    public abstract void deleteById(Long id);
    public abstract void save(T entity);

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
