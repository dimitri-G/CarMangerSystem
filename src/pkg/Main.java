package pkg;
import java.sql.*;
public class Main {
	
	public Connection dbConn;
	public static Connection link() throws SQLException{
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=�������޹���ϵͳ";//������д������ݿ����֡��������½�����Test��������Test
		  String userName="um";//������д��ĵ�½���ݿ��������װ��Ĭ����sa
		  String userPwd="123456";//������д��ĵ�½���ݿ�����룬���趨�ıȽϼ�
		  Main a=new Main();
		  a.dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
	        System.out.println("�������ݿ�ɹ���");
	        return a.dbConn;
	}

 public static void main(String [] args)
 {
  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=�������޹���ϵͳ";//������д������ݿ����֡��������½�����Test��������Test
  String userName="um";//������д��ĵ�½���ݿ��������װ��Ĭ����sa
  String userPwd="123456";//������д��ĵ�½���ݿ�����룬���趨�ıȽϼ�
 try
{
    Class.forName(driverName);
    System.out.println("���������ɹ���");
}catch(Exception e){
    e.printStackTrace();
    System.out.println("��������ʧ�ܣ�");
}
try{
	Main a=new Main();
    a.dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
        System.out.println("�������ݿ�ɹ���");
        Statement sql1=a.dbConn.createStatement();

}catch(Exception e)
{
    e.printStackTrace();
    System.out.print("SQL Server����ʧ�ܣ�");
}       

 
 
 
 
 }
}