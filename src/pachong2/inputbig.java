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
	//定义面板
	public static JTextArea lb = new JTextArea();
	JTextArea lb1 = new JTextArea();
	//定义文本框
	JLabel label;
	String ss=null;
	StringBuilder leafbuffer =new StringBuilder() ;
 
	public inputbig(String title) {
  
  super(title);
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  ImageIcon icon=new ImageIcon("D:\\123.png");
  Image image=icon.getImage();
  label=new JLabel(icon);
  //界面展示图片
  lb1.setBackground(Color.LIGHT_GRAY);
  lb1.setText("------------------股票详情------------------");
  //设置布局--边界布局
  jp2.setLayout(new BorderLayout());
  jp1.add(label);
  jp2.add(lb , BorderLayout.WEST);
  jp2.add(lb1 , BorderLayout.EAST);
  
  JTextField  jtf=new JTextField(5);
	  jp1.setBackground(Color.WHITE);
	  jp2.setBackground(Color.WHITE);
	  jtf.setMargin(new Insets(4,4,4,4));//设置组件与标签之际之间的空白
	  Container container = getContentPane();//取得容器面板
	  JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jp1, jp2);//设置splitPane1的分隔线位置
	     container.add(splitPane1,BorderLayout.CENTER);
	     pack();
	     setSize(800,700);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setVisible(true);
	     splitPane1.setDividerLocation(0.3);//设置JSplitPane是否可以展开或收起

	 
  initMenu();
  this.setVisible(true);
 }
 public void setBak(){ 
	  ((JPanel)this.getContentPane()).setOpaque(false);
	   ImageIcon img = new ImageIcon("D://123.png"); //添加图片
	   JLabel background = new JLabel(img);
	   this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
	   background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
	  } 
 
 private void initMenu() {
  // 创建菜单栏对象
  JMenuBar mnuBar = new JMenuBar();
  // 创建第一个菜单，并将它追加到菜单栏中
  JMenu mnuFirst = new JMenu("爬取数据");
  mnuBar.add(mnuFirst);
  // 创建一个菜单项，并将它追加到菜单mnuFirst中
  JMenuItem itmAdd = new JMenuItem("同花顺爬取");
  mnuFirst.add(itmAdd);
  mnuFirst.addSeparator(); // 增加菜单分隔符
  // 创建一个菜单项，并将它追加到菜单mnuFirst中
  itmAdd.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		  input in = new input();
		  in.setI(1);
		  in.input1();
	  }	 
  });
  
  //  添加菜单选项响应
  JMenuItem itmExit = new JMenuItem("文本提取");
  mnuFirst.add(itmExit);
  mnuFirst.addSeparator();
  itmExit.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		  CheckService aa = new CheckService();
		  lb.setText(aa.text(null));
	  }	
  });
  JMenuItem itmAd = new JMenuItem("分类树");
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
  // 创建第二个菜单，并将它追加到菜单栏中
  JMenu mnuSecpmd = new JMenu("形成知识卡片");
  mnuBar.add(mnuSecpmd);
  // 将mnuBar设置为当前窗口的菜单栏对象
  JMenuItem itmA1 = new JMenuItem("叶子节点提取");
  mnuSecpmd.add(itmA1);
  mnuSecpmd.addSeparator();
  itmA1.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		  lb.setText(leafbuffer.toString());
	  }
  });
  JMenuItem itmA2 = new JMenuItem("爬取知识卡片");
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
  JMenu mnuThird = new JMenu("分类体系展示");
  mnuBar.add(mnuThird);
  // 将mnuBar设置为当前窗口的菜单栏对象
  JMenuItem itmA3 = new JMenuItem("展示效果");
  mnuThird .add(itmA3);
  mnuThird .addSeparator();
  itmA3.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		  
		  ImageIcon icon=new ImageIcon("D:\\456.png");
		  Image image=icon.getImage();
		  label.setIcon(icon);
	 }	  
  });
  JMenuItem itmA4 = new JMenuItem("搜索");
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
  inputbig app = new inputbig("知识图谱分类体系的构建");
 }
}