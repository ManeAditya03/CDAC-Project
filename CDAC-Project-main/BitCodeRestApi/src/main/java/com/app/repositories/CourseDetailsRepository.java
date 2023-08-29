package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
import com.app.pojos.CourseDetails;

@Repository
public interface CourseDetailsRepository extends JpaRepository<CourseDetails, Long> {
	List<CourseDetails> findAllByCourse(Course course);
}
