package data_northwind;
//订单信息类
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
	public String OrderID;//订单编号
	public String CustomerID;//客户编号
	public String EmployeeID;//员工编号
	public String OrderDate;//订购日期
	public String RequiredDate;//预计到达日期
	public String ShippedDate;//发货日期
	public String ShipVia;//运货商编号
	public String Freight;//运费
	public String ShipName;//货主姓名
	public String ShipAddress;//货主地址
	public String ShipCity;//货主所在城市
	public String ShipRegion;//货主所在地区
	public String ShipPostalCode;//货主邮编
	public String ShipCountry;//货主所在国家
}
