package com.emApi.base.security.entity;


import com.emApi.base.entity.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "permission")
public class Permission extends AbstractEntity implements GrantedAuthority {

    @Id
    @Column(name = "perm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "perm_cd")
    private String permissionCd;

    @Column(name = "perm_desc")
    private String description;

    @ManyToMany(mappedBy = "permissions")
    private Collection<Role> roles;

    public Permission() {
    }

    public Permission(Long id, String permissionCd, String description, Collection<Role> roles) {
        this.permissionCd = permissionCd;
        this.description = description;
        this.roles = roles;
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return permissionCd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionCd() {
        return permissionCd;
    }

    public void setPermissionCd(String permissionCd) {
        this.permissionCd = permissionCd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
