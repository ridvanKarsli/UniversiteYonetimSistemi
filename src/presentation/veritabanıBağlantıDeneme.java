package presentation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class veritabanıBağlantıDeneme {
	
	private static final String CONNECTION_STRING = 
			"jdbc:postgresql://localhost:5432/Normalization_db?user=postgres&password=3519";
	
	private static final String SELECT_ALL_FROM_UNIVERSITE =
			"SELECT * FROM universite";
	
	private static final String INSERT_INTO_OGRENCILER =
			"INSERT INTO public.ogrenciler_3nf(ad, soyad) VALUES ('Yener', 'çevik');";
	
	private static final String INSERT_INTO_OGRENCILER_PARAMETRIK =
			"INSERT INTO public.ogrenciler_3nf(ad, soyad) VALUES (?, ?);"; //? sqlde parametredir
	
	private static final String UPDATE_OGRENCILER_PARAMETRIK = 
			"UPDATE public.ogrenciler_3nf SET ad=?, soyad=? WHERE id=?;";

	public static void main(String[] args) {
		
		veritabanıBağlantıDeneme vbd = new veritabanıBağlantıDeneme();
		
		vbd.selectAll();
		//vbd.insertStudent("veli", "cevher");
		vbd.updateStudentById(4,"veli","cik");

	}
	
	private  void selectAll() {
		
		try {
			Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			//parametresiz ise statement kullan. parametre alıyorsa prepareStatement kullan
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(SELECT_ALL_FROM_UNIVERSITE);
			
			while(rs.next()) {
				
				System.out.print(rs.getInt(1) + " ");//veritabanında index 1 den başlar
				System.out.print(rs.getString(2));
			}
			rs.close();
			statement.close();
			conn.close(); //connectionu kapatmayı unutma 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void insertStudent(String ad , String soyad ) {
		
		try {
			Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			//sql injection korumalı yöntem
			PreparedStatement insertStatement = conn.prepareStatement(INSERT_INTO_OGRENCILER_PARAMETRIK);
			insertStatement.setString(1, ad);
			insertStatement.setString(2, soyad);
			insertStatement.executeUpdate();
			
			
			/*
			//sql injection atağına açık kod
			Statement statement = conn.createStatement();
			

			String insert = "INSERT INTO public.ogrenciler_3nf(ad, soyad) VALUES ('"+ad+"', '"+soyad+"');";
			//statement.executeUpdate(INSERT_INTO_OGRENCILER);
			statement.executeUpdate(insert);
			statement.close();
			*/
			
			
			insertStatement.close();
			conn.close(); //connectionu kapatmayı unutma 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void updateStudentById(Integer id, String ad, String soyad) {

		try {
			Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			//sql injection korumalı yöntem
			PreparedStatement insertStatement = conn.prepareStatement(UPDATE_OGRENCILER_PARAMETRIK);
			insertStatement.setString(1, ad);
			insertStatement.setString(2, soyad);
			insertStatement.setInt(3, id);
			insertStatement.executeUpdate();
			
			insertStatement.close();
			conn.close(); //connectionu kapatmayı unutma 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
