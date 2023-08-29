package com.app.services;

import java.util.List;

import com.app.dtos.AddCourseDto;
import com.app.pojos.Course;

public interface CourseService {
	List<Course> getAllCourses();
	Course getCourseById(Long courseId);
	Course addCourse(AddCourseDto addCourseDto);
	int getUserCountByCourseId(Long courseId);
}