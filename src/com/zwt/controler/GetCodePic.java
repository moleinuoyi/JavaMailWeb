package com.zwt.controler;

import java.awt.image.RenderedImage;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.zwt.util.CodeUtil;



public class GetCodePic extends ActionSupport{

	private static final long serialVersionUID = 1L;

	public void executes() {
		Map<String,Object> codeMap = CodeUtil.generateCodeAndPic();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("code", codeMap.get("code").toString());//将生成的验证码保存到session中
		System.out.println(codeMap.get("code").toString());//在控制台输出验证码
		//禁止图像缓存
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", -1);
		response.setContentType("image/jpeg");
		
		ServletOutputStream sos;
		try {
			sos = response.getOutputStream();
			ImageIO.write((RenderedImage)codeMap.get("codePic"),"jpg",sos);
			sos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
