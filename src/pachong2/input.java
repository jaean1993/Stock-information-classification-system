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
	JFrame frame = new JFrame("����");
	JPanel pn = new JPanel();
	JButton b_ok = new JButton("ȷ��");
	JButton b_cancel = new JButton("ȡ��");
	JLabel l_url = new JLabel("������URL",SwingConstants.CENTER);
	JLabel l_location = new JLabel("��������ȡλ��",SwingConstants.CENTER);
	JLabel l_table = new JLabel("������ѡ��ı�",SwingConstants.CENTER);
	JLabel l_festival = new JLabel("��������ȡ��Ʊ",SwingConstants.CENTER);
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
				frame.dispose();//������ʧ
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