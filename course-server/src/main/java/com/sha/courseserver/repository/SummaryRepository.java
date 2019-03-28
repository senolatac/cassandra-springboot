package com.sha.courseserver.repository;

import com.sha.courseserver.model.Summary;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface SummaryRepository extends CrudRepository<Summary, UUID> {

    Optional<Summary> findByCourseId(UUID courseId);

    @Query("update summary set hit_count = hit_count + 1 where course_id=?0")
    void incrementHitCount(UUID courseId);
}
