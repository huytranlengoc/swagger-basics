package com.ngochuydev.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ngochuydev.entity.table.Course;
import com.ngochuydev.restcontroller.swagger.UserCoursesSwagger;

@RestController
public class UserCourseController  implements UserCoursesSwagger{
	
	@PostMapping("/{userId}/createCourses")
	public ResponseEntity<?> createCourse(@RequestHeader(value="Accept") String accept,
			@RequestHeader(value="Accept-Language") String acceptLanguage,
			@PathVariable("userId") String userId, 
			@RequestBody Course course, 
			@RequestParam(value = "status", required = false) String status) {
		return ResponseEntity.ok(null);
	}
}
