package data_northwind;
//������Ϣ��
public class Orders {
	public Orders()
	{
		
	}
	public void set(Orders o)
	{
		this.OrderID=o.OrderID;
		this.CustomerID=o.CustomerID;
		this.EmployeeID=o.EmployeeID;
		this.OrderDate=o.OrderDate;
		this.RequiredDate=o.RequiredDate;
		this.ShippedDate=o.ShippedDate;
		this.ShipVia=o.ShipVia;
		this.Freight=o.Freight;
		this.ShipName=o.ShipName;
		this.ShipAddress=o.ShipAddress;
		this.ShipCity=o.ShipCity;
		this.ShipRegion=o.ShipRegion;
		this.ShipPostalCode=o.ShipPostalCode;
		this.ShipCountry=o.ShipCountry;
	}
	public String OrderID;//�������
	public String CustomerID;//�ͻ����
	public String EmployeeID;//Ա�����
	public String OrderDate;//��������
	public String RequiredDate;//Ԥ�Ƶ�������
	public String ShippedDate;//��������
	public String ShipVia;//�˻��̱��
	public String Freight;//�˷�
	public String ShipName;//��������
	public String ShipAddress;//������ַ
	public String ShipCity;//�������ڳ���
	public String ShipRegion;//�������ڵ���
	public String ShipPostalCode;//�����ʱ�
	public String ShipCountry;//�������ڹ���
}
