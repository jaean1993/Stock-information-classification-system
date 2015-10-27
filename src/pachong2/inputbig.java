package pachong2;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import test.CheckService;
import tree.ManyNodeTree;
public class inputbig extends JFrame {
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	//�������
	public static JTextArea lb = new JTextArea();
	JTextArea lb1 = new JTextArea();
	//�����ı���
	JLabel label;
	String ss=null;
	StringBuilder leafbuffer =new StringBuilder() ;
 
	public inputbig(String title) {
  
  super(title);
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  ImageIcon icon=new ImageIcon("D:\\123.png");
  Image image=icon.getImage();
  label=new JLabel(icon);
  //����չʾͼƬ
  lb1.setBackground(Color.LIGHT_GRAY);
  lb1.setText("------------------��Ʊ����------------------");
  //���ò���--�߽粼��
  jp2.setLayout(new BorderLayout());
  jp1.add(label);
  jp2.add(lb , BorderLayout.WEST);
  jp2.add(lb1 , BorderLayout.EAST);
  
  JTextField  jtf=new JTextField(5);
	  jp1.setBackground(Color.WHITE);
	  jp2.setBackground(Color.WHITE);
	  jtf.setMargin(new Insets(4,4,4,4));//����������ǩ֮��֮��Ŀհ�
	  Container container = getContentPane();//ȡ���������
	  JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jp1, jp2);//����splitPane1�ķָ���λ��
	     container.add(splitPane1,BorderLayout.CENTER);
	     pack();
	     setSize(800,700);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setVisible(true);
	     splitPane1.setDividerLocation(0.3);//����JSplitPane�Ƿ����չ��������

	 
  initMenu();
  this.setVisible(true);
 }
 public void setBak(){ 
	  ((JPanel)this.getContentPane()).setOpaque(false);
	   ImageIcon img = new ImageIcon("D://123.png"); //���ͼƬ
	   JLabel background = new JLabel(img);
	   this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
	   background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
	  } 
 
 private void initMenu() {
  // �����˵�������
  JMenuBar mnuBar = new JMenuBar();
  // ������һ���˵���������׷�ӵ��˵�����
  JMenu mnuFirst = new JMenu("��ȡ����");
  mnuBar.add(mnuFirst);
  // ����һ���˵��������׷�ӵ��˵�mnuFirst��
  JMenuItem itmAdd = new JMenuItem("ͬ��˳��ȡ");
  mnuFirst.add(itmAdd);
  mnuFirst.addSeparator(); // ���Ӳ˵��ָ���
  // ����һ���˵��������׷�ӵ��˵�mnuFirst��
  itmAdd.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		  input in = new input();
		  in.setI(1);
		  in.input1();
	  }	 
  });
  
  //  ��Ӳ˵�ѡ����Ӧ
  JMenuItem itmExit = new JMenuItem("�ı���ȡ");
  mnuFirst.add(itmExit);
  mnuFirst.addSeparator();
  itmExit.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		  CheckService aa = new CheckService();
		  lb.setText(aa.text(null));
	  }	
  });
  JMenuItem itmAd = new JMenuItem("������");
  mnuFirst.add(itmAd);
  mnuFirst.addSeparator();
  itmAd.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
	  ManyNodeTree tree = new ManyNodeTree();
	  try{
	  lb.setText(tree.treeCre(leafbuffer));
	  }catch(SQLException e1)
	  {}
	  }	
  });
  // �����ڶ����˵���������׷�ӵ��˵�����
  JMenu mnuSecpmd = new JMenu("�γ�֪ʶ��Ƭ");
  mnuBar.add(mnuSecpmd);
  // ��mnuBar����Ϊ��ǰ���ڵĲ˵�������
  JMenuItem itmA1 = new JMenuItem("Ҷ�ӽڵ���ȡ");
  mnuSecpmd.add(itmA1);
  mnuSecpmd.addSeparator();
  itmA1.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		  lb.setText(leafbuffer.toString());
	  }
  });
  JMenuItem itmA2 = new JMenuItem("��ȡ֪ʶ��Ƭ");
  mnuSecpmd.add(itmA2);
  mnuSecpmd.addSeparator();
  this.setJMenuBar(mnuBar);
  itmA2.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		  input in = new input();
		  in.setI(0);
		  in.input1();
	  }	
  });
  JMenu mnuThird = new JMenu("������ϵչʾ");
  mnuBar.add(mnuThird);
  // ��mnuBar����Ϊ��ǰ���ڵĲ˵�������
  JMenuItem itmA3 = new JMenuItem("չʾЧ��");
  mnuThird .add(itmA3);
  mnuThird .addSeparator();
  itmA3.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		  
		  ImageIcon icon=new ImageIcon("D:\\456.png");
		  Image image=icon.getImage();
		  label.setIcon(icon);
	 }	  
  });
  JMenuItem itmA4 = new JMenuItem("����");
  mnuThird .add(itmA4);
  mnuThird .addSeparator();
  this.setJMenuBar(mnuBar);
  itmA4.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		  
		  input2 in = new input2(lb , lb1 , jp2);
	 }	  
  });
 }
 

 public static void main(String[] args) {
  inputbig app = new inputbig("֪ʶͼ�׷�����ϵ�Ĺ���");
 }
}