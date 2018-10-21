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

 
//折线图
public class TimeSeriesChart {

	ChartPanel frame1;

	public TimeSeriesChart(Vector v,String s){

		XYDataset xydataset = createDataset(v,s);

		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(s, "日期", "订单数量",xydataset, true, true, true);
		//设置时间轴的范围。
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();

		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();

        dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

        frame1=new ChartPanel(jfreechart,true);

        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题

        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题

        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状

        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));

        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));

        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        
        //设置曲线是否显示数据点
        XYLineAndShapeRenderer xylinerenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
        xylinerenderer.setBaseShapesVisible(true); 
        
        //设置曲线显示各数据点的值
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
	    	// 添加数据
	    	 timeseries.add(new Month(Integer.parseInt(ss[1]), Integer.parseInt(ss[0])), data.num);
	     }
	  // 定义时间序列的集合
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();

        timeseriescollection.addSeries(timeseries);
        
        return timeseriescollection;
	}
	
	public ChartPanel getChartPanel(){

    	return frame1;
    	
	}
}
