package com.zwt.controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.zwt.modle.User;


public class ImageUploadAction extends ActionSupport{

	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
    public String imageUpload() throws IOException {
    	HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		PrintWriter out = response.getWriter();
		String callback = request.getParameter("CKEditorFuncNum");
		InputStream is = new FileInputStream(upload);
		Date date = new Date();
		
		String expandeName = uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd-HH-mm-ss");
		String nowFileName = String.valueOf(date.getTime())+expandeName;
		String uploadPath = session.getServletContext().getRealPath("user/"+user.getMailName()+"/");
				//ServletActionContext.getServletContext().getRealPath("user/images/");
				//ServletActionContext.getServletContext().getRealPath("user/images/");
				//"http://localhost:8080/user/images/";
						
				//"http://localhost:8080/MyBlog/user/images";//+upladFileName;

		System.out.println("uploadpath:"+uploadPath);
		
		File dirfile = new File(uploadPath);
		if(!dirfile.exists()) {
			dirfile.mkdirs();
		}
		System.out.println("原来filename:"+uploadFileName);
		System.out.println("现在filename:"+nowFileName);
		
		File toFile = new File(uploadPath,nowFileName);
		
		OutputStream os = new FileOutputStream(toFile);
		byte[] buffer = new byte[1024];
		int length = 0;
		while((length = is.read(buffer))>0) {
			os.write(buffer, 0, length);
		}
		is.close();
		os.flush();
		os.close();
		
		JSONObject obj = new JSONObject();
		obj.put("uploaded",1);
		obj.put("fileName",nowFileName);
		obj.put("url","user/"+user.getMailName()+"/"+nowFileName);
		out.println(obj.toString());
		
        return null;
    }
}
