package com.automation.automation.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private Long roleId;
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy ="role" )
    private Set<MemberRole> memberRoles=new HashSet<>();

    public Set<MemberRole> getMemberRoles() {
        return memberRoles;
    }

    public void setMemberRoles(Set<MemberRole> memberRoles) {
        this.memberRoles = memberRoles;
    }

    public Role() {
    }

    public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
