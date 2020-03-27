package com.emApi.base.security.entity;

import com.emApi.base.entity.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Role extends AbstractEntity implements GrantedAuthority {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_cd")
    private String roleCd;

    @Column(name = "role_desc")
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "permission_id", referencedColumnName = "id"))
    private Collection<Permission> permissions;

    @Override
    public String getAuthority() {
        return roleCd;
    }
}
