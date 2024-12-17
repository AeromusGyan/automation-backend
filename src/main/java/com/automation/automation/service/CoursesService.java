package com.automation.automation.service;

import com.automation.automation.model.Courses;

import java.util.List;

public interface CoursesService {

    public Courses addCourses(Courses courses);

    public Courses updateCourses(Courses courses);

    public List<Courses> getAllCourses();

    public List<Courses> updateAllCourses(List<Courses> courses);

    public List<Courses> getDataStartEnd(String start, String end);

    public List<Courses> getDataByType(String type, String mode, String month, String cname);

}
