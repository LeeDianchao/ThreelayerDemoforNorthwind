package data_northwind;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Line {
	ChartPanel frame1;
	public Line(Vector v,String s) {
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
	    mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 15));
	    mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
	    mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
	    ChartFactory.setChartTheme(mChartTheme);		
	    CategoryDataset mDataset = GetDataset(v);
	    JFreeChart mChart = ChartFactory.createLineChart(
	        s,//图名字
	        "类别",//横坐标
	        "订单数量",//纵坐标
	        mDataset,//数据集
	        PlotOrientation.VERTICAL,
	        true, // 显示图例
	        true, // 采用标准生成器 
	        false);// 是否生成超链接
	    
	    CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
	    mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
	    mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
	    mPlot.setOutlinePaint(Color.RED);//边界线
	    
	    frame1=new ChartPanel(mChart,true);
	}
	
	public static CategoryDataset GetDataset(Vector v)
	{
	    DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
	    int size=v.size();
	    for(int i=0;i<size;i++)
	    {
	    	forstatis data=new forstatis();
	    	data.set((forstatis)(v.get(i)));
	    	mDataset.addValue(data.num,"",data.name);
	    }
	    return mDataset;
	}
	public ChartPanel getChartPanel()
	{
		return frame1;
	}
}
