package data_northwind;
//�ͻ���Ϣ��
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
	public String CustomerID;//�ͻ�ID
	public String CompanyName;//���ڹ�˾����
	public String ContactName;//�ͻ�����
	public String ContactTitle;//�ͻ�ͷ��
	public String Address;//��ϵ��ַ
	public String City;//���ڳ���
	public String Region;//���ڵ���
	public String PostalCode;//�ʱ�
	public String Country;//����
	public String Phone;//�绰
	public String Fax;//����
}
