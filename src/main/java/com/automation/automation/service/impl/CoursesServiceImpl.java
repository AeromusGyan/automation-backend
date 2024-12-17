package com.automation.automation.service.impl;

import com.automation.automation.model.Courses;
import com.automation.automation.repo.CoursesRepository;
import com.automation.automation.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;
    @Override
    public Courses addCourses(Courses courses) {
        return this.coursesRepository.save(courses);
    }

    @Override
    public Courses updateCourses(Courses courses) {
        return this.coursesRepository.save(courses);
    }

    @Override
    public List<Courses> getAllCourses() {
        return (List<Courses>) this.coursesRepository.findAll();
    }

    @Override
    public List<Courses> updateAllCourses(List<Courses> courses) {
        courses.forEach(courses1 -> {
            Long cId = courses1.getcId();
            Long offeringId = courses1.getOfferingId();
            String registration_link = courses1.getRegistration_link();
            System.out.println(courses1);
            this.coursesRepository.updateCourse(cId,offeringId,registration_link);
        });
        return null;
    }

    @Override
    public List<Courses> getDataStartEnd(String start, String end) {
        return this.coursesRepository.getDataStartEnd(start,end);
    }

    @Override
    public List<Courses> getDataByType(String type, String mode, String month, String cname) {
        return this.coursesRepository.getDataByType(type, mode, month, cname);
    }
}
