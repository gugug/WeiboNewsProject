package com.java.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtil {
	/**
	 * 写入数据，保存文本
	 * @param data
	 * @param filePath
	 * @param fileName
	 */
	public static void rwFile(String data, String filePath, String fileName) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		fileName = illegalSymbol(fileName);
		try {
			//是否需要创建文件夹  
            File saveDir = new File(filePath);    
            if(!saveDir.exists()){    
                saveDir.mkdir(); 
            }    
            File file = new File(saveDir+File.separator+fileName);     
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(data);
			bw.flush();
			System.out.println("写入完毕:"+file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 读取读取的txt
	 * @param source
	 * @return
	 */
	public static Map<String,Object>   readAreaTxt(String source) {
		FileReader fr = null;
		BufferedReader br = null;
		Map<String,Object>  map = new HashMap<String,Object> ();
		
		try {
			File f = new File(source);
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
				String[] splitLine = str.split(":");
				String[] splitArea = splitLine[0].split(" ");
				if(splitArea.length>1){
					map.put(splitArea[1], Double.parseDouble(splitLine[1])*100000);
				}else{
					System.out.println(splitArea[0]);
					map.put(splitArea[0], Double.parseDouble(splitLine[1]));
				}
				}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(map);
		return map;
	}
	
	/**
	 * 读取文本
	 * @param source
	 * @return
	 */
	public static Map<String,List<String>>   bufferReadTxt2(String source) {
		FileReader fr = null;
		BufferedReader br = null;
		Map<String,List<String>>  map = new HashMap<String,List<String>> ();
		
		try {
			File f = new File(source);
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String str;
			while ((str = br.readLine()) != null) {
				String[] splitLineStr = str.split("	");
				if(splitLineStr.length>1){
					ArrayList<String> valueList = new ArrayList<String>();
					valueList.add(splitLineStr[1]);
					valueList.add(splitLineStr[1]);
					map.put("\""+splitLineStr[0]+"\"", valueList);
				}
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(map);
		return map;
	}
	
	public static Map<String,String> bufferReadTxt(String source) {
		FileReader fr = null;
		BufferedReader br = null;
		Map<String,String>  map = new HashMap<String,String> ();
		
		try {
			File f = new File(source);
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String str;
			while ((str = br.readLine()) != null) {
				String lineStr = str.replace("    ", "");

				String lineStr1 = lineStr.replaceFirst(",", "`");
				String lineStr2 = lineStr1.replace(",", "");
				String lineStr3 = lineStr2.replaceFirst( "`",",");

				String[] splitLineStr = lineStr3.split(":");

				map.put(splitLineStr[0], splitLineStr[1]);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(map);
		return map;
	}
	
	public static String illegalSymbol(String str) {
		if (str.contains("/") || str.contains("\\") || str.contains("?")
				|| str.contains(":") || str.contains("*") || str.contains("\"")
				|| str.contains("<") || str.contains(">") || str.contains("|")) {
			str = str.replace("/", " ");
			str = str.replace("\\", " ");
			str = str.replace("?", " ");
			str = str.replace(":", " ");
			str = str.replace("*", " ");
			str = str.replace("\"", " ");
			str = str.replace("<", " ");
			str = str.replace(">", " ");
			str = str.replace("|", " ");

			return str;
		} else {
			return str;
		}
	}
	
	public static void main(String[] args) {
		bufferReadTxt("./movie_list/movie_0.txt");
	}
}
