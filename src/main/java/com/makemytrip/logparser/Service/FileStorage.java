package com.makemytrip.logparser.Service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage
	{
		 String storeFile(MultipartFile file);

	}
