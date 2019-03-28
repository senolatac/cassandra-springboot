package com.sha.courseserver.service;

import com.sha.courseserver.model.Course;
import com.sha.courseserver.model.Summary;
import com.sha.courseserver.repository.CourseRepository;
import com.sha.courseserver.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    @Override
    public List<Course> findAll(){
        final List<Course> courseList = new ArrayList<>();
        courseRepository.findAll().forEach(courseList::add);
        return courseList;
    }

    @Override
    public Course saveCourse(Course course){
        course.setId(UUID.randomUUID());
        courseRepository.save(course);
        return course;
    }

    @Override
    public void saveSummary(UUID courseId){
        summaryRepository.incrementHitCount(courseId);
    }

    @Override
    public Summary findByCourseId(UUID courseId){
        return summaryRepository.findByCourseId(courseId).orElse(null);
    }
}
