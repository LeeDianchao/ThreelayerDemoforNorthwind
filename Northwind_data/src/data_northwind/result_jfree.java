package data_northwind;

import java.util.Vector;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;

//ͳ��ͼ��
public class result_jfree {
	private JFrame frame;
	public void init(Vector Panel,String s) {
		frame=new JFrame("��������ͳ��ͼ:"+s);

		int size=Panel.size();
		for(int i=0;i<size;i++)
		{
			frame.add((ChartPanel)Panel.get(i));
		}
		frame.setBounds(50, 50, 1500, 1100);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
