package com.automation.automation.model;

import javax.persistence.*;

@Entity
public class Course_Duration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contact_session_timing;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Courses courses;

    public Course_Duration() {
    }

    public Course_Duration(Long id, String contact_session_timing) {
        this.id = id;
        this.contact_session_timing = contact_session_timing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact_session_timing() {
        return contact_session_timing;
    }

    public void setContact_session_timing(String contact_session_timing) {
        this.contact_session_timing = contact_session_timing;
    }

    @Override
    public String toString() {
        return "Course_Duration{" +
                "id=" + id +
                ", contact_session_timing='" + contact_session_timing + '\'' +
                '}';
    }
}
