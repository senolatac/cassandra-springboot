package com.sha.courseserver.service;

import com.sha.courseserver.model.Course;
import com.sha.courseserver.model.Summary;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    List<Course> findAll();

    Course saveCourse(Course course);

    void saveSummary(UUID courseId);

    Summary findByCourseId(UUID courseId);
}
