package data_northwind;

import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//数据表（查询结果）
public class result_table {
	private JFrame jFrame;
	private JPanel jPanel;
	private JTable jTable;
	private JScrollPane jScrollPane;
	public void init(Vector rs,int type) {
		jFrame = new JFrame("");
		jPanel = new JPanel(new BorderLayout());
		Vector content = new Vector();
		Vector column = new Vector();
		
		int i=0;
		int size=rs.size();
		if(type==1)
		{
			jFrame.setTitle("订单信息记录");
			i=0;
			while(i<size)
			{
				Orders uservo=new Orders();
				uservo.set(((Orders)rs.get(i)));
				Vector row = new Vector();
				row.add(i+1);
				row.add(uservo.OrderID);
				row.add(uservo.CustomerID);
				row.add(uservo.EmployeeID);
				row.add(uservo.OrderDate);
				row.add(uservo.RequiredDate);
				row.add(uservo.ShippedDate);
				row.add(uservo.ShipVia);
				row.add(uservo.Freight);
				row.add(uservo.ShipName);
				row.add(uservo.ShipAddress);
				row.add(uservo.ShipCity);
				row.add(uservo.ShipRegion);
				row.add(uservo.ShipPostalCode);
				row.add(uservo.ShipCountry);
				content.add(row);
				i++;
			}
			
			column.add("序号");
			column.add("订单编号");
			column.add("客户");
			column.add("员工编号");
			column.add("订购日期");
			column.add("预计到达日期");
			column.add("发货日期");
			column.add("运货商编号");
			column.add("运费");
			column.add("货主姓名");
			column.add("货主地址");
			column.add("货主所在城市");
			column.add("货主所在地区");
			column.add("货主邮编");
			column.add("货主所在国家");
		}
		else if(type==2)
		{
			jFrame.setTitle("客户信息记录");
			i=0;
			while(i<size)
			{
				Customers uservo=new Customers();
				uservo.set(((Customers)rs.get(i)));
				Vector row = new Vector();
				row.add(i+1);
				row.add(uservo.CustomerID);
				row.add(uservo.CompanyName);
				row.add(uservo.ContactName);
				row.add(uservo.ContactTitle);
				row.add(uservo.Address);
				row.add(uservo.City);
				row.add(uservo.Region);
				row.add(uservo.PostalCode);
				row.add(uservo.Country);
				row.add(uservo.Phone);
				row.add(uservo.Fax);
				content.add(row);
				i++;
			}
			
			column.add("序号");
			column.add("客户ID");
			column.add("所在公司名称");
			column.add("客户姓名");
			column.add("客户头衔");
			column.add("联系地址");
			column.add("所在城市");
			column.add("所在地区");
			column.add("邮编");
			column.add("国家");
			column.add("电话");
			column.add("传真");
		}
		else if(type==3)
		{
			jFrame.setTitle("员工信息记录");
			i=0;
			while(i<size)
			{
				Employees uservo=new Employees();
				uservo.set(((Employees)rs.get(i)));
				Vector row = new Vector();
				row.add(i+1);
				row.add(uservo.EmployeeID);
				row.add(uservo.LastName );
				row.add(uservo.FirstName);
				row.add(uservo.BirthDate);
				row.add(uservo.HireDate);
				row.add(uservo.Address);
				row.add(uservo.City);
				row.add(uservo.Region);
				row.add(uservo.Country);
				row.add(uservo.HomePhone);
				row.add(uservo.ReportsTo);
				content.add(row);
				i++;
			}
			
			column.add("序号");
			column.add("员工编号");
			column.add("LastName");
			column.add("FirstName");
			column.add("出生日期");
			column.add("雇用日期");
			column.add("家庭地址");
			column.add("所在城市");
			column.add("所在地区");
			column.add("国家");
			column.add("电话");
			column.add("上级");
			
		}
		jTable = new JTable(content,column);
		jScrollPane = new JScrollPane(jTable);
		jPanel.add(jScrollPane,BorderLayout.CENTER);
		jFrame.setVisible(true);
		jFrame.setSize(1000,850);
		jFrame.setContentPane(jPanel);
		jFrame.setLocationRelativeTo(null);
		jFrame.setAlwaysOnTop(true);
	}
}
