package data_northwind;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
//��״ͼ
public class PieChart {
	ChartPanel frame;

	public PieChart(Vector v,String s){

		  DefaultPieDataset data = getDataSet(v);

	      JFreeChart chart = ChartFactory.createPieChart3D(s,data,true,false,false);

	    //���ðٷֱ�

	      PiePlot pieplot = (PiePlot) chart.getPlot();

	      DecimalFormat df = new DecimalFormat("0.00%");//���һ��DecimalFormat������Ҫ������С������

	      NumberFormat nf = NumberFormat.getNumberInstance();//���һ��NumberFormat����

	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//���StandardPieSectionLabelGenerator����

	      pieplot.setLabelGenerator(sp1);//���ñ�ͼ��ʾ�ٷֱ�

	  

	  //û�����ݵ�ʱ����ʾ������

	      pieplot.setNoDataMessage("��������ʾ");

	      pieplot.setCircular(false);

	      pieplot.setLabelGap(0.02D);

	  

	      pieplot.setIgnoreNullValues(true);//���ò���ʾ��ֵ

	      pieplot.setIgnoreZeroValues(true);//���ò���ʾ��ֵ

	     frame=new ChartPanel (chart,true);

	      chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������

	      PiePlot piePlot= (PiePlot) chart.getPlot();//��ȡͼ���������

	      piePlot.setLabelFont(new Font("����",Font.BOLD,10));//�������

	      chart.getLegend().setItemFont(new Font("����",Font.BOLD,10));
	}
	
	private static DefaultPieDataset getDataSet(Vector v) {

	     DefaultPieDataset dataset = new DefaultPieDataset();
	     int size=v.size();
	     for(int i=0;i<size;i++)
	     {
	    	 forstatis data=new forstatis();
	    	 data.set((forstatis)(v.get(i)));
	    	 dataset.setValue(data.name,data.num);
	     }
	     
	     return dataset;
	 }
	
	public ChartPanel getChartPanel(){
		   
		   return frame;

	 }

}
