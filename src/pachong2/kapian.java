package pachong2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class kapian {

	String url="jdbc:mysql://localhost:3306/pachong??characterEncoding=gbk";
	String driver="com.mysql.jdbc.Driver";
	public static Statement st;
	public static Connection con;
	
	public biao getData(String name) throws SQLException{
	//������ݿ�δ���ӣ��򴴽�һ�����ݿ����Ӷ���
	if(con == null){
		init();
	}
	
	biao biao1 = new biao();
	String sql = "select * from chuantongjieri ";
	ResultSet  rs = st.executeQuery(sql);
	while(rs.next()){
		String name2 = "";
		
		if(name.contains("������ ")){
			name2 = name;
		}
		else{
			name2 = "������"+" "+name;
		}
		if(rs.getString("aa").contains(name2)){
			biao1.setAa(rs.getString("aa"));
			biao1.setBb(rs.getString("bb"));
			biao1.setCc(rs.getString("cc"));
			biao1.setDd(rs.getString("dd"));
			biao1.setEe(rs.getString("ee"));
			biao1.setFf(rs.getString("ff"));
			biao1.setGg(rs.getString("gg"));
			biao1.setHh(rs.getString("hh"));
			biao1.setIi(rs.getString("ii"));
			biao1.setJj(rs.getString("jj"));
			biao1.setKk(rs.getString("kk"));
			biao1.setLl(rs.getString("ll"));
			biao1.setMm(rs.getString("mm"));	
//			String sql2 = "select aa from chuantongjieri where dd='"+biao1.getDd()+"'";
//			System.out.println(sql2);
		}
	}
	return biao1;
	
	}
	
	/*************************
	 * ��ѯͬ���Ľ���
	 * @throws SQLException 
	 */
	public List<String> queryBrotherFestivals(String leibie) throws SQLException{
		
		//������ݿ�δ���ӣ��򴴽�һ�����ݿ����Ӷ���
		if(con == null){
			init();
		}
		String sql = "SELECT * from chuantongjieri where dd like '%" + leibie + "%'";
		
		List<String> festivalNameList = new ArrayList<String>();
		//ִ��SQL���
		ResultSet  rs = st.executeQuery(sql);
		while(rs.next()){
			festivalNameList.add(rs.getString("aa"));
		}
		
		return festivalNameList;
	}
	
	
	private void init(){
		
		if(con == null){
			try{
				Class.forName(driver);//��������
			}catch(ClassNotFoundException event)
				{
					System.out.print("�޷�����������ʽʵ��!");
				}
			try{
				con=DriverManager.getConnection(url,"root","931128");
				con.setAutoCommit(true);
				st=con.createStatement();
				//System.out.println("�Ѿ����ӵ����ݿ�...");
			}catch(SQLException e1) 
			{
				System.out.println("�쳣"+e1);
			}
		}
	}

}


