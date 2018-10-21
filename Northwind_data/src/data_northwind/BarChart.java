package data_northwind;

import java.awt.Font;
import java.util.Vector;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
//��״ͼ
public class BarChart {
	ChartPanel frame;
	
	public  BarChart(Vector v,String s){
		CategoryDataset dataset = getDataSet(v);

      JFreeChart chart = ChartFactory.createBarChart3D(

     		                 s, // ͼ�����

                          "���", // Ŀ¼�����ʾ��ǩ

                          "��������", // ��ֵ�����ʾ��ǩ

                          dataset, // ���ݼ�

                          PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ

                          true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)

                          false,          // �Ƿ����ɹ���

                          false           // �Ƿ�����URL����

                          );

      

      //�����￪ʼ

      CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������

      CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�

      domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����

      domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����

      ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״

      rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));

      chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));

      chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������

        

      //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������

     frame=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame
	
	}
	
	private static CategoryDataset getDataSet(Vector v) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int size=v.size();
        for(int i=0;i<size;i++)
        {
        	forstatis data=new forstatis();
        	data.set((forstatis)(v.get(i)));
        	dataset.addValue(data.num, data.name, data.name);
        }
        
        return dataset;
        
	}
	
	public ChartPanel getChartPanel(){

		return frame;

	}
}
