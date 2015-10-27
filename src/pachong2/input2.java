package pachong2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class input2 {
    String kaka;
	JFrame frame = new JFrame("股票搜索");
	JPanel pn = new JPanel();
	JButton b_ok = new JButton("确定");
	JButton b_cancel = new JButton("取消");
	JLabel l_name = new JLabel("请输入股票名称",SwingConstants.CENTER);
	JTextField t_name = new JTextField();
	public static kapian end = new kapian();
	public static JTextArea showFestivals;
	public static JTextArea festivalNameJTA;
	public static JPanel jp2;
	input2(JTextArea showFestivals , final JTextArea festivalNameJTA , JPanel jp2){
		this.showFestivals = showFestivals;
		this.festivalNameJTA = festivalNameJTA;
		this.jp2 = jp2;
		b_ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = t_name.getText();
				try {
					
					//根据输入的节日名称，查询知识卡片
					biao biao1 = end.getData(name);
					kaka=biao1.getAa()+"\n"+biao1.getBb()+"\n"+biao1.getCc()+"\n"+biao1.getDd()+"\n"+biao1.getEe()+"\n"+biao1.getFf()+"\n"+biao1.getGg()+"\n"+biao1.getHh()+"\n"+biao1.getIi()+"\n"+biao1.getKk();
					input2.showFestivals.setText(kaka);
					
					//显示相关的节日标签，节日类别肯定不为空，这里不做非空判断
					List<String> festivalNameList = end.queryBrotherFestivals(biao1.getDd());
					//查询出相关节日信息，然后加入到向量集合中，并且显示在界面上
					Vector vector = new Vector();
					vector.add("------------------股票详情------------------");
					for(String festivalNames : festivalNameList){
							vector.add(festivalNames);
					}
					//创建列表框对象
					 final JList lst = new JList(vector);
					lst.addListSelectionListener(new ListSelectionListener() {
						
						/**
						 * 列表项选择监听事件
						 * @author yun
						 * @date 2015/5/21
						 */
						@Override
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							String selectedFestival = (String) lst.getSelectedValue();
							//若是选择第一个选项，则不执行SQL查询
							if(lst.getSelectedIndex() == 0){
								return;
							}
							try {
								biao biao1 = end.getData(selectedFestival);
								kaka=biao1.getAa()+"\n"+biao1.getBb()+"\n"+biao1.getCc()+"\n"+biao1.getDd()+"\n"+biao1.getEe()+"\n"+biao1.getFf()+"\n"+biao1.getGg()+"\n"+biao1.getHh()+"\n"+biao1.getIi()+"\n"+biao1.getKk();
								input2.showFestivals.setText(kaka);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					
					//移除文本域，添加列表框
					input2.jp2.remove(festivalNameJTA);
					input2.jp2.add(lst ,  BorderLayout.EAST);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			
}
		});
	
		
		b_cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		frame.getContentPane().add(pn);
		pn.setLayout(new GridLayout(0,2));
		pn.add(l_name);
		pn.add(t_name);
		pn.add(b_ok);
		pn.add(b_cancel);
		frame.setSize(350,70);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
