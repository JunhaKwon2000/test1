package com.winter.app.common;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public String fileSave(String dir, MultipartFile attach) throws Exception {
		
		File file = new File(dir);
		if (!file.exists()) file.mkdirs();
		
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + attach.getOriginalFilename();
		
		file = new File(file, fileName);
		
		FileCopyUtils.copy(attach.getBytes(), file);
		
		return fileName;
		
	}
	
}
