package data_northwind;
//Ա����Ϣ��
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
	public String EmployeeID;//Ա������
	public String LastName;
	public String FirstName;//Ա������
	public String BirthDate;//��������
	public String HireDate;//��������
	public String Address;//��ͥ��ַ
	public String City;//���ڳ���
	public String Region;//���ڵ���
	public String Country;//����
	public String HomePhone;//լ��
	public String ReportsTo;//�ϼ�
}
