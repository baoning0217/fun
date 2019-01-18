package com.vincce.fun.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
  Created By BaoNing On 2019年1月17日
*/
@Slf4j
@RestController
@RequestMapping("/upload")
public class FileUploadController {
	
	@PostMapping("/files")
	public List<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile[] files) throws Exception {
		if (files == null || files.length == 0) {
			log.info("文件为空!");
			return null;
		}
		
		List<Map<String, String>> results = new ArrayList<>();
		for (MultipartFile file : files) {
			
			//将上传文件写到服务器上指定的文件
			file.transferTo(new File(file.getOriginalFilename()));
			
			Map<String, String> map = new HashMap<>();
            map.put("contentType", file.getContentType());
            map.put("fileName", file.getOriginalFilename());
            map.put("name",  file.getName());
            map.put("fileSize", file.getSize() + "");
           
            results.add(map);
		}
		log.debug("上传成功");
		return results;
	}

}
