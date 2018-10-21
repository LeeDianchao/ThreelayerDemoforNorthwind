package data_northwind;

import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//���ݱ���ѯ�����
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
			jFrame.setTitle("������Ϣ��¼");
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
			
			column.add("���");
			column.add("�������");
			column.add("�ͻ�");
			column.add("Ա�����");
			column.add("��������");
			column.add("Ԥ�Ƶ�������");
			column.add("��������");
			column.add("�˻��̱��");
			column.add("�˷�");
			column.add("��������");
			column.add("������ַ");
			column.add("�������ڳ���");
			column.add("�������ڵ���");
			column.add("�����ʱ�");
			column.add("�������ڹ���");
		}
		else if(type==2)
		{
			jFrame.setTitle("�ͻ���Ϣ��¼");
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
			
			column.add("���");
			column.add("�ͻ�ID");
			column.add("���ڹ�˾����");
			column.add("�ͻ�����");
			column.add("�ͻ�ͷ��");
			column.add("��ϵ��ַ");
			column.add("���ڳ���");
			column.add("���ڵ���");
			column.add("�ʱ�");
			column.add("����");
			column.add("�绰");
			column.add("����");
		}
		else if(type==3)
		{
			jFrame.setTitle("Ա����Ϣ��¼");
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
			
			column.add("���");
			column.add("Ա�����");
			column.add("LastName");
			column.add("FirstName");
			column.add("��������");
			column.add("��������");
			column.add("��ͥ��ַ");
			column.add("���ڳ���");
			column.add("���ڵ���");
			column.add("����");
			column.add("�绰");
			column.add("�ϼ�");
			
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
