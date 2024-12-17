package com.automation.automation.model;

import javax.persistence.*;

@Entity
public class MemberRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberRoleId;

    //Member
    @ManyToOne(fetch = FetchType.EAGER)
    private Educator educator;
    //Role
    @ManyToOne
    private Role role;

    public MemberRole() {
    }

    public Long getMemberRoleId() {
        return memberRoleId;
    }

    public void setMemberRoleId(Long memberRoleId) {
        this.memberRoleId = memberRoleId;
    }

    public Educator getEducator() {
        return educator;
    }

    public void setEducator(Educator educator) {
        this.educator = educator;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
