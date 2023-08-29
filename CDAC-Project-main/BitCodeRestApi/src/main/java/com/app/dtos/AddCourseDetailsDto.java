package com.app.dtos;

import com.app.pojos.Course;

public class AddCourseDetailsDto {
	private Long courseId;
	private String chapterName;
	
	public AddCourseDetailsDto() {
		super();
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public AddCourseDetailsDto(Long courseId, String chapterName) {
		super();
		this.courseId = courseId;
		this.chapterName = chapterName;
	}
	
}
