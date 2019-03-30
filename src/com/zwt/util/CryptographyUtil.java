package com.zwt.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptographyUtil {
	
	//Base64����
	public static String encBase64(String str) {
		return Base64.encodeToString(str.getBytes());
	}
	//Base64����
	public static String decBase64(String base64str) {
		return Base64.decodeToString(base64str);
	}
	//MD5����
	public static String md5(String str) {
		return new Md5Hash(str).toString();
	}
	public static String md5(String str,String salt) {
		return new Md5Hash(str,salt).toString();
	}
	public static String md5(String str,String salt,int hashIterations) {
		return new Md5Hash(str, salt, hashIterations).toString();
	}
	public static void main(String[] args) {
		String str = "123321";
		String salt = "zwt.com";
		System.out.println("Base64����:"+encBase64(str));
		System.out.println("Base64����:"+decBase64("SSBMb3ZlIFpKSg=="));
		System.out.println("============");
		System.out.println("MD5����:"+md5(str,salt));
	}
}
