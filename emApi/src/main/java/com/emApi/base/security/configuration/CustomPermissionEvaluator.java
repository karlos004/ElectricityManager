package com.emApi.base.security.configuration;

import com.emApi.base.security.entity.Permission;
import com.emApi.base.security.entity.Role;
import com.emApi.base.security.entity.User;
import org.hibernate.Hibernate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication auth, Object target, Object permission) {
        if(!checkTypesAreOk(target, permission)) {
            return false;
        }
        User user = (User) auth.getPrincipal();
        for(Role role : user.getRoles()) {
            for(Permission per : role.getPermissions()) {
                if(per.getPermissionCd().equals(permission)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
        return hasPermission(auth, targetId, permission);
    }

    private boolean checkTypesAreOk(Object target, Object permission) {
        if(permission instanceof String) {
            return true;
        }
        return false;
    }
}
