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
	 * ���ļ�����������
	 * @param 
	 * @return String
	 */
	public String checkFile(){
		
		//���ļ�
		File readerFile = new File("D:/aaa.txt");
		BufferedReader reader = null;
		String file = "";
		try {
			//��ȡ����
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(readerFile),"UTF-8"));
			String tempString = "";
			//����
			while ((tempString = reader.readLine()) != null) {
				file = file + tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//����Exception���ر���
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
	 * ���ַ����е����ķ��ű��Ӣ���ַ�����������ʽ�����ַ����ָ�
	 * @param file
	 * @return String[]
	 */
	public String[] replace(String file){
		//�滻���ı��
		file = file.replace("��", ".");
		file = file.replace("��", "?");
	    file = file.replace("��", "!");
	    file = file.replace("��", ",");
	    file = file.replace("~", ".");
	    //�ַ����ָ�
	    String result[] = file.split("[\\.!\\?]");
	    for (int i = 0; i < result.length; i++)
	      //ȥ���ո�
	      result[i] = result[i].trim();
	    return result;
	}
	
	/**
	 * ����ÿһ�仰
	 * @param sentence keyword
	 * @return List
	 */
	public List<String> analyse(String sentence,String keyWord) {
		//�ҵ��ؼ��ֵ������±�
		int index = sentence.indexOf(keyWord);
		//�ؼ��ֳ���
		int length = keyWord.length();
		//��ȡ�ַ���
		String keyString = sentence.substring(0,index);
		String valueString = sentence.substring(index+length);
		List<String> resultList = new ArrayList<>();
		resultList.add(keyString);
		resultList.add(valueString);
		return resultList;
	}
	
}