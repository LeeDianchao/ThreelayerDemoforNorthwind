package data_northwind;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;


//Business Logic Layer
//ҵ���߼��㣨WorkLogic Lead��BUS���Ǳ�ʾ���DAO֮���������
//�ӱ��ֲ���յ������û�ֵ�������ݸ�BUS��
//��DAO���յĽ���������ݱ��ʽ�������ݣ�ת��Ϊֵ����VO����
public class BUS {
	private DAO _userDAO;

    /// <constructor>
    /// Constructor BUS
    /// </constructor>
    public BUS()
    {
        _userDAO  = new DAO();
        
    }

    /// <method>
    /// Get User By Firstname or Lastname and return VO
    /// </method>
    public Vector getByName(String name,int type)
    {
    	Vector result=new Vector();
        
        ResultSet dataTable = null;
        
        if(type==1)
        {
        	dataTable = _userDAO.searchByName(name,type);
            try
    		{
            	while (dataTable.next()) 
        		{
            		Orders userVO = new Orders();
                	userVO.OrderID=(dataTable.getString("OrderID"));
                	userVO.CustomerID=(dataTable.getString("CustomerID"));
                	userVO.EmployeeID=(dataTable.getString("EmployeeID"));
                	userVO.OrderDate=(dataTable.getString("OrderDate"));
                	userVO.RequiredDate=(dataTable.getString("RequiredDate"));
                	userVO.ShippedDate=(dataTable.getString("ShippedDate"));
                	userVO.ShipVia=(dataTable.getString("ShipVia"));
                	userVO.Freight=(dataTable.getString("Freight"));
                	userVO.ShipName=(dataTable.getString("ShipName"));
                	userVO.ShipAddress=(dataTable.getString("ShipAddress"));
                	userVO.ShipCity=(dataTable.getString("ShipCity"));
                	userVO.ShipRegion=(dataTable.getString("ShipRegion"));
                	userVO.ShipPostalCode=(dataTable.getString("ShipPostalCode"));
                	userVO.ShipCountry=(dataTable.getString("ShipCountry"));
                	result.add(userVO);
        		}
    		}
            catch(Exception e)
    		{
    			e.printStackTrace();
    			JOptionPane.showMessageDialog(null, "getByName(type=1)����:"+e.getStackTrace().toString(), "UserBUS��Ϣ", JOptionPane.ERROR_MESSAGE);
    			System.out.print("UserBUS����-getByName(type=1):"+e.getStackTrace().toString());
    		}
        }
        else if(type==2)
        {
        	dataTable = _userDAO.searchByName(name,type);
            try
    		{
            	while (dataTable.next()) 
        		{
            		Customers userVO = new Customers();            
                	userVO.CustomerID=(dataTable.getString("CustomerID"));
                	userVO.CompanyName=(dataTable.getString("CompanyName"));
                	userVO.ContactName=(dataTable.getString("ContactName"));
                	userVO.ContactTitle=(dataTable.getString("ContactTitle"));
                	userVO.Address=(dataTable.getString("Address"));
                	userVO.City=(dataTable.getString("City"));
                	userVO.Region=(dataTable.getString("Region"));
                	userVO.PostalCode=(dataTable.getString("PostalCode"));
                	userVO.Country=(dataTable.getString("Country"));
                	userVO.Phone=(dataTable.getString("Phone"));
                	userVO.Fax=(dataTable.getString("Fax"));
                	result.add(userVO);
        		}
    		}
            catch(Exception e)
    		{
    			e.printStackTrace();
    			JOptionPane.showMessageDialog(null, "getByName(type=2)����:"+e.getStackTrace().toString(), "UserBUS��Ϣ", JOptionPane.ERROR_MESSAGE);
    			System.out.print("UserBUS����-getByName(type=2):"+e.getStackTrace().toString());
    		}
        }
        else if(type==3)
        {
        	dataTable = _userDAO.searchByName(name,type);
            try
    		{
            	while (dataTable.next()) 
        		{
            		Employees userVO = new Employees();             
                	userVO.EmployeeID=(dataTable.getString("EmployeeID"));
                	userVO.LastName =(dataTable.getString("LastName"));
                	userVO.FirstName=(dataTable.getString("FirstName"));
                	userVO.BirthDate=(dataTable.getString("BirthDate"));
                	userVO.HireDate=(dataTable.getString("HireDate"));
                	userVO.Address=(dataTable.getString("Address"));
                	userVO.City=(dataTable.getString("City"));
                	userVO.Region=(dataTable.getString("Region"));
                	userVO.Country=(dataTable.getString("Country"));
                	userVO.HomePhone=(dataTable.getString("HomePhone"));
                	userVO.ReportsTo=(dataTable.getString("ReportsTo"));
                    result.add(userVO);
        		}
    		}
            catch(Exception e)
    		{
    			e.printStackTrace();
    			JOptionPane.showMessageDialog(null, "getByName(type=3)����:"+e.getStackTrace().toString(), "UserBUS��Ϣ", JOptionPane.ERROR_MESSAGE);
    			System.out.print("UserBUS����-getByName(type=3):"+e.getStackTrace().toString());
    		}
        }
        return result;
    }

    /// <method>
    /// Get User By Id and return DataTable
    /// </method>
    public Vector getById(String _id,int type)
    {
        Vector result=new Vector();
        
        ResultSet dataTable = null;

        if(type==1)
        {
        	dataTable = _userDAO.searchById(_id,type);
            
            try
    		{
            	while (dataTable.next()) 
        		{
            		Orders userVO = new Orders();
                	userVO.OrderID=(dataTable.getString("OrderID"));
                	userVO.CustomerID=(dataTable.getString("CustomerID"));
                	userVO.EmployeeID=(dataTable.getString("EmployeeID"));
                	userVO.OrderDate=(dataTable.getString("OrderDate"));
                	userVO.RequiredDate=(dataTable.getString("RequiredDate"));
                	userVO.ShippedDate=(dataTable.getString("ShippedDate"));
                	userVO.ShipVia=(dataTable.getString("ShipVia"));
                	userVO.Freight=(dataTable.getString("Freight"));
                	userVO.ShipName=(dataTable.getString("ShipName"));
                	userVO.ShipAddress=(dataTable.getString("ShipAddress"));
                	userVO.ShipCity=(dataTable.getString("ShipCity"));
                	userVO.ShipRegion=(dataTable.getString("ShipRegion"));
                	userVO.ShipPostalCode=(dataTable.getString("ShipPostalCode"));
                	userVO.ShipCountry=(dataTable.getString("ShipCountry"));
                	result.add(userVO);
        		}
    		}
            catch(Exception e)
    		{
    			e.printStackTrace();
    			JOptionPane.showMessageDialog(null, "getById(type=1)����:"+e.getStackTrace().toString(), "UserBUS��Ϣ", JOptionPane.ERROR_MESSAGE);
    			System.out.print("UserBUS����-getById(type=1):"+e.getStackTrace().toString());
    		}
        }
        else if(type==2)
        {
        	dataTable =  _userDAO.searchById(_id,type);
            try
    		{
            	while (dataTable.next()) 
        		{
            		Customers userVO = new Customers();            
                	userVO.CustomerID=(dataTable.getString("CustomerID"));
                	userVO.CompanyName=(dataTable.getString("CompanyName"));
                	userVO.ContactName=(dataTable.getString("ContactName"));
                	userVO.ContactTitle=(dataTable.getString("ContactTitle"));
                	userVO.Address=(dataTable.getString("Address"));
                	userVO.City=(dataTable.getString("City"));
                	userVO.Region=(dataTable.getString("Region"));
                	userVO.PostalCode=(dataTable.getString("PostalCode"));
                	userVO.Country=(dataTable.getString("Country"));
                	userVO.Phone=(dataTable.getString("Phone"));
                	userVO.Fax=(dataTable.getString("Fax"));
                	result.add(userVO);
        		}
    		}
            catch(Exception e)
    		{
    			e.printStackTrace();
    			JOptionPane.showMessageDialog(null, "getById(type=2)����:"+e.getStackTrace().toString(), "UserBUS��Ϣ", JOptionPane.ERROR_MESSAGE);
    			System.out.print("UserBUS����-getById(type=2):"+e.getStackTrace().toString());
    		}
        }
        else if(type==3)
        {
        	dataTable = _userDAO.searchById(_id,type);
            try
    		{
            	while (dataTable.next()) 
        		{
            		Employees userVO = new Employees();             
                	userVO.EmployeeID=(dataTable.getString("EmployeeID"));
                	userVO.LastName =(dataTable.getString("LastName"));
                	userVO.FirstName=(dataTable.getString("FirstName"));
                	userVO.BirthDate=(dataTable.getString("BirthDate"));
                	userVO.HireDate=(dataTable.getString("HireDate"));
                	userVO.Address=(dataTable.getString("Address"));
                	userVO.City=(dataTable.getString("City"));
                	userVO.Region=(dataTable.getString("Region"));
                	userVO.Country=(dataTable.getString("Country"));
                	userVO.HomePhone=(dataTable.getString("HomePhone"));
                	userVO.ReportsTo=(dataTable.getString("ReportsTo"));
                    result.add(userVO);
        		}
    		}
            catch(Exception e)
    		{
    			e.printStackTrace();
    			JOptionPane.showMessageDialog(null, "getById(type=3)����:"+e.getStackTrace().toString(), "UserBUS��Ϣ", JOptionPane.ERROR_MESSAGE);
    			System.out.print("UserBUS����-getById(type=3):"+e.getStackTrace().toString());
    		}
        }
        return result;
    }
    
    
    public Vector getDataSetforBarChart(int type)//��״ͼ
    {
    	ResultSet dataTable = null;
    	dataTable = _userDAO.searchForstatis(type);
    	Vector dataset = new Vector();  
        
        try
		{
        	while (dataTable.next()) 
    		{
        		forstatis statis=new forstatis();
        		statis.name=dataTable.getString("name");
        		statis.num=dataTable.getDouble("num");
        		dataset.add(statis);  
    		}
		}
        catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "getDataSetforBarChart����:"+e.getStackTrace().toString(), "UserBUS��Ϣ", JOptionPane.ERROR_MESSAGE);
			System.out.print("UserBUS����-getDataSetforBarChart:"+e.getStackTrace().toString());
		}
        return dataset;
    }
    
    public Vector getDataSetforPieChart(int type) //��״ͼ
    {
    	
    	ResultSet dataTable = null;
    	dataTable = _userDAO.searchForstatis(type);
    	Vector dataset = new Vector();

        try
		{
        	while (dataTable.next()) 
    		{
        		forstatis statis=new forstatis();
        		statis.name=dataTable.getString("name");
        		statis.num=dataTable.getDouble("num");
        		dataset.add(statis);
    		}
		}
        catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "getDataSetforPieChart����:"+e.getStackTrace().toString(), "UserBUS��Ϣ", JOptionPane.ERROR_MESSAGE);
			System.out.print("UserBUS����-getDataSetforPieChart:"+e.getStackTrace().toString());
		}
        return dataset;
    }
    
    
    public Vector getDataSetforTime(int type)//����ͼ
    {
    	
        ResultSet dataTable = null;
    	dataTable = _userDAO.searchForstatis(type);
    	Vector dataset = new Vector();
        try
		{
        	while (dataTable.next()) 
    		{
        		forstatis statis=new forstatis();
        		statis.name=dataTable.getString("name");
        		statis.num=dataTable.getDouble("num");
        		dataset.add(statis);
    		}
		}
        catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "getDataSetforTime����:"+e.getStackTrace().toString(), "UserBUS��Ϣ", JOptionPane.ERROR_MESSAGE);
			System.out.print("UserBUS����-getDataSetforTime:"+e.getStackTrace().toString());
		}
        
        return dataset;
    }
    
    public void exit()
    {
    	_userDAO.exit();
    }
}

