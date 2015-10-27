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
	JFrame frame = new JFrame("��Ʊ����");
	JPanel pn = new JPanel();
	JButton b_ok = new JButton("ȷ��");
	JButton b_cancel = new JButton("ȡ��");
	JLabel l_name = new JLabel("�������Ʊ����",SwingConstants.CENTER);
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
					
					//��������Ľ������ƣ���ѯ֪ʶ��Ƭ
					biao biao1 = end.getData(name);
					kaka=biao1.getAa()+"\n"+biao1.getBb()+"\n"+biao1.getCc()+"\n"+biao1.getDd()+"\n"+biao1.getEe()+"\n"+biao1.getFf()+"\n"+biao1.getGg()+"\n"+biao1.getHh()+"\n"+biao1.getIi()+"\n"+biao1.getKk();
					input2.showFestivals.setText(kaka);
					
					//��ʾ��صĽ��ձ�ǩ���������϶���Ϊ�գ����ﲻ���ǿ��ж�
					List<String> festivalNameList = end.queryBrotherFestivals(biao1.getDd());
					//��ѯ����ؽ�����Ϣ��Ȼ����뵽���������У�������ʾ�ڽ�����
					Vector vector = new Vector();
					vector.add("------------------��Ʊ����------------------");
					for(String festivalNames : festivalNameList){
							vector.add(festivalNames);
					}
					//�����б�����
					 final JList lst = new JList(vector);
					lst.addListSelectionListener(new ListSelectionListener() {
						
						/**
						 * �б���ѡ������¼�
						 * @author yun
						 * @date 2015/5/21
						 */
						@Override
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							String selectedFestival = (String) lst.getSelectedValue();
							//����ѡ���һ��ѡ���ִ��SQL��ѯ
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
					
					//�Ƴ��ı�������б��
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
