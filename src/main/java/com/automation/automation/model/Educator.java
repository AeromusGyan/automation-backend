package com.automation.automation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Educator implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String educator_name;
    private String email;
    private String password;
    private String date;
    private Boolean status=true;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "educator")
    @JsonIgnore
    private Set<MemberRole>memberRoles=new HashSet<>();

    // Many Member roles
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "educator")
    @JsonIgnore
    private Set<Courses> courses=new HashSet<>();

    public Educator() {
    }

    public Educator(Long id, String username, String educator_name, String email, String password, String date, Boolean status, Set<MemberRole> memberRoles, Set<Courses> courses) {
        this.id = id;
        this.username = username;
        this.educator_name = educator_name;
        this.email = email;
        this.password = password;
        this.date = date;
        this.status = status;
        this.memberRoles = memberRoles;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEducator_name() {
        return educator_name;
    }

    public void setEducator_name(String educator_name) {
        this.educator_name = educator_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    public Set<MemberRole> getMemberRoles() {
        return memberRoles;
    }

    public void setMemberRoles(Set<MemberRole> memberRoles) {
        this.memberRoles = memberRoles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> set = new HashSet<>();
        this.memberRoles.forEach(memberRole -> {
            set.add(new Authority(memberRole.getRole().getRoleName()));
        });

        return set;
    }

}










