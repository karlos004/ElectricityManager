package com.emApi.base.security.dao;

import com.emApi.base.abstr.AbstractDAO;
import com.emApi.base.security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoleDAO extends AbstractDAO<Role> {

    @Autowired
    public RoleDAO(EntityManager entityManager, JdbcTemplate jdbc) {
        super(entityManager, jdbc);
    }

    @Override
    public Role findById(Long id) {
        return null;
    }

    @Override
    public List<Role> findById(List<Long> ids) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void save(Role entity) {

    }

}
