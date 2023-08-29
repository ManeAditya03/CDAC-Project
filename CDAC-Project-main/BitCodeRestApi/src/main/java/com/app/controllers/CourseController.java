package com.app.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddCourseDto;
import com.app.pojos.Course;
import com.app.services.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private JavaMailSender sender;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCourse(@RequestBody AddCourseDto coursedto) {
		return new ResponseEntity<>(courseService.addCourse(coursedto), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getCoursesList() {
		List<Course> listCourses = courseService.getAllCourses();
		return new ResponseEntity<>(listCourses, HttpStatus.OK);
	}
	
	@GetMapping("/{courseid}")
	public ResponseEntity<?> getCourseById(@PathVariable("courseid") Long id) {
		Course savedCourse = courseService.getCourseById(id);
		return new ResponseEntity<>(savedCourse, HttpStatus.OK);
	}
	
	@GetMapping("/userCount/{courseid}")
	public ResponseEntity<?> getUserCountByCourseId(@PathVariable("courseid") Long id) {
		return new ResponseEntity<>(courseService.getUserCountByCourseId(id), HttpStatus.OK);
	}
}
