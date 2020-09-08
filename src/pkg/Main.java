package pkg;
import java.sql.*;
public class Main {
	
	public Connection dbConn;
	public static Connection link() throws SQLException{
		 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=汽车租赁管理系统";//这里是写你的数据库名字。上面是新建立了Test，所以填Test
		  String userName="um";//这里是写你的登陆数据库的名，安装完默认是sa
		  String userPwd="123456";//这里是写你的登陆数据库的密码，我设定的比较简单
		  Main a=new Main();
		  a.dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
	        System.out.println("连接数据库成功！");
	        return a.dbConn;
	}

 public static void main(String [] args)
 {
  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=汽车租赁管理系统";//这里是写你的数据库名字。上面是新建立了Test，所以填Test
  String userName="um";//这里是写你的登陆数据库的名，安装完默认是sa
  String userPwd="123456";//这里是写你的登陆数据库的密码，我设定的比较简单
 try
{
    Class.forName(driverName);
    System.out.println("加载驱动成功！");
}catch(Exception e){
    e.printStackTrace();
    System.out.println("加载驱动失败！");
}
try{
	Main a=new Main();
    a.dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
        System.out.println("连接数据库成功！");
        Statement sql1=a.dbConn.createStatement();

}catch(Exception e)
{
    e.printStackTrace();
    System.out.print("SQL Server连接失败！");
}       

 
 
 
 
 }
}