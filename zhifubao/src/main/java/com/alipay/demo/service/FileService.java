package com.alipay.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	String uploadFile(MultipartFile fileImage);

	  
}
