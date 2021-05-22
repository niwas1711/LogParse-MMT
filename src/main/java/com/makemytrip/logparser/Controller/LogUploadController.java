package com.makemytrip.logparser.Controller;

import com.makemytrip.logparser.Service.FileStorage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api/")
@Api(value = "LogUploadController APIs", description = "API is used to upload the log file , you can upload multiple files also one by one", tags = {"LogUploadController API"})
public class LogUploadController
	{



		@Autowired
		private FileStorage fileStorageService;



		@PostMapping("/uploadFile")
		@ApiOperation(value = "used to upload the data. ",consumes = "files")
		public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
			String fileName = fileStorageService.storeFile(file);

			return new ResponseEntity<String>("Log file Uploaded Successfully", HttpStatus.OK);
		}


	}
