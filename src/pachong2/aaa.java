package pachong2;


import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class aaa {
	   
	    public String article(String url,String location,String table,String festival) {
	    	String result = "\n";
	        Document doc;
	        try {
	        	doc = Jsoup.connect(url).get();
	            Elements ListDiv = doc.select(location);//("class","biItemInner");
	            String linkText[] = new String[14];
	            int i = 0;
	            	for (Element element :ListDiv) {
	            		linkText[i]= element.text();
	            		result = result + "\n"+linkText[i];
	            		i++;
	            		if(i>=13)
	            			break;
	            		}
	            biao bi = new biao();
	            String festival2 = "中文名"+" "+festival;
	            String sql = "select * from chuantongjieri where aa='"+festival2+"'";
	            
	            sta sss= new sta();
	            int j = sss.selectClass(sql,bi,null,0); 

	            
	            if(j!=1){
	            	String sqln = "insert into "+table+" (aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk,ll,mm) values('"+linkText[0]+"','"+linkText[1]+"','"+linkText[2]+"','"+linkText[3]+"','"+linkText[4]+"','"+linkText[5]+"','"+linkText[6]+"','"+linkText[7]+"','"+linkText[8]+"','"+linkText[9]+"','"+linkText[10]+"','"+linkText[11]+"','"+linkText[12]+"')";
	            
	            	j = sss.selectClass(sqln,bi,null,0);

	            }
	            
	            else{
	            	System.out.println(bi.getBb()+"cd");
	            if(bi.getBb().equals(linkText[1])==false)
	            	linkText[1]=linkText[1]+bi.getBb();
	            if(bi.getCc().equals(linkText[2])==false)
	            	linkText[2]=linkText[2]+bi.getCc();
	            if(bi.getDd().equals(linkText[3])==false)
	            	linkText[3]=linkText[3]+bi.getDd();
	            if(bi.getEe().equals(linkText[4])==false)
	            	linkText[4]=linkText[4]+bi.getEe();
	            if(bi.getFf().equals(linkText[5])==false)
	            	linkText[5]=linkText[5]+bi.getFf();
	            if(bi.getGg().equals(linkText[6])==false)
	            	linkText[6]=linkText[6]+bi.getGg();
	            if(bi.getHh().equals(linkText[7])==false)
	            	linkText[7]=linkText[7]+bi.getHh();
	            if(bi.getIi().equals(linkText[8])==false)
	            	linkText[8]=linkText[8]+bi.getIi();
	            if(bi.getJj().equals(linkText[9])==false)
	            	linkText[9]=linkText[9]+bi.getJj();
	            if(bi.getKk().equals(linkText[10])==false)
	            	linkText[10]=linkText[10]+bi.getKk();
	            if(bi.getLl().equals(linkText[11])==false)
	            	linkText[11]=linkText[11]+bi.getLl();
	            if(bi.getMm().equals(linkText[12])==false)
	            	linkText[12]=linkText[12]+bi.getMm();
	            
	            	j = sss.selectClass("update "+table+" set aa='"+linkText[0]+"',bb='"+linkText[1]+"',cc='"+linkText[2]+"',dd='"+linkText[3]+"',ee='"+linkText[4]+"',ff='"+linkText[5]+"',gg='"+linkText[6]+"',hh='"+linkText[7]+"',ii='"+linkText[8]+"',jj='"+linkText[9]+"',kk='"+linkText[10]+"',ll='"+linkText[11]+"',mm='"+linkText[12]+"' where aa='"+linkText[0]+"'",bi,null,0);
	            	if(j==1)
	            		System.out.println("更新成功");
	            }
	            
	           return result;
	        }
	        
	         catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return null;
	    }
}
