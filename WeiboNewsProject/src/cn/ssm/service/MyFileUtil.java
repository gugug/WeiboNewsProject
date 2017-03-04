package cn.ssm.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyFileUtil {
	private HashMap<String, File> filename_dir = new HashMap<String, File>();



	/**
	 * 获取全部的文件名
	 * 
	 * @param path
	 * @return
	 */
	public static String[] getFileName(String path) {
		File file = new File(path);
		String[] fileName = file.list();// 获取文件夹或文件的名字
		return fileName;
	}

	
	/**
	 * 加载newslabel文件
	 * 
	 * @param source
	 * @return titleLabelList[0]为标题， titleLabelList[1]为label
	 */
	public List<String> loadFile(File source) {
		List<String> titleLabelList = new ArrayList<String>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(source);
			br = new BufferedReader(fr);
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
				titleLabelList.add(str);
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
		return titleLabelList;
	}

	/**
	 * 获取新闻文件名对应的路径位置的字典，
	 * 
	 * @param dir
	 * @throws Exception
	 */
	public void getNewsFiles(File dir) {
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			if (fs[i].isDirectory()) {
				try {
					getNewsFiles(fs[i]);
				} catch (Exception e) {
				}
			} else {
				// System.out.println("name: " + fs[i].getName() + " path: "
				// + fs[i]);// ==fs[i].getAbsolutePath
				filename_dir.put(fs[i].getName(), fs[i]);
			}
		}
	}
	

	public static void writeFile(String data, String filePath, String fileName) {
			FileWriter fw = null;
			BufferedWriter bw = null;
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
		
		public static String readFile(String source) {
			InputStreamReader inputStreamReader = null;
			BufferedReader br = null;
			StringBuffer stringBuffer = new StringBuffer();
			try {
				File f = new File(source);
				inputStreamReader = new InputStreamReader(new FileInputStream(f), "utf-8");
//				System.out.println(inputStreamReader.getEncoding());
				br = new BufferedReader(inputStreamReader);

				String str;
				while ((str = br.readLine()) != null) {
					stringBuffer.append(str+"\n");
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
				if (inputStreamReader != null) {
					try {
						inputStreamReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return stringBuffer.toString();
		}
}
