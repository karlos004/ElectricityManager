package com.emApi.base.security.service;

import com.emApi.base.abstr.service.AbstractEntityService;
import com.emApi.base.security.dao.RoleDAO;
import com.emApi.base.security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService extends AbstractEntityService<Role> {

    private RoleDAO roleDAO;

    @Autowired
    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public Role read(Long id) {
        return roleDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Role> read(List<Long> ids) {
        List<Role> resultList = new ArrayList<>();
        ids.forEach(id -> resultList.add(roleDAO.findById(id)));
        return resultList;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        roleDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(List<Long> ids) {
        ids.forEach(id -> roleDAO.deleteById(id));
    }

    @Override
    @Transactional
    public void saveOrUpdate(Role entity) {
        roleDAO.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void saveOrUpdate(List<Role> entities) {
        entities.forEach(entity -> roleDAO.saveOrUpdate(entity));
    }
}
