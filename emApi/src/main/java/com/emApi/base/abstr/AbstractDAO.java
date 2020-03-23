package com.emApi.base.abstr;

import com.emApi.base.rowMapper.DefaultEntityMapper;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;

public abstract class AbstractDAO {

    private EntityManager entityManager;
    private JdbcTemplate jdbc;

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
