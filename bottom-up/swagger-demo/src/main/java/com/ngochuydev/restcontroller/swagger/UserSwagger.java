package com.ngochuydev.restcontroller.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.ngochuydev.entity.table.User;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface UserSwagger {

	@ApiOperation(value = "Retrieves all users", notes = "get list of users", response = User.class, responseContainer = "list")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageSize", value = "Size of  page", required = false, dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "pageNumber", value = "Page no", required = false, dataType = "string", paramType = "query") })
	ResponseEntity<List<User>> listAllUsers();

	@ApiOperation(value = "User information acquisition", notes = "retrieves information for the specified user.", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid userId"),
			@ApiResponse(code = 404, message = "User not found"),
			@ApiResponse(code = 200, message = "get OK", response = User.class) })
	ResponseEntity<?> getUser(@PathVariable("id") long id);

	ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder);

	@ApiOperation(value = "User information acquisition", notes = "retrieves information for the specified user.", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "specified user information", response = Void.class),
			@ApiResponse(code = 404, message = "Unable to find user", response = Exception.class) })
	
	ResponseEntity<?> updateUser(@ApiParam(value = "id that need to be updated", required = true) @PathVariable("id") long id, @RequestBody User user);

	ResponseEntity<?> deleteUser(@PathVariable("id") long id);

	ResponseEntity<User> deleteAllUsers();
}
