package tree;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pachong2.biao2;

public class sta2 {
	
	String url="jdbc:mysql://localhost:3306/pachong?characterEncoding=gbk";
	String driver="com.mysql.jdbc.Driver";
	Statement st;
	Connection con;
	
	public List<biao2> getAllData() throws SQLException{
	
	try{
		Class.forName(driver);//��������
	}catch(ClassNotFoundException event)
		{System.out.print("�޷�����������ʽʵ��!");
		}
	try{
		con=DriverManager.getConnection(url,"root","931128");
		con.setAutoCommit(true);
		//System.out.println("�Ѿ����ӵ����ݿ�...");
	}catch(SQLException e1) 
	{System.out.println("�쳣"+e1);}
	
	
	
	List<biao2> data = new ArrayList<>();
	String sql = "select * from pachong";
	st=con.createStatement();
	ResultSet  rs = st.executeQuery(sql);
	while(rs.next()){
		biao2 da = new biao2();
		da.setfu(rs.getString("fu"));
		da.setzi(rs.getString("zi"));
		data.add(da);
	}
	return data;
	
	}
	
	

}
