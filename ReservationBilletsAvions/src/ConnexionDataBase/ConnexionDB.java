package ConnexionDataBase;

import java.sql.*;
public class ConnexionDB 
{
	private static Connection conn ;
	private static String url = "jdbc:mysql://localhost:3306/reservationbilletsavions";
	private static String username = "root";
	private static String password = "";
	
	public Connection airportConnexion() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, username, password);
		System.out.println("Connecter avec succes\n");
		return conn;
	}
	

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		ConnexionDB.conn = conn;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		ConnexionDB.url = url;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		ConnexionDB.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		ConnexionDB.password = password;
	}
	
}
