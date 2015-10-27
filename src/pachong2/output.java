package pachong2;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.*;

public class output 
{
	JFrame frame = new JFrame("Êä³ö");
	JPanel pn = new JPanel();
	JScrollPane scp = new JScrollPane();
	JButton ok = new JButton("È·¶¨");
	output(JTable jtable){
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		frame.getContentPane().add(pn);
		pn.setLayout(new BorderLayout());
		pn.add(ok,BorderLayout.SOUTH);
		pn.add(scp);
		scp.getViewport().add(jtable);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
