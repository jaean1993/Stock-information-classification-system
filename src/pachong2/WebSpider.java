package pachong2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
public class WebSpider {
     
	public  String art(String url,String location,String table) throws UnsupportedEncodingException  {
		 String encodedString = URLEncoder.encode(url, "UTF-8");
		 String result=null;
	    try {
	    String decodeString = URLDecoder.decode(encodedString,"UTF-8");
   	    Document doc = Jsoup.connect(decodeString).timeout(8000).get();
    	Elements links = doc.select("strong");
    	Elements links2 = doc.select("span");
    	String fu[] = new String[80];
    	String zi[] = new String[580];
    	int i=0,j=0;
    	for (Element link : links) {
    		
    	  fu[i] = link.text();
    	  i++;	
    	  result = fu[0];
    	  //System.out.println(fu[0]);
    	}
    	for (Element link2 : links2) {
      	  //zi[j] = link2.attr("title");//获取元素属性
      	  	zi[j]=link2.text();
    		System.out.println(zi[j]);
      	  result = result + "\n" + zi[j];
      	  j++;
      	}
        System.out.println(table);
    	for(int k=0;k<=180;k++){
	          String sql = "select * from pachong where zi like'%"+zi[k]+"%'";
	          biao2 ci = new biao2();
	          sta sss= new sta();
              int l = sss.selectClass(sql,null,ci,1);
            //if(l!=1 && zi[k].contains("节")){
              if(l!=1){
            	String sqln = "insert into "+table+" (zi,fu) values('"+zi[k]+"','"+fu[0]+"')";
            	l = sss.selectClass(sqln,null,ci,1);
            }
            System.out.println(l);
    	}
      System.out.println(result);
    	return result;
    	
   }
	   
        catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	       }
	    return null;
    }
	
}

