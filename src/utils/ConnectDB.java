package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySinhVien";
	private String tenDangNhap="sa";
	private String matKhau="1234";
	private Connection connection;
	public ConnectDB(){
		connect();
	}
	private void connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url,tenDangNhap,matKhau);
			System.out.println("kết nối thành công");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
