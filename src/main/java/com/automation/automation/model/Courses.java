package com.automation.automation.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;
    private Long offeringId;
    private String course_type;
    private String course_name;
    private String start_date;
    private String end_date;
    private String month;
    private String start_time;
    private String end_time;
    private String contact_session_timing;
    private String no_of_slots;
    private String venue;
    private String location;
    private String course_mode;
    private String registration_link;
    private Boolean status =false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Educator educator;
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "courses")
//    private Set<Course_Duration> course_durations;
    public Courses() {
    }

    public Courses(Long cId, Long offeringId, String course_type, String course_name, String start_date, String end_date, String month, String start_time, String end_time, String contact_session_timing, String no_of_slots, String venue, String location, String course_mode, String registration_link, Boolean status, Educator educator) {
        this.cId = cId;
        this.offeringId = offeringId;
        this.course_type = course_type;
        this.course_name = course_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.month = month;
        this.start_time = start_time;
        this.end_time = end_time;
        this.contact_session_timing = contact_session_timing;
        this.no_of_slots = no_of_slots;
        this.venue = venue;
        this.location = location;
        this.course_mode = course_mode;
        this.registration_link = registration_link;
        this.status = status;
        this.educator = educator;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Long getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(Long offeringId) {
        this.offeringId = offeringId;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getContact_session_timing() {
        return contact_session_timing;
    }

    public void setContact_session_timing(String contact_session_timing) {
        this.contact_session_timing = contact_session_timing;
    }

    public String getNo_of_slots() {
        return no_of_slots;
    }

    public void setNo_of_slots(String no_of_slots) {
        this.no_of_slots = no_of_slots;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCourse_mode() {
        return course_mode;
    }

    public void setCourse_mode(String course_mode) {
        this.course_mode = course_mode;
    }

    public String getRegistration_link() {
        return registration_link;
    }

    public void setRegistration_link(String registration_link) {
        this.registration_link = registration_link;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Educator getEducator() {
        return educator;
    }

    public void setEducator(Educator educator) {
        this.educator = educator;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "cId=" + cId +
                ", offeringId=" + offeringId +
                ", course_type='" + course_type + '\'' +
                ", course_name='" + course_name + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", month='" + month + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", contact_session_timing='" + contact_session_timing + '\'' +
                ", no_of_slots='" + no_of_slots + '\'' +
                ", venue='" + venue + '\'' +
                ", location='" + location + '\'' +
                ", course_mode='" + course_mode + '\'' +
                ", registration_link='" + registration_link + '\'' +
                ", status=" + status +
                ", educator=" + educator +
                '}';
    }
}
