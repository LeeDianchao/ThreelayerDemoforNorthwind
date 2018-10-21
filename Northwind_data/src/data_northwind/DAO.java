package data_northwind;

import java.sql.ResultSet;


//Database Access Layer
//数据库访问层（DAO）基于从业务逻辑层接收的参数构建查询，
//并将其传递给dbConnection类以供执行。
public class DAO {
	private dbConnection conn;
	/// <constructor>
	/// Constructor DAO
	/// </constructor>
	public DAO()
	{
	    conn = new dbConnection();
	}

	/// <method>
	/// Get User By Name and return DataTable
	/// </method>
	public ResultSet searchByName(String _username,int type)
	{
		if(_username.isEmpty()) {
			String query="";
			if(type==1)
			{
				query= "select * from Orders";
			}
			else if(type==2) {
				query= "select * from Customers";
			}
			else if(type==3) {
				query= "select * from Employees";
			}
			return conn.executeSelectQuery(query);
		}
		else
		{
			String [] sqlparameters = _username.split("\\s+");
			//防止SQL注入
			String query="";
			if(type==1)
			{
				query= "select * from Orders where CustomerID=?";
			}
			else if(type==2) {
				String parameters[]=new String[1];
				parameters[0]=_username;
				sqlparameters=parameters;
				query= "select * from Customers where ContactName=?";
			}
			else if(type==3) {
				query= "select * from Employees where LastName=? or FirstName=?";
			}
			return conn.executeSelectQuery(query,sqlparameters);
		}
	}

	/// <method>
	/// Get User By Id and return DataTable
	/// </method>
	public ResultSet searchById(String _id,int type)
	{
		if(_id.isEmpty()) {
			String query="";
			if(type==1)
			{
				query= "select * from Orders";
			}
			else if(type==2) {
				query= "select * from Customers";
			}
			else if(type==3) {
				query= "select * from Employees";
			}
			return conn.executeSelectQuery(query);
		}
		else
		{
			String [] sqlparameters = _id.split("\\s+");
			//防止SQL注入
		    String query = "";
		    if(type==1)
		    {
		    	query= "select * from Orders where OrderID =?";
		    }
		    else if(type==2) {
		    	query= "select * from Customers where CustomerID=?";
		    }
		    else if(type==3) {
		    	query= "select * from Employees where EmployeeID=?";
		    }
		    return conn.executeSelectQuery(query,sqlparameters);
		}
	}

	
	public ResultSet searchForstatis(int type)
	{
		String query="";
		if(type==1) //按客户ID
		{
			query="SELECT CustomerID as name ,count(*) as num FROM Orders group by CustomerID";
		}
		else if(type==2)//按员工ID
		{
			query="SELECT EmployeeID as name ,count(*) as num FROM Orders group by EmployeeID";
		}
		else if(type==3)//按订购日期
		{
			query="SELECT Datename(year,OrderDate)+'-'+Datename(month,OrderDate) as name ,count(*) as num FROM Orders group by Datename(year,OrderDate)+'-'+Datename(month,OrderDate)";
		}
		else if(type==4)//按国家
		{
			query="SELECT ShipCountry as name,count(*) as num FROM Orders group by ShipCountry";
		}
		return conn.executeSelectQuery(query);
	}
	/// <method>
	/// Insert Query
	/// </method>
	public boolean Insert(String [] sqlparameters,int type)
	{
		//防止SQL注入
		String query = "";  
		if(type==1)
	    {
	    	query= "insert into Orders values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    }
	    else if(type==2) {
	    	query= "insert into Customers values(?,?,?,?,?,?,?,?,?,?,?)";
	    }
	    else if(type==3) {
	    	query= "insert into Employees values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    }
	    return conn.executeInsertQuery(query,sqlparameters);
	}

	/// <method>
	/// Update Query
	/// </method>
	public boolean UpdateQuery(String [] sqlparameters,int type)
	{
		String query = "";
		if(type==1)
	    {
	    	query= "";
	    }
	    else if(type==2) {
	    	query= "";
	    }
	    else if(type==3) {
	    	query= "";
	    }
	    return conn.executeUpdateQuery(query,sqlparameters);
	}
	
	public void exit()
	{
		conn.exit();
	}
}