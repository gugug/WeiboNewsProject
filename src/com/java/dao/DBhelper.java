package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBhelper {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
//	static final String DB_URL = "jdbc:mysql://192.168.235.47:3306/weibo_news"; 
//	static final String USER = "root";
//	static final String PASS = "iiip";
	
//	static final String DB_URL = "jdbc:mysql://localhost:3306/weibo_news"; 
//	static final String USER = "root";
//	static final String PASS = "root";
	
	static final String DB_URL = "jdbc:mysql://192.168.235.20:3306/weibo_news?characterEncoding=utf8"; 
	static final String USER = "root";
	static final String PASS = "iiip";
	
//	static final String DB_URL = "jdbc:mysql://120.76.103.28:3306/weibo_news"; 
//	static final String USER = "root";
//	static final String PASS = "root";

	
	private Connection conn;
	
    public DBhelper(){
    } 
    
	 /** 
     * 连接数据库
     * @return 
     */  
    public Connection getConnection(){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("正在连接...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
    }
    
	 /** 
     * 连接数据库
     * @return 
     */  
    public Connection getYunshanConnection(){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("正在连接...");
			String DB_URL = "jdbc:mysql://192.168.235.36:3306/fig?zeroDateTimeBehavior=round&characterEncoding=utf8"; 
		//convertToNull  convertToNull  顾名思义，就是 转换成null，也即是Date t = getDate(); t是null
		// round  MySQL使用全由0组成的DATETIME值来表示无效日期。
			String USER = "fig";
			String PASS = "fig";
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
    }
	
	 /** 
     * 关闭数据库
     * @param con 
     * @param pst 
     * @param rst 
     */  
    public void closeAll(Connection con,PreparedStatement pst,ResultSet rst){  
        if(rst!=null){  
            try {  
                rst.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
          
        if(pst!=null){  
            try {  
                pst.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
          
        if(con!=null){  
            try {  
                con.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println("关闭完毕");
    }  
    

}
