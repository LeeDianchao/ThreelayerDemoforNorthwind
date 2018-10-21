package data_northwind;

import java.util.Vector;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;

//统计图表
public class result_jfree {
	private JFrame frame;
	public void init(Vector Panel,String s) {
		frame=new JFrame("订单数据统计图:"+s);

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
