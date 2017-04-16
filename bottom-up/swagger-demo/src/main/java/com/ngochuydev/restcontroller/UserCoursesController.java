package com.ngochuydev.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngochuydev.restcontroller.swagger.UserCoursesSwagger;

@RestController
public class UserCoursesController  implements UserCoursesSwagger{
	
	@PostMapping("/createUserCourses")
	public ResponseEntity<?> createUserCourses(String test) {
		return ResponseEntity.ok(null);
	}
}
