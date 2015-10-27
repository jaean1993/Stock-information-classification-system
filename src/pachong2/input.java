package pachong2;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.sql.*;

public class input
{
	int i;
	public static String result=null;
	JFrame frame = new JFrame("输入");
	JPanel pn = new JPanel();
	JButton b_ok = new JButton("确定");
	JButton b_cancel = new JButton("取消");
	JLabel l_url = new JLabel("请输入URL",SwingConstants.CENTER);
	JLabel l_location = new JLabel("请输入爬取位置",SwingConstants.CENTER);
	JLabel l_table = new JLabel("请输入选择的表",SwingConstants.CENTER);
	JLabel l_festival = new JLabel("请输入爬取股票",SwingConstants.CENTER);
	JTextField t_url = new JTextField();
	JTextField t_location = new JTextField();
	JTextField t_table = new JTextField();
	JTextField t_festival = new JTextField();
	public void input1(){
		b_ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String url = t_url.getText();
				String location = t_location.getText();
				String table = t_table.getText();
				String festival=t_festival.getText();
				if (i==1)
				{
			    WebSpider a = new WebSpider();
			    try {
			    	
			    	inputbig.lb.setText(a.art(url, location, table));
			    	
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				}
				if(i==0){
					aaa b = new aaa();
					b.article(url, location, table,festival);
					inputbig.lb.setText(b.article(url, location, table,festival));
				}
				frame.dispose();
			}
		});
		b_cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();//窗口消失
			}
		});
		frame.getContentPane().add(pn);
		pn.setLayout(new GridLayout(0,2));
		pn.add(l_url);
		pn.add(t_url);
		pn.add(l_location);
		pn.add(t_location);
		pn.add(l_table);
		pn.add(t_table);
		pn.add(l_festival);
		pn.add(t_festival);
		pn.add(b_ok);
		pn.add(b_cancel);
		frame.setSize(450,125);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
		
}