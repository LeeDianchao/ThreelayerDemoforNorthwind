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
//���ֲ�
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
					window.frame.setTitle("��Ϣ��ѯ");
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
		    	  System.out.println("�Ͽ��������������");
		    	  _userBUS.exit();
			      }
			    });
		type=1;
		JLabel enterLabel = new JLabel("������Ϣ");
		
		enterField = new JTextField();
		enterField.setColumns(10);
		ButtonGroup floorGroup=new ButtonGroup();
		JRadioButton orderRadioButton = new JRadioButton("������Ϣ");
		orderRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=1;
				//System.out.println(type);
			}
		});
		JRadioButton customerRadioButton = new JRadioButton("�ͻ���Ϣ");
		customerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=2;
				//System.out.println(type);
				
			}
		});
		JRadioButton employeeRadioButton = new JRadioButton("Ա����Ϣ");
		employeeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=3;
				//System.out.println(type);
			}
		});
		floorGroup.add(orderRadioButton);
		floorGroup.add(customerRadioButton);
		floorGroup.add(employeeRadioButton);
		JButton buttonbyname = new JButton("�����Ʋ�ѯ");
		buttonbyname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=enterField.getText();
	        	System.out.println(name);
	        	Vector rs=_userBUS.getByName(name, type);
	        	if(rs.size()==0)
	        	{
	        		JOptionPane.showMessageDialog(null, "û���ҵ���ؼ�¼!\n���ʵ���������Ϣ��", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
	        	}
	        	else
	        	{
	        		new result_table().init(rs, type);
	        	}
			}
		});
		
		JButton buttonbyid = new JButton("��ID��ѯ");
		buttonbyid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=enterField.getText();
	        	System.out.println(id);
	        	Vector rs=_userBUS.getById(id, type);
	        	if(rs.size()==0)
	        	{
	        		JOptionPane.showMessageDialog(null, "û���ҵ���ؼ�¼!\n���ʵ���������Ϣ��", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
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
		
		JMenu menu = new JMenu("��ѯ");
		menuBar.add(menu);
		
		JMenuItem orderItem = new JMenuItem("������Ϣ");
		menu.add(orderItem);
		orderItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=1;
				//System.out.println(type);
				Vector rs=_userBUS.getByName("", type);
        		new result_table().init(rs, type);
			}
		});
		JMenuItem customerItem = new JMenuItem("�ͻ���Ϣ");
		menu.add(customerItem);
		customerItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=2;
				//System.out.println(type);
				Vector rs=_userBUS.getByName("", type);
        		new result_table().init(rs, type);
			}
		});
		JMenuItem employeeItem = new JMenuItem("Ա����Ϣ");
		menu.add(employeeItem);
		employeeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type=3;
				//System.out.println(type);
				Vector rs=_userBUS.getByName("", type);
        		new result_table().init(rs, type);
			}
		});
		JMenu mnNewMenu = new JMenu("ͳ�ƶ���");
		menuBar.add(mnNewMenu);
		
		JMenu customerMenu = new JMenu("���ͻ�IDͳ��");
		mnNewMenu.add(customerMenu);
		
		JMenuItem customerbarItem = new JMenuItem("��״ͼ");
		customerMenu.add(customerbarItem);
		customerbarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarChart b=new BarChart(_userBUS.getDataSetforBarChart(1),"���ͻ�IDͳ��");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"���ͻ�IDͳ��-��״ͼ");
				
			}
		});
		JMenuItem customerpieItem = new JMenuItem("��״ͼ");
		customerMenu.add(customerpieItem);
		
		customerpieItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChart b=new PieChart(_userBUS.getDataSetforPieChart(1),"���ͻ�IDͳ��");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"���ͻ�IDͳ��-��״ͼ");
				
			}
		});
		
		JMenuItem customerlineItem = new JMenuItem("����ͼ");
		customerMenu.add(customerlineItem);
		customerlineItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Line l=new Line(_userBUS.getDataSetforPieChart(1),"���ͻ�IDͳ��");
				Vector Panel=new Vector();
				Panel.add(l.getChartPanel());
				new result_jfree().init(Panel,"���ͻ�IDͳ��-����ͼ");
				
			}
		});
		
		JMenu employeeMenu = new JMenu("��Ա��IDͳ��");
		mnNewMenu.add(employeeMenu);
		
		JMenuItem employeebarItem = new JMenuItem("��״ͼ");
		employeeMenu.add(employeebarItem);
		employeebarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarChart b=new BarChart(_userBUS.getDataSetforBarChart(2),"��Ա��IDͳ��");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"��Ա��IDͳ��-��״ͼ");
				
			}
		});
		JMenuItem employeepieItem = new JMenuItem("��״ͼ");
		employeeMenu.add(employeepieItem);
		
		employeepieItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChart b=new PieChart(_userBUS.getDataSetforPieChart(2),"��Ա��IDͳ��");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"��Ա��IDͳ��-��״ͼ");
				
			}
		});
		
		JMenuItem employeelineItem = new JMenuItem("����ͼ");
		employeeMenu.add(employeelineItem);
		employeelineItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Line l=new Line(_userBUS.getDataSetforPieChart(2),"��Ա��IDͳ��");
				Vector Panel=new Vector();
				Panel.add(l.getChartPanel());
				new result_jfree().init(Panel,"��Ա��IDͳ��-����ͼ");
				
			}
		});
		
		JMenu OrderDateMenu = new JMenu("����������ͳ��");
		mnNewMenu.add(OrderDateMenu);
		
		JMenuItem orderdatebarItem = new JMenuItem("��״ͼ");
		OrderDateMenu.add(orderdatebarItem);
		orderdatebarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarChart b=new BarChart(_userBUS.getDataSetforBarChart(3),"����������ͳ��");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"����������ͳ��-��״ͼ");
				
			}
		});
		JMenuItem orderdatepieItem = new JMenuItem("��״ͼ");
		OrderDateMenu.add(orderdatepieItem);
		orderdatepieItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChart p=new PieChart(_userBUS.getDataSetforPieChart(3),"����������ͳ��");
				Vector Panel=new Vector();
				Panel.add(p.getChartPanel());
				new result_jfree().init(Panel,"����������ͳ��-��״ͼ");
				
			}
		});
		JMenuItem orderdatetimeItem = new JMenuItem("����ͼ");
		OrderDateMenu.add(orderdatetimeItem);
		
		orderdatetimeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeSeriesChart t=new TimeSeriesChart(_userBUS.getDataSetforTime(3),"����������ͳ��");
				Vector Panel=new Vector();
				
				Panel.add(t.getChartPanel());
				new result_jfree().init(Panel,"����������ͳ��-����ͼ");
				
			}
		});
		

		JMenu Countrymenu = new JMenu("������ͳ��");
		mnNewMenu.add(Countrymenu);
		
		JMenuItem countrybarItem = new JMenuItem("��״ͼ");
		Countrymenu.add(countrybarItem);
		countrybarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarChart b=new BarChart(_userBUS.getDataSetforBarChart(4),"������ͳ��");
				Vector Panel=new Vector();
				Panel.add(b.getChartPanel());
				new result_jfree().init(Panel,"������ͳ��-��״ͼ");
				
			}
		});
		JMenuItem countrypieItem = new JMenuItem("��״ͼ");
		Countrymenu.add(countrypieItem);
		
		
		countrypieItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChart p=new PieChart(_userBUS.getDataSetforPieChart(4),"������ͳ��");
				Vector Panel=new Vector();
				Panel.add(p.getChartPanel());
				new result_jfree().init(Panel,"������ͳ��-��״ͼ");
				
			}
		});
		JMenuItem countrylineItem = new JMenuItem("����ͼ");
		Countrymenu.add(countrylineItem);
		countrylineItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Line l=new Line(_userBUS.getDataSetforTime(4),"������ͳ��");
				Vector Panel=new Vector();
				Panel.add(l.getChartPanel());
				new result_jfree().init(Panel,"������ͳ��-����ͼ");
				
			}
		});
	}
	
}
