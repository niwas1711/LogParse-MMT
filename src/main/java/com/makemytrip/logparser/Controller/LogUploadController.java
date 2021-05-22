package com.makemytrip.logparser.Controller;

import com.makemytrip.logparser.Service.FileStorage;
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
public class LogUploadController
	{



		@Autowired
		private FileStorage fileStorageService;



		@PostMapping("/uploadFile")
		public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
			String fileName = fileStorageService.storeFile(file);

			return new ResponseEntity<String>("Log file Uploaded Successfully", HttpStatus.OK);
		}


	}
