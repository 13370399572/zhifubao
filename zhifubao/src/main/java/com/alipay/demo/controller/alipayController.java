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
public class alipayController {
     
	@RequestMapping("dizhi")
	@ResponseBody
    public String  uploadFile(HttpServletRequest request,
    		HttpServletResponse response, Model model) {
		FileInputStream fis = null;
		OutputStream os = null;
		 Main main = new Main();
		 
		 String url =main.test_trade_precreate() ;
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
    	return "ok";
    }
	
	}
