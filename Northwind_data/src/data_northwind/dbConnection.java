package data_northwind;

import java.sql.*;
import javax.swing.JOptionPane;

//dbConnection
//������Ҫ���ڶ����ݿ����ѡ�񡢸��º�ɾ����ѯ�����ݿ���
//����������ݿ������Ƿ�򿪡�
//������ݿ�����δ�򿪣�������Ӳ�ִ�����ݿ��ѯ��
//���ݿ������ڸ����б����ղ����ݵ����ݱ��С�
public class dbConnection {

    private ResultSet rs=null;
    private Connection conn=null;
    String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL="jdbc:sqlserver://39.108.164.195:1433;DatabaseName=Northwind";
	String userName="sa";
	String userPwd="Ldc123456";
	
    /// <constructor>
    /// Initialise Connection
    /// </constructor>
    public dbConnection()
    {
    	try
		{
    		Class.forName(driverName);
    		conn=DriverManager.getConnection(dbURL,userName,userPwd);
    		System.out.println("���ӷ������ɹ�");
    		rs=null;
		}
    	catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "����ʧ��:"+e.getStackTrace().toString(), "dbConnection��Ϣ", JOptionPane.ERROR_MESSAGE);
			System.out.print("dbConnection����ʧ��:"+e.getStackTrace().toString());
		}
    }

    /// <method>
    /// Open Database Connection if Closed or Broken
    /// </method>
    private Connection openConnection()
    {
    	try
		{
    		if (conn.isClosed())
    		{
    			Class.forName(driverName);
        		conn=DriverManager.getConnection(dbURL,userName,userPwd);
        		System.out.println("�������ݿ�ɹ�");
        		rs=null;
    		}
		}
    	catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "����ʧ��:"+e.getStackTrace().toString(), "dbConnection��Ϣ", JOptionPane.ERROR_MESSAGE);
			System.out.print("dbConnection����ʧ��:"+e.getStackTrace().toString());
		}
        return conn;
    }
    
    
    /// <method>
    /// Select Query
    /// </method>
    public ResultSet executeSelectQuery(String _query,String [] sqlparameters)
    {
        try
        {
        	//����Ԥ������伯�������˴���SQLע�������
        	PreparedStatement preState = conn.prepareStatement(_query,Statement.RETURN_GENERATED_KEYS);
        	int i=1;
        	for (String element: sqlparameters) {
        		preState.setString(i, element);
        		i++;
             }
        	
            rs = preState.executeQuery();
        	
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	JOptionPane.showMessageDialog(null, "��ѯʧ��:"+e.getStackTrace().toString(), "dbConnection��Ϣ", JOptionPane.ERROR_MESSAGE);
			System.out.print("dbConnection��ѯʧ��:"+e.getStackTrace().toString());
            return null;
        }
        return rs;
    }
    
    public ResultSet executeSelectQuery(String _query)
    {
    	ResultSet rs=null;
    	try
        {
        	Statement statement=conn.createStatement();
        	rs=statement.executeQuery(_query);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	JOptionPane.showMessageDialog(null, "����ʧ��:"+e.getStackTrace().toString(), "dbConnection��Ϣ", JOptionPane.ERROR_MESSAGE);
			System.out.print("dbConnection����ʧ��:"+e.getStackTrace().toString());
        }
        return rs;
    }
    
    /// <method>
    /// Insert Query
    /// </method>
    public boolean executeInsertQuery(String _query,String [] sqlparameters)
    {
    	try
        {
    		//����Ԥ������伯�������˴���SQLע�������
    		PreparedStatement preState = conn.prepareStatement(_query,Statement.RETURN_GENERATED_KEYS);  
    		int i=1;
        	for (String element: sqlparameters) {
        		preState.setString(i, element);
        		i++;
             }
        	preState.executeUpdate();  
    		
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	JOptionPane.showMessageDialog(null, "����ʧ��:"+e.getStackTrace().toString(), "dbConnection��Ϣ", JOptionPane.ERROR_MESSAGE);
			System.out.print("dbConnection����ʧ��:"+e.getStackTrace().toString());
            return false;
        }
        return true;
    }

    /// <method>
    /// Update Query
    /// </method>
    public boolean executeUpdateQuery(String _query,String [] sqlparameters)
    {
    	try
        {
        	Statement statement=conn.createStatement();
        	statement.executeUpdate(_query);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	JOptionPane.showMessageDialog(null, "����ʧ��:"+e.getStackTrace().toString(), "dbConnection��Ϣ", JOptionPane.ERROR_MESSAGE);
			System.out.print("dbConnection����ʧ��:"+e.getStackTrace().toString());
            return false;
        }
        return true;
    }
    
    public void exit()
    {
    	try
    	{
    		conn.close();
    	}
    	catch(Exception e)
		{
    		e.printStackTrace();
		}
    }
}
