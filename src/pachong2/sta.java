package pachong2;

import java.sql.*;
public class sta {
public int selectClass(String sql,biao bi,biao2 ci,int cat) {
// TODO Auto-generated method stub
	String url="jdbc:mysql://localhost:3306/pachong?characterEncoding=gbk";
	String driver="com.mysql.jdbc.Driver";

	int i= -1;  
	Statement st;
	Connection con;
	try{
		Class.forName(driver);//加载驱动
	}catch(ClassNotFoundException event)
		{System.out.print("无法创建驱动程式实体!");
		return -1;}
	try{
		con=DriverManager.getConnection(url,"root","931128");
		con.setAutoCommit(true);
		
		st=con.createStatement();
		String sqlmethod=sql.substring(0, 6);
		System.out.println(sqlmethod);
		if(sqlmethod.equals("insert")||sqlmethod.equals("update")){
			st.executeUpdate(sql);
		}else{
		ResultSet  rs = st.executeQuery(sql);		
		
		
		if(rs.next()==true){
		if(cat==0){//cat=0时，查询复杂的表
			
			while(rs.next()){
				
				String iaa=rs.getString("aa");
				System.out.println("chenggongleyiban");
				bi.setAa(iaa);
				System.out.println("sssuccess");
				String ibb=rs.getString("bb");
				bi.setBb(ibb);
				String icc=rs.getString("cc");
				bi.setCc(icc);
				String idd=rs.getString("dd");
				bi.setDd(idd);
				String iee=rs.getString("ee");
				bi.setEe(iee);
				String iff=rs.getString("ff");
				bi.setFf(iff);
				String igg=rs.getString("gg");
				bi.setGg(igg);
				String ihh=rs.getString("hh");
				bi.setHh(ihh);
				String iii=rs.getString("ii");
				bi.setIi(iii);
				String ijj=rs.getString("jj");
				bi.setJj(ijj);
				String ikk=rs.getString("kk");
				bi.setKk(ikk);
				String ill=rs.getString("ll");
				bi.setLl(ill);
				String imm=rs.getString("mm");
				bi.setMm(imm);
				/*bi.setAa(rs.getString("aa"));
				bi.setBb(rs.getString("bb"));
				bi.setCc(rs.getString("cc"));
				bi.setDd(rs.getString("dd"));
				bi.setEe(rs.getString("ee"));
				bi.setFf(rs.getString("ff"));
				bi.setGg(rs.getString("gg"));
				bi.setHh(rs.getString("hh"));
				bi.setIi(rs.getString("ii"));
				bi.setJj(rs.getString("jj"));
				bi.setKk(rs.getString("kk"));
				bi.setLl(rs.getString("ll"));
				bi.setMm(rs.getString("mm"));*/
			}
		}
		if(cat==1){
			while(rs.next()){
				String izi=rs.getString("zi");
				ci.setzi(izi);
				String ifu=rs.getString("fu");
				ci.setfu(ifu);
			}
				//ci.setzi(rs.getString("zi"));
				//ci.setfu(rs.getString("fu"));
		}
		i=1;
		}}
		st.close();
		con.close(); 
		return i;
	}catch(SQLException e1) 
		{System.out.println("异常"+e1);}
	return i;
	}
}
	  

