package data_northwind;
//客户信息类
public class Customers {
	public Customers()
	{
		
	}
	public void set(Customers o)
	{
		this.CustomerID=o.CustomerID;
		this.CompanyName=o.CompanyName;
		this.ContactName=o.ContactName;
		this.ContactTitle=o.ContactTitle;
		this.Address=o.Address;
		this.City=o.City;
		this.Region=o.Region;
		this.PostalCode=o.PostalCode;
		this.Country=o.Country;
		this.Phone=o.Phone;
		this.Fax=o.Fax;
	}
	public String CustomerID;//客户ID
	public String CompanyName;//所在公司名称
	public String ContactName;//客户姓名
	public String ContactTitle;//客户头衔
	public String Address;//联系地址
	public String City;//所在城市
	public String Region;//所在地区
	public String PostalCode;//邮编
	public String Country;//国家
	public String Phone;//电话
	public String Fax;//传真
}
