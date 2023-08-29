package com.app.services;

import java.util.List;

import com.app.dtos.AddCourseDetailsDto;
import com.app.pojos.CourseDetails;

public interface CourseDetailsService {
	CourseDetails addCourseDetails(AddCourseDetailsDto addCourseDetailsDto);
	List<CourseDetails> getAllCourseDetails(Long id);
}
