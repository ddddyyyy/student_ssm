package com.mdy.student.web.file;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class fileController {
	
	@RequestMapping(value="setIcon",method=RequestMethod.GET)
	public String setIcon() {
		return "setIcon";
	}
	@RequestMapping(value="uploadIcon",method=RequestMethod.GET)
	@ResponseBody
	public String uploadIcon(MultipartFile file){
		String fileName = file.getOriginalFilename();
		File iconFile = new File("f:/test.jpg");
		try {
			file.transferTo(iconFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
}
