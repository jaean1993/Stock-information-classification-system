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
 
	public  String art(String url,String table) throws UnsupportedEncodingException  {
		
		
		 String encodedString = URLEncoder.encode(url, "UTF-8");
		 String result=null;
	    try {
	    	
	    String decodeString = URLDecoder.decode(encodedString,"UTF-8");
	    Document doc = Jsoup.connect(decodeString).timeout(8000).get();
    	
    	//httpunit����
    	/*HttpUnitOptions.setScriptingEnabled(false);
    	WebConversation wc = new WebConversation();
		 WebResponse wr = wc.getResponse(decodeString);
		 System.out.println(wr.getText());*/
		 
    	String fu[] = new String[80];
    	String zi[] = new String[80];
    	
    	
        
        if(table.equals("treedata")){
        	int i=0;
        	Elements links = doc.select("strong");
        	for (Element link : links) {
            	  zi[i] = link.text();
            	  i++;	
            	}
        	//��ȡ����λ��ϵ
        	Elements type=doc.select("p.fl > span.f14");
        	String types=type.text();
        	String type_array[]=types.split("--");
        	
            if(type_array[2]!=""){                	
                String ori_data=type_array[2];
                String[] mid_data=ori_data.split("\\��");
                type_array[2]=mid_data[0];
            }
            
            for(int k=1;k<type_array.length;k++){
                String sql = "select * from "+table+" where zi like'%"+type_array[k].trim()+"%'";
                biao2 node = new biao2();
                sta db_thing=new sta();
                int h=db_thing.selectClass(sql, null, node, 1);
                //h!=1˵��database�������ֵ
                if(h!=1){
                	sql="insert into "+table+" (zi,fu) values('"+type_array[k].trim()+"','"+type_array[k-1].trim()+"')";
                	
                	h=db_thing.selectClass(sql, null, node, 1);
                	if(k==type_array.length-1){
                		sql="insert into "+table+" (zi,fu) values('"+zi[0].trim()+"','"+type_array[k].trim()+"')";
                   	}
                	h=db_thing.selectClass(sql, null, node, 1);
                }
                result=result+"\n" +type_array[k];
            }
        }else {
        	String website[]=url.split("\\.");
        	if(website[1].trim().equals("cfi")){
        		//�в���ȡ��ҵ��ع�Ʊ
        		Elements type=doc.select("div.Lfont");
        		String[] stock_names=type.text().split("\\(");
        		String stock_name=stock_names[0].trim();
                Elements up_ones=doc.select("div.Rtable td > a");
                String up_one=up_ones.text();
                String[] competitor_names=up_one.trim().split(" ");


                String sql="select * from "+table+" where stock_name like '%"+stock_name+"%' ";
                biao2 id=new biao2();
                sta db_thing=new sta();
                int j=db_thing.selectClass(sql,null,id,2);
                if(j==1){
                    sql="update "+table+" set upone='"+competitor_names[0].trim()+"', uptwo='"+competitor_names[1].trim()+"',downone='"+competitor_names[8].trim()+"',downtwo='"+competitor_names[9].trim()+"' where id="+id.id;
                    //��ͬ�ڸ��ӹ�ϵ����ƱΪ��̬���ݣ���Ҫupdate
                    db_thing.selectClass(sql,null,id,2);
                }else{
                     sql="insert into "+table+" (stock_name,upone,uptwo,downone,downtwo) values('"+stock_name+"','"+competitor_names[0].trim()+"','"+competitor_names[1].trim()+"','"+competitor_names[8].trim()+"','"+competitor_names[9].trim()+"')";
                    db_thing.selectClass(sql,null,id,2);
                }

                
        	}else if(website[2].equals("163")){
            //����ȡconneciton
                Elements type=doc.select("h1 a");
                String[] stock_names=type.text().trim().split(" ");
                String stock_name=stock_names[0];
                Element connections=doc.select("ul.disc_list").first();
                String[] connection_names=connections.text().split(" ");


                String sql="select * from "+table+" where stock_name like '%"+stock_name+"%' ";
                biao2 id=new biao2();
                sta db_thing=new sta();
                int j=db_thing.selectClass(sql,null,id,2);
                if(j==1){
                    sql="update "+table+" set ";
                    for(int a=0;a<connection_names.length;a++){
                        if(a==connection_names.length-1){
                            sql=sql+"co_"+a+"='"+connection_names[a].trim()+"'";
                        }
                        else{
                            sql=sql+"co_"+a+"='"+connection_names[a].trim()+"',";
                        }
                    }
                    sql+=" where id="+id.id;
                    //��ͬ�ڸ��ӹ�ϵ����̬���ݣ���Ҫupdate
                    db_thing.selectClass(sql,null,id,2);
                }else{
                     sql="insert into "+table+" (stock_name) values('"+stock_name+"')";
                     for(int a=0;a<connection_names.length;a++){
                        sql="update "+table+" set (co_"+a+") values('"+connection_names[a].trim()+"') where id="+id.id;
                        db_thing.selectClass(sql,null,id,2);
                    }
                    //���д�����ȷ������ݿ�
                }
        		
        	}else{
        		 result=null;
        	}
        
        }
        //result��java swing �����ʾֵ����
    	return result;
    	
   }
	   
        catch (IOException  e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	       }
	    return null;
    }

	
}

