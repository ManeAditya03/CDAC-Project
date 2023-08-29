package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CourseDetails extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "courseId")
	@JsonIgnore
	private Course course;
	
	@Column(nullable = false, unique = true)
	private String chapterName;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public CourseDetails(Course course, String chapterName) {
		super();
		this.course = course;
		this.chapterName = chapterName;
	}

	public CourseDetails() {
		super();
	}
	
	
}
