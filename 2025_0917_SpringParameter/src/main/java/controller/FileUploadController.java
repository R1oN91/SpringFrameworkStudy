package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	//자동엮기: Auto Injection
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	// /upload1.do?title=쥬스&photo=a.jpg
	//                    MultipartFile photo <- 업로드된 임시화일정보 
	
	@RequestMapping("/upload1.do")
	public String upload1(String title, @RequestParam MultipartFile photo,Model model) throws Exception, IOException {
				
		String webPath = "/images/";
		String absPath = application.getRealPath(webPath);
		//System.out.println(absPath);
		
		//임시파일 => 원하는 위치로 복사
		String filename="no_file";
		//if(photo.isEmpty()==false) {
		if(!photo.isEmpty()) {
			
			filename = photo.getOriginalFilename();
			 File f= new File(absPath, filename);
			 //파일의 존재 유무 체크
			 if(f.exists()) {
				 //동일파일 명이 존재하면  이름 변경 : 시간_원본파일명
				 long tm = System.currentTimeMillis();
				 filename =String.format("%d_%s", tm,filename);
				 f=new File(absPath, filename);
			 }
		//임시파일->지정위치로 복사
			 photo.transferTo(f);
		}
		
		model.addAttribute("title",title);
		model.addAttribute("filename",filename);
		
		return "upload_result1";
	}
	
	
	//upload2.do?title=쥬스&photo
	@RequestMapping("/upload2.do")
	public String upload2(String title,   // 다른이름으로 쓰고 싶을 때   // 원래는 photo라고 써야 함. 
							@RequestParam("photo") MultipartFile [] photo_array,
							Model model
							) throws Exception, IOException {
		String webPath = "/images/";
		String absPath = application.getRealPath(webPath);
		
		String filename1= "no_file";
		String filename2= "no_file";
		
		for(int i=0;i<photo_array.length;i++) {
			
			MultipartFile photo = photo_array[i];  //포토 어레이 i번째 부터
			
			if(!photo.isEmpty()) {
				
				String filename = photo.getOriginalFilename();
				 File f= new File(absPath, filename);
				 //파일의 존재 유무 체크
				 if(f.exists()) {
					 //동일파일 명이 존재하면  이름 변경 : 시간_원본파일명
					 long tm = System.currentTimeMillis();
					 filename =String.format("%d_%s", tm,filename);
					 f=new File(absPath, filename);
				 }
				 //임시파일->지정위치로 복사
				 //몇개 반복한지 모르면 어레이리스트로 해야함. ㅇㅁㅇ?
				 photo.transferTo(f);
				 
				 if(i==0)
					 filename1=filename;
				 if(i==1)
					 filename2=filename;
			}
			
		}//end : for
		
		model.addAttribute("title",title);
		model.addAttribute("filename1",filename1);
		model.addAttribute("filename2",filename2);
		
		
		return "upload_result2";
	}
}
