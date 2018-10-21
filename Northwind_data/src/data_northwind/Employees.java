package data_northwind;
//员工信息类
public class Employees {
	public Employees()
	{
		
	}
	public void set(Employees o)
	{
		this.EmployeeID=o.EmployeeID;
		this.LastName=o.LastName;
		this.FirstName=o.FirstName;
		this.BirthDate=o.BirthDate;
		this.HireDate=o.HireDate;
		this.Address=o.Address;
		this.City=o.City;
		this.Region=o.Region;
		this.Country=o.Country;
		this.HomePhone=o.HomePhone;
		this.ReportsTo=o.ReportsTo;
	}
	public String EmployeeID;//员工代号
	public String LastName;
	public String FirstName;//员工姓名
	public String BirthDate;//出生日期
	public String HireDate;//雇用日期
	public String Address;//家庭地址
	public String City;//所在城市
	public String Region;//所在地区
	public String Country;//国家
	public String HomePhone;//宅电
	public String ReportsTo;//上级
}
