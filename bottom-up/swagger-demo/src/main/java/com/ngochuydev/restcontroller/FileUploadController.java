package com.ngochuydev.restcontroller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	@PostMapping(value = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Void> uploadFile(@RequestPart(required = false) String description,
			@RequestPart MultipartFile file) {
		return ResponseEntity.ok(null);
	}
}
