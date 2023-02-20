package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.PreparableStatement;

import entyti.Account;

public class LoginDao {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String User = "root";
			String Pass = "";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerSystem", User, Pass);
		}catch(Exception e) {
			System.out.print(e);
		}
		return con;
	}
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Account CheckLogin(String user, String pass) {
		try {
			String query = "SELECT count(*) as CNT FROM MSTUSER WHERE USERID = ? AND PASSWORD = ?";
			conn = new LoginDao().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			Account a = new Account(rs.getString(1),rs.getString(2));
			return a;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	
	
	
}

