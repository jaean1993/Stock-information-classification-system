package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pachong2.biao2;
import pachong2.sta;


public class CheckService {
	
	public String text(String[] args) {
	
		CheckFile checkFile = new CheckFile();
		Map<String,String> resultMap = new HashMap<String,String>();
		String fileString = checkFile.checkFile();
		String outPutString2 = "";
//		System.out.println(fileString);
		String[] sentences = checkFile.replace(fileString);
		if (sentences.length==0) {
	    	 System.out.println("�ļ�Ϊ���ļ���");
		}else {
			//����ÿһ�仰���ѷ���ֵ��Ϊ��ֵ�Ե�map��
			for (int i = 0; i < sentences.length; i++) {
				if (sentences[i].contains("��һ��")) {
					List<String> resultList = checkFile.analyse(sentences[i],"��һ��");
					if (resultList.size()==2) {
						resultMap.put(resultList.get(0), resultList.get(1));
					}
				}else if (sentences[i].contains("��һ��")) {
					List<String> resultList = checkFile.analyse(sentences[i],"��һ��");
					if (resultList.size()==2) {
						resultMap.put(resultList.get(0), resultList.get(1));
					}
				}else if (sentences[i].contains("��һ��")) {
					List<String> resultList = checkFile.analyse(sentences[i],"��һ��");
					if (resultList.size()==2) {
						resultMap.put(resultList.get(0), resultList.get(1));
					}
				}else if (sentences[i].contains("����")) {
					List<String> resultList = checkFile.analyse(sentences[i],"����");
					if (resultList.size()==2) {
						resultMap.put(resultList.get(1), resultList.get(0));
					}
				}else if (sentences[i].contains("ָ")) {
					List<String> resultList = checkFile.analyse(sentences[i],"ָ");
					if (resultList.size()==2) {
						resultMap.put(resultList.get(1), resultList.get(0));
					}
				}else if (sentences[i].contains("��")) {
					List<String> resultList = checkFile.analyse(sentences[i],"��");
					if (resultList.size()==2) {
						resultMap.put(resultList.get(1), resultList.get(0));
					}
				}else if (sentences[i].contains("��")) {
					List<String> resultList = checkFile.analyse(sentences[i],"��");
					if (resultList.size()==2) {
						resultMap.put(resultList.get(1), resultList.get(0));
					}
				}
			}
			String outPutString1 = resultMap.toString();//ת�����ַ�������
			outPutString2 = outPutString1.replaceAll("=", "��").replace("{", "").replace("}", "");
			
			System.out.println(outPutString2);
			String ele[]=outPutString2.split(",");
			String eles[];
			int l=ele.length;
			for(int j=0;j<l;j++){
        	eles=ele[j].split("��");
        	 String sql4 = "select zi,fu from pachong where zi='"+eles[0]+"'";
        	 sta st2 = new sta();
        	 biao2 ci = new biao2();
        	 int x=st2.selectClass(sql4, null,ci,1);
                if (x!=1){
                	String sql3="insert into pachong  values('"+eles[0]+"','"+eles[1]+"')";
                	st2.selectClass(sql3, null,ci,1);
                	}
			}
		
		}
		return outPutString2;
	}
}