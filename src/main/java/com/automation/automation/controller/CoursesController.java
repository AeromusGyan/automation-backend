package com.automation.automation.controller;

import com.automation.automation.model.Courses;
import com.automation.automation.model.CustomAuthorityDeserializer;
import com.automation.automation.service.CoursesService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @PostMapping("/add")
    public Courses addCourses(@RequestBody Courses courses){
        return this.coursesService.addCourses(courses);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCourses(@RequestBody Courses courses){
        Courses courses1 = this.coursesService.updateCourses(courses);
        return ResponseEntity.ok(courses1);
    }

    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    @PutMapping("/updateAll")
    public ResponseEntity<?> updateAllCourses(@RequestBody List<Courses> courses) {
        List<Courses> courses1 = this.coursesService.updateAllCourses(courses);
        return ResponseEntity.ok(courses1);
    }

    @GetMapping("/")
    public List<Courses> getAllCourses(){
        return this.coursesService.getAllCourses();
    }

    @GetMapping("/get/{start}/{end}")
    public List<Courses> getDataStartEndDate(@PathVariable("start") String start, @PathVariable("end") String end){
        return this.coursesService.getDataStartEnd(start,end);
    }

    @GetMapping("/get/{type}/{mode}/{month}/{cname}")
    public List<Courses> getDataByType(@PathVariable("type") String type,
                                       @PathVariable("mode") String mode,
                                       @PathVariable("month") String month,
                                       @PathVariable("cname") String cname){
        return this.coursesService.getDataByType(type,mode,month,cname);
    }
}
