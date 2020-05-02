package com.emApi.base.security.service;

import com.emApi.base.abstr.service.AbstractEntityService;
import com.emApi.base.security.dao.PermissionDAO;
import com.emApi.base.security.entity.Permission;

import java.util.ArrayList;
import java.util.List;

public class PermissionService extends AbstractEntityService<Permission> {

    private PermissionDAO permissionDAO;

    @Override
    public Permission read(Long id) {
        return permissionDAO.findById(id);
    }

    @Override
    public List<Permission> read(List<Long> ids) {
        List<Permission> resultList = new ArrayList<>();
        ids.forEach(id -> resultList.add(permissionDAO.findById(id)));
        return resultList;
    }

    @Override
    public void delete(Long id) {
        permissionDAO.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(id -> permissionDAO.deleteById(id));
    }

    @Override
    public void saveOrUpdate(Permission entity) {
        permissionDAO.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdate(List<Permission> entities) {
        entities.forEach(entity -> permissionDAO.saveOrUpdate(entity));
    }
}
