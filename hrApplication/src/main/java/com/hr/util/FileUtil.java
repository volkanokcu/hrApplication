package com.hr.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.ApplicationHome;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	public static final String UPLOAD_DIRECTORY = File.separator + "upload";
	
	public static String write(MultipartFile file, Class<?> clazz) throws IOException {
		ApplicationHome home = new ApplicationHome(clazz);
		File jarFile = home.getSource();
		String uploadPath = jarFile.getParent() + UPLOAD_DIRECTORY;
		File uploadDir =  new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		String fileName = file.getOriginalFilename();
		fileName = fileName.substring(0, fileName.indexOf(".")) + System.currentTimeMillis() + fileName.substring(fileName.indexOf("."));
        Path path = Paths.get(uploadPath + File.separator + fileName);
		Files.write(path, file.getBytes());
		return fileName;
	}
	
	public static void delete(String fileName, Class<?> clazz) throws IOException {
		ApplicationHome home = new ApplicationHome(clazz);
		File jarFile = home.getSource();
		String uploadPath = jarFile.getParent() + UPLOAD_DIRECTORY;
		File uploadDir =  new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		Path path = Paths.get(uploadPath + File.separator + fileName);
		Files.delete(path);
	}

}
