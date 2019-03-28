package com.sha.courseserver.repository;

import com.sha.courseserver.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CourseRepository extends CrudRepository<Course, UUID> {
}
