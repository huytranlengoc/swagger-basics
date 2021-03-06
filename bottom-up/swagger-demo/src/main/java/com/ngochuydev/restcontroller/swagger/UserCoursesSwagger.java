package com.ngochuydev.restcontroller.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.ngochuydev.entity.table.Course;

import io.swagger.annotations.ApiImplicitParam;

public interface UserCoursesSwagger {

	@ApiImplicitParam(name = "x-auth-token", value = "token", required = true, dataType = "string", paramType = "header")
	public ResponseEntity<?> createCourse(@RequestHeader(value="Accept") String accept,
			@RequestHeader(value="Accept-Language") String acceptLanguage,
			@PathVariable("userId") String userId, 
			@RequestBody Course course, 
			@RequestParam(value = "status", required = false) String status);
}
