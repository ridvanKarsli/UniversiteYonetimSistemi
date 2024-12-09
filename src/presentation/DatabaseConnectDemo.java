package presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectDemo {
	
	private static final String CONNECTION_STRING = 
			"jdbc:postgresql://localhost:5432/Normalization_db?user=postgres&password=3519";
	
	private static final String SELECT_ALL_UNIVERSITE = 
			"select * from universite";

	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(SELECT_ALL_UNIVERSITE);
			
			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print(rs.getString(2));
			}
			
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
