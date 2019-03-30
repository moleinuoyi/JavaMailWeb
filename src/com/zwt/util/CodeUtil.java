package com.zwt.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CodeUtil {
	private static int width = 120;//图片的长度
	private static int height = 30;//图片的宽度
	private static int codeCount = 4;//图片显示验证码的个数
	
	private static int xx = 30;//每张图片的宽度，一共4张4*30=120
	private static int fontHeight = 22;//图片上字体大小
	private static int codeY = 25;
	private static char[] codeSequence = {'A','B','C','D','E','F','G','H','I','J','K','L',
										  'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
										  '0','1','2','3','4','5','6','7','8','9'};
	
	
	public static Map<String,Object> generateCodeAndPic(){
		BufferedImage buffImg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		Graphics gd = buffImg.getGraphics();
		
		Random random = new Random();
		
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);
		Font font = new Font("Fixedsys",Font.BOLD,fontHeight);
		gd.setFont(font);//设置字体
		
		gd.setColor(Color.BLACK);
		//gd.drawRect(0, 0, width-1, height-1);
		
		
		
		StringBuffer randomCode = new StringBuffer();
		
		int red = 0;
		int green = 0;
		int blue = 0;
		for(int i = 0;i<codeCount;i++) {
			String code = String.valueOf(codeSequence[random.nextInt(36)]);//得到随机验证码数字
			
			//随机产生颜色
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			
			gd.setColor(new Color(red,green,blue));
			gd.drawString(code, 5+i*xx, codeY);
			randomCode.append(code);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", randomCode);
		map.put("codePic", buffImg);
		
		//随机产生40条干扰线
		gd.setColor(Color.BLACK);
		for(int i = 0;i<40;i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			
			int x1 = random.nextInt(15);
			int y1 = random.nextInt(15);
			
			gd.drawLine(x, y, x+x1, y+y1);
		}
	
		return map;
	}
}
