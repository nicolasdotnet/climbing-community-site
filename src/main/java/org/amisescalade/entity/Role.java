package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author nicolasdotnet
 *
 * Role a is the category entity to which users in the community can
 * belong : Author, Climber, Moderator ...
 *
 */
@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private Long roleId;
    @Column(nullable = false)
    private Date roleDate;
    @Column(length = 100, nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Collection<User> users;

    public Role() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getRoleDate() {
        return roleDate;
    }

    public void setRoleDate(Date roleDate) {
        this.roleDate = roleDate;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
    
    
}
