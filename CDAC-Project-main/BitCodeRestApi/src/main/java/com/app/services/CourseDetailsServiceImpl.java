package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.AddCourseDetailsDto;
import com.app.pojos.Course;
import com.app.pojos.CourseDetails;
import com.app.repositories.CourseDetailsRepository;
import com.app.repositories.CourseRepository;

@Service
@Transactional
public class CourseDetailsServiceImpl implements CourseDetailsService{

	@Autowired
	private CourseDetailsRepository courseDetailsRepo;

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CourseDetails addCourseDetails(AddCourseDetailsDto addCourseDetailsDto) {

		Course course = courseRepo.findById(addCourseDetailsDto.getCourseId()).orElseThrow(() -> new RuntimeException("Course Not Found"));
		CourseDetails courseDeails = mapper.map(addCourseDetailsDto, CourseDetails.class);
		courseDeails.setCourse(course);
		courseDetailsRepo.save(courseDeails);
		return courseDeails;
	}

	@Override
	public List<CourseDetails> getAllCourseDetails(Long id) {
		Course course = courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Course Not Found"));
		List<CourseDetails> listCourseDetails = courseDetailsRepo.findAllByCourse(course);
		return listCourseDetails;
	}

}
