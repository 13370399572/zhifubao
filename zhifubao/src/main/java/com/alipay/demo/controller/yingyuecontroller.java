package com.alipay.demo.controller;

import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.Main;

@Controller
@RequestMapping("/")
public class yingyuecontroller {

	@RequestMapping("yingyue")
	@ResponseBody
    public String  uploadFile(HttpServletRequest request,
    		HttpServletResponse response, Model model) {
		FileInputStream fis = null;
		OutputStream os = null;
		
		 try {
			 fis = new FileInputStream("E:/mp3/mp3.mp3");
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
    	return "ok";
    }
	
}
