package data_northwind;

import java.awt.Font;

import java.text.SimpleDateFormat;
import java.util.Vector;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.TextAnchor;

 
//����ͼ
public class TimeSeriesChart {

	ChartPanel frame1;

	public TimeSeriesChart(Vector v,String s){

		XYDataset xydataset = createDataset(v,s);

		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(s, "����", "��������",xydataset, true, true, true);
		//����ʱ����ķ�Χ��
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();

		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();

        dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

        frame1=new ChartPanel(jfreechart,true);

        dateaxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����

        dateaxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����

        ValueAxis rangeAxis=xyplot.getRangeAxis();//��ȡ��״

        rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));

        jfreechart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));

        jfreechart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
        
        //���������Ƿ���ʾ���ݵ�
        XYLineAndShapeRenderer xylinerenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
        xylinerenderer.setBaseShapesVisible(true); 
        
        //����������ʾ�����ݵ��ֵ
        XYItemRenderer xyitem = xyplot.getRenderer(); 
        xyitem.setBaseItemLabelsVisible(true);
        xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER)); 
        xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 12)); 
        xyplot.setRenderer(xyitem);
        
       
	}
	
	private static XYDataset createDataset(Vector v,String s) {  

        TimeSeries timeseries = new TimeSeries(s,org.jfree.data.time.Month.class);

        int size=v.size();
	     for(int i=0;i<size;i++)
	     {
	    	 forstatis data=new forstatis();
	    	 data.set((forstatis)(v.get(i)));
	    	 String[] ss = data.name.split("-");
	    	// �������
	    	 timeseries.add(new Month(Integer.parseInt(ss[1]), Integer.parseInt(ss[0])), data.num);
	     }
	  // ����ʱ�����еļ���
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();

        timeseriescollection.addSeries(timeseries);
        
        return timeseriescollection;
	}
	
	public ChartPanel getChartPanel(){

    	return frame1;
    	
	}
}
