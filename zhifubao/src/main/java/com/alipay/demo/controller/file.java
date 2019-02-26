package com.alipay.demo.controller;


import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alipay.demo.service.FileService;


@Controller

public class file {
	@Autowired
    FileService fileService;
	
		 @RequestMapping("/file1")
		 @ResponseBody
		 
	 public String fileimage(MultipartFile fileImage,  HttpServletRequest request,
	    		HttpServletResponse response, Model model) {
		 
			 FileInputStream fis = null;
				OutputStream os = null;
				
				String url=fileService.uploadFile(fileImage);
				 try {
					 fis = new FileInputStream(url);
						os = response.getOutputStream();
						int count = 0;
						byte[] buffer = new byte[1024 * 8];
						while ((count = fis.read(buffer)) != -1) {
							os.write(buffer, 0, count);
							os.flush();
						}
				} catch (Exception e) {
					e.printStackTrace();

				}
				 try {
					 fis.close();
						os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		    	return "redirect:/file.html";
		    			
			 
			 
			 
	 }
		
	}
	
	

