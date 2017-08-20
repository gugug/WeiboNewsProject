package cn.ssm.service;

import java.net.URLDecoder;

import java.net.URLEncoder;
 
public class URLDecoderTest {
 
    public static void main(String[] args) throws Exception {
 
      
 
       String keyWord = URLDecoder.decode("%C3%A4%C2%BD%C2%A0%C3%A7%C2%9A%C2%84%C3%A5%C2%90%C2%8D%C3%A5%C2%AD%C2%97", "utf-8");
 
       System.out.println(keyWord);
 
       
 
 
       String urlStr = URLEncoder.encode("你的名字", "utf-8");
 
       System.out.println(urlStr);
 
    }
 
}
