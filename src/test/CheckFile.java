package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class CheckFile {
	
	/**
	 * 把文件读到缓存中
	 * @param 
	 * @return String
	 */
	public String checkFile(){
		
		//打开文件
		File readerFile = new File("D:/aaa.txt");
		BufferedReader reader = null;
		String file = "";
		try {
			//读取到流
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(readerFile),"UTF-8"));
			String tempString = "";
			//遍历
			while ((tempString = reader.readLine()) != null) {
				file = file + tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//出现Exception，关闭流
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return file;
	}
	
	/**
	 * 把字符串中的中文符号变成英文字符，用正则表达式进行字符串分隔
	 * @param file
	 * @return String[]
	 */
	public String[] replace(String file){
		//替换中文标点
		file = file.replace("。", ".");
		file = file.replace("？", "?");
	    file = file.replace("！", "!");
	    file = file.replace("，", ",");
	    file = file.replace("~", ".");
	    //字符串分隔
	    String result[] = file.split("[\\.!\\?]");
	    for (int i = 0; i < result.length; i++)
	      //去除空格
	      result[i] = result[i].trim();
	    return result;
	}
	
	/**
	 * 分析每一句话
	 * @param sentence keyword
	 * @return List
	 */
	public List<String> analyse(String sentence,String keyWord) {
		//找到关键字的数组下标
		int index = sentence.indexOf(keyWord);
		//关键字长度
		int length = keyWord.length();
		//截取字符串
		String keyString = sentence.substring(0,index);
		String valueString = sentence.substring(index+length);
		List<String> resultList = new ArrayList<>();
		resultList.add(keyString);
		resultList.add(valueString);
		return resultList;
	}
	
}