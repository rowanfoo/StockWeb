package dao;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



import com.mchange.v2.c3p0.ComboPooledDataSource;
public class Database implements AutoCloseable {
	static Connection con;
	 static DataSource dataSource;
	 
	public static Connection getConnection() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		// if(con==null || con.isClosed() ){

		// con=DriverManager.getConnection(
		// "jdbc:mysql://localhost:3306/fortune?autoReconnect=true&useSSL=false","root","rowm0ng1");

		if (dataSource == null) {

			try {
				Context initcontext = new InitialContext();
				Context environmentContext = (Context) initcontext.lookup("java:comp/env");
				String dataResourceName = "jdbc/fortune2";
				dataSource = (DataSource) environmentContext.lookup(dataResourceName);
				System.out.println("OK with JNDI DTBS");

			} catch (Exception e) {
				System.out.println("JNDI FAILED , USE MANUAL DTBS");
				if (dataSource == null) {
			/*
					BasicDataSource ds = new BasicDataSource();
					ds.setDriverClassName("com.mysql.jdbc.Driver");
					ds.setUsername("root");
					ds.setPassword("rowm0ng1");
					ds.setUrl("jdbc:mysql://localhost/fortune?verifyServerCertificate=false&useSSL=true&autoReconnectForPools=true");
					ds.setMaxActive(15);
					ds.setMaxWait(10000);
					ds.setMaxIdle(15);
					ds.setMinEvictableIdleTimeMillis(1800000);
					
				*/
					System.out.println("TEST NEW DTBS");
					ComboPooledDataSource cpds = new ComboPooledDataSource();
					cpds.setDriverClass( "com.mysql.jdbc.Driver" ); 
					cpds.setJdbcUrl( "jdbc:mysql://localhost/fortune2?verifyServerCertificate=false&useSSL=true" );
					cpds.setUser("root");
					cpds.setPassword("rowm0ng1"); 
					cpds.setMinPoolSize(5); 
					cpds.setAcquireIncrement(5); 
					cpds.setMaxPoolSize(20); 
					cpds.setMaxIdleTime(900);
					
					dataSource = cpds;
				}
			}

		}
		con = dataSource.getConnection();
		
		return con;

	}

	
	public static void destory()throws Exception {
		System.out.println("destory  dtsc:");
		
		ComboPooledDataSource cpds  =(ComboPooledDataSource )dataSource;
		cpds.close();
	}
	public  void close(){
		
		try {
			System.out.println("CLOSE  dtsc:");
			
			
			
			con.close();
			System.out.println("Close Connection OK !!!!!!:");
		} catch (Exception e) {
			System.out.println("EROR closing Connection :"+e);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
