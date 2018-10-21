package data_northwind;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
//表现层
public class Presentation {

	private JFrame frame;
	private JTextField enterField;
	private int type;
	private BUS _userBUS;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Presentation window = new Presentation();
					window.frame.setTitle("信息查询");
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Presentation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_userBUS = new BUS();
		frame = new JFrame();
		frame.setBounds(100, 100, 372, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		    	  System.out.println("断开与服务器的连接");
		    	  _userBUS.exit();
			      }
			    });
		type=1;
		JLabel enterLabel = new JLabel("输入信息");
		
		enterField = new JTextField();
		enterField.setColumns(10);
		ButtonGroup floorGroup=new ButtonGroup();
		JRadioButton orderRadioButton = new JRadioButton("订单信息");
		orderRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=1;
				//System.out.println(type);
			}
		});
		JRadioButton customerRadioButton = new JRadioButton("客户信息");
		customerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=2;
				//System.out.println(type);
				
			}
		});
		JRadioButton employeeRadioButton = new JRadioButton("员工信息");
		employeeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=3;
				//System.out.println(type);
			}
		});
		floorGroup.add(orderRadioButton);
		floorGroup.add(customerRadioButton);
		floorGroup.add(employeeRadioButton);
		JButton buttonbyname = new JButton("按名称查询");
		buttonbyname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=enterField.getText();
	        	System.out.println(name);
	        	Vector rs=_userBUS.getByName(name, type);
	        	if(rs.size()==0)
	        	{
	        		JOptionPane.showMessageDialog(null, "没有找到相关记录!\n请核实所输入的信息。", "消息", JOptionPane.INFORMATION_MESSAGE);
	        	}
	        	else
	        	{
	        		new result_table().init(rs, type);
	        	}
			}
		});
		
		JButton buttonbyid = new JButton("按ID查询");
		buttonbyid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=enterField.getText();
	        	System.out.println(id);
	        	Vector rs=_userBUS.getById(id, type);
	        	if(rs.size()==0)
	        	{
	        		JOptionPane.showMessageDialog(null, "没有找到相关记录!\n请核实所输入的信息。", "消息", JOptionPane.INFORMATION_MESSAGE);
	        	}
	        	else
	        	{
	        		new result_table().init(rs, type);
	        	}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(orderRadioButton)
								.addComponent(customerRadioButton)
								.addComponent(employeeRadioButton)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(buttonbyname, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addGap(40)
									.addComponent(buttonbyid, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
								.addComponent(enterField, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(enterLabel)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(enterLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(enterField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(orderRadioButton)
					.addGap(5)
					.addComponent(customerRadioButton)
					.addGap(5)
					.addComponent(employeeRadioButton)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonbyname)
						.addComponent(buttonbyid)))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("查询");
		menuBar.add(menu);
		
		JMenuItem orderItem = new JMenuItem("订单信息");
		menu.add(orderItem);
		orderItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=1;
				//System.out.println(type);
				Vector rs=_userBUS.getByName("", type);
        		new result_table().init(rs, type);
			}
		});
		JMenuItem customerItem = new JMenuItem("客户信息");
		menu.add(customerItem);
		customerItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=2;
				//System.out.println(type);
				Vector rs=_userBUS.getByName("", type);
        		new result_table().init(rs, type);
			}
		});
		JMenuItem employeeItem = new JMenuItem("员工信息");
		menu.add(employeeItem);
		employeeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=3;
				//System.out.println(type);
				Vector rs=_userBUS.getByName("", type);
        		new result_table().init(rs, type);
			}
		});
		JMenu mnNewMenu = new JMenu("统计订单");
		menuBar.add(mnNewMenu);
		
		JMenu customerMenu = new JMenu("按客户ID统计");
		mnNewMenu.add(customerMenu);
		
		JMenuItem customerbarItem = new JMenuItem("柱状图");
		customerMenu.add(customerbarItem);
		customerbarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarChart b=new BarChart(_userBUS.getDataSetforBarChart(1),"按客户ID统计");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"按客户ID统计-柱状图");
				
			}
		});
		JMenuItem customerpieItem = new JMenuItem("饼状图");
		customerMenu.add(customerpieItem);
		
		customerpieItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChart b=new PieChart(_userBUS.getDataSetforPieChart(1),"按客户ID统计");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"按客户ID统计-饼状图");
				
			}
		});
		
		JMenuItem customerlineItem = new JMenuItem("折线图");
		customerMenu.add(customerlineItem);
		customerlineItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Line l=new Line(_userBUS.getDataSetforPieChart(1),"按客户ID统计");
				Vector Panel=new Vector();
				Panel.add(l.getChartPanel());
				new result_jfree().init(Panel,"按客户ID统计-折线图");
				
			}
		});
		
		JMenu employeeMenu = new JMenu("按员工ID统计");
		mnNewMenu.add(employeeMenu);
		
		JMenuItem employeebarItem = new JMenuItem("柱状图");
		employeeMenu.add(employeebarItem);
		employeebarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarChart b=new BarChart(_userBUS.getDataSetforBarChart(2),"按员工ID统计");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"按员工ID统计-柱状图");
				
			}
		});
		JMenuItem employeepieItem = new JMenuItem("饼状图");
		employeeMenu.add(employeepieItem);
		
		employeepieItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChart b=new PieChart(_userBUS.getDataSetforPieChart(2),"按员工ID统计");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"按员工ID统计-饼状图");
				
			}
		});
		
		JMenuItem employeelineItem = new JMenuItem("折线图");
		employeeMenu.add(employeelineItem);
		employeelineItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Line l=new Line(_userBUS.getDataSetforPieChart(2),"按员工ID统计");
				Vector Panel=new Vector();
				Panel.add(l.getChartPanel());
				new result_jfree().init(Panel,"按员工ID统计-折线图");
				
			}
		});
		
		JMenu OrderDateMenu = new JMenu("按订购日期统计");
		mnNewMenu.add(OrderDateMenu);
		
		JMenuItem orderdatebarItem = new JMenuItem("柱状图");
		OrderDateMenu.add(orderdatebarItem);
		orderdatebarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarChart b=new BarChart(_userBUS.getDataSetforBarChart(3),"按订购日期统计");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"按订购日期统计-柱状图");
				
			}
		});
		JMenuItem orderdatepieItem = new JMenuItem("饼状图");
		OrderDateMenu.add(orderdatepieItem);
		orderdatepieItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChart p=new PieChart(_userBUS.getDataSetforPieChart(3),"按订购日期统计");
				Vector Panel=new Vector();
				Panel.add(p.getChartPanel());
				new result_jfree().init(Panel,"按订购日期统计-饼状图");
				
			}
		});
		JMenuItem orderdatetimeItem = new JMenuItem("折线图");
		OrderDateMenu.add(orderdatetimeItem);
		
		orderdatetimeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeSeriesChart t=new TimeSeriesChart(_userBUS.getDataSetforTime(3),"按订购日期统计");
				Vector Panel=new Vector();
				
				Panel.add(t.getChartPanel());
				new result_jfree().init(Panel,"按订购日期统计-折线图");
				
			}
		});
		

		JMenu Countrymenu = new JMenu("按国家统计");
		mnNewMenu.add(Countrymenu);
		
		JMenuItem countrybarItem = new JMenuItem("柱状图");
		Countrymenu.add(countrybarItem);
		countrybarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarChart b=new BarChart(_userBUS.getDataSetforBarChart(4),"按国家统计");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"按国家统计-柱状图");
				
			}
		});
		JMenuItem countrypieItem = new JMenuItem("饼状图");
		Countrymenu.add(countrypieItem);
		
		
		countrypieItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChart p=new PieChart(_userBUS.getDataSetforPieChart(4),"按国家统计");
				Vector Panel=new Vector();
				Panel.add(p.getChartPanel());
				new result_jfree().init(Panel,"按国家统计-饼状图");
				
			}
		});
		JMenuItem countrylineItem = new JMenuItem("折线图");
		Countrymenu.add(countrylineItem);
		countrylineItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Line l=new Line(_userBUS.getDataSetforTime(4),"按国家统计");
				Vector Panel=new Vector();
				Panel.add(l.getChartPanel());
				new result_jfree().init(Panel,"按国家统计-折线图");
				
			}
		});
	}
	
}
