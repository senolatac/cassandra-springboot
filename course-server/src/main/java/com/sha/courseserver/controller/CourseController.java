package com.sha.courseserver.controller;

import com.sha.courseserver.model.Course;
import com.sha.courseserver.model.Summary;
import com.sha.courseserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/api/course")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @PostMapping("/api/course/create")
    public ResponseEntity<?> saveCourse(@RequestBody Course course){
        course.setPublishDate(LocalDate.now());
        courseService.saveCourse(course);
        return ResponseEntity.ok(course);
    }
    @PostMapping("/api/summary/create")
    public ResponseEntity<?> saveSummary(@RequestBody String courseId){
        courseService.saveSummary(UUID.fromString(courseId));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/summary")
    public ResponseEntity<?> findSummaryByCourseId(@RequestBody String courseId){
        return ResponseEntity.ok(courseService.findByCourseId(UUID.fromString(courseId)));
    }
}
