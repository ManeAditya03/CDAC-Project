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

import com.app.dtos.AddCourseDetailsDto;
import com.app.pojos.CourseDetails;
import com.app.services.CourseDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/courseDetails")
public class CourseDetailsController {

	@Autowired
	private CourseDetailsService courseDetailsService;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private JavaMailSender sender;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCourseDetails(@RequestBody AddCourseDetailsDto courseDetailsDto) {
		System.out.println(courseDetailsDto);
		return new ResponseEntity<>(courseDetailsService.addCourseDetails(courseDetailsDto), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCoursesDetailsByCourseId(@PathVariable("id") Long id) {
		List<CourseDetails> listCourseDetails = courseDetailsService.getAllCourseDetails(id);
		return new ResponseEntity<>(listCourseDetails, HttpStatus.OK);
	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getCourseById(@PathVariable("id") Long id) {
//		Course savedCourse = courseDetailsService.getCourseById(id);
//		return new ResponseEntity<>(savedCourse, HttpStatus.OK);
//	}
}
