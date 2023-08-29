package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.AddCourseDto;
import com.app.pojos.Course;
import com.app.repositories.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Course> getAllCourses() {
		List<Course> listCourses = courseRepo.findAll();
		return listCourses;
	}

	@Override
	public Course getCourseById(Long courseId) {
		if (courseRepo.existsById(courseId)) {
			Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course Not Found"));
			return course;
		}
		return null;
	}

	@Override
	public Course addCourse(AddCourseDto addCourseDto) {
		Course newCourse = mapper.map(addCourseDto, Course.class);
		courseRepo.save(newCourse);
		return newCourse;
	}

	@Override
	public int getUserCountByCourseId(Long courseId) {
		Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course Not Found"));
		return course.countOfUsers();
	}
}
