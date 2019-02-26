package com.alipay.demo.service;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;



import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileServiceimpl  implements FileService{
	private String localDirPath = "E:/jt-upload";
	private String localUrlPath = "http://image.jt.com/";
	@Override
	public String uploadFile(MultipartFile fileImage) {
	  
		String fileName=fileImage.getOriginalFilename();
      fileName =fileName.toLowerCase();
      if (!fileName.matches("^.*\\.(jpg|png|gif|mp3)$")) {
		
    	   throw  new RuntimeException("请上传正常格式的文件");
    			  
      }
		//BufferedImage bufferedImage=ImageIO.read(fileImage.getInputStream());
		// int width=bufferedImage.getWidth();
		/* int height=bufferedImage.getHeight();
		 if (width==0||height==0) {
			
			 throw new RuntimeException("这个不是图片");
		}
		*/
    	   String dateDir=new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    	   String dirFilePath=localDirPath+"/"+dateDir;
    	   File dirFile =new File(dirFilePath);
    	   if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
    	   String uuid=UUID.randomUUID().toString().replaceAll("-", "");
    	   int randomNum=new Random().nextInt(1000);
    	   String fileType=fileName.substring(fileName.lastIndexOf("."));
    	   String imageFileName=uuid+randomNum+fileType;
    	   try {
    	   fileImage.transferTo(new File(dirFilePath+"/"+imageFileName));
    	   }catch (Exception e) {
			e.printStackTrace();
		}
    	   String url ="E:/jt-upload"+"\\" + dateDir+"\\"+imageFileName;
    	   
	
		
		return url;
	}

}
