package com.emApi.base.security.entity;


import com.emApi.base.entity.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "permission")
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
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

    @Override
    public String getAuthority() {
        return permissionCd;
    }
}
