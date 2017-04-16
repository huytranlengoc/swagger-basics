package com.ngochuydev.restcontroller.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

import io.swagger.annotations.ApiParam;

public interface UserCoursesSwagger {
	@ApiParam(value="api param value", required=true)
	public ResponseEntity<?> createUserCourses(@RequestHeader String test);
}
