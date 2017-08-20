package cn.ssm.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class URLDecoderEncoder {

	public static String toUTF8(String str) {
		

		String urlStr = null;
		try {
			urlStr = URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return urlStr;
	}
	
	public static String toCharacter(String str){
	     
	 
	       String keyWord = null;
		try {
			keyWord = URLDecoder.decode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	 
	       return keyWord;
	}
	

}
