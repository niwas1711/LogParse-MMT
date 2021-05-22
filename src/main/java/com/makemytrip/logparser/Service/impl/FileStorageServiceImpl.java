package com.makemytrip.logparser.Service.impl;

import com.makemytrip.logparser.Configuration.FileStorageProperties;
import com.makemytrip.logparser.Service.FileStorage;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorage
	{

		private final Path fileStorageLocation;


		@Autowired
		public FileStorageServiceImpl(FileStorageProperties fileStorageProperties)
			{
				this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
						                           .toAbsolutePath().normalize();

				try {
					Files.createDirectories(this.fileStorageLocation);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		public String storeFile(MultipartFile file)
			{
				String fileName = StringUtils.cleanPath(file.getOriginalFilename());

				try {

					if (fileName.contains("..")) {
						throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
					}

					// Copy file to the target location (Replacing existing file with the same name)
					Path targetLocation = this.fileStorageLocation.resolve(fileName);
					Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);



				} catch (Exception Exception) {

					Exception.printStackTrace();
				}
				return fileName;
			}

	}




