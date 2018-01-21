package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Statements {

	public static void main(String[] args) {
	
		String url = "jdbc:mysql://localhost:3306/ksiegarnia";
		String user ="root";
		String password = "";
		
		Connection myConn = null;
		PreparedStatement myStat = null;
		ResultSet myRs = null;
		
		try {
			//INSERT DELETE UPDATE ALTER Tez mozna
			//1 Get connection
			Connection myCon = DriverManager.getConnection(url, user, password);
			//2 Create a statement
			myStat = myCon.prepareStatement("Select * from ksiazki where Ocena > ? and Id > ?");
			//3 Set the parameters
			myStat.setInt(1, 2);
			myStat.setInt(2, 0);
			 //4 Execute SQL Query
			myRs = myStat.executeQuery();
			
			//5 Display the result
			display(myRs);
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			int Id = myRs.getInt("Id");
			String Autor = myRs.getString("Autor");
			String Tytul = myRs.getString("Tytul");
			String Cykl = myRs.getString("Cykl");
			String Gatunek = myRs.getString("Gatunek");
			int liczbaStron = myRs.getInt("Liczba_stron");
			int rokWydania = myRs.getInt("Rok_wydania");
			float ocena = myRs.getFloat("Ocena");
			float ocenaLubimyCzytac = myRs.getFloat("Ocena_lubimyczytac.pl");
			int rokPrzeczytania = myRs.getInt("Rok_przeczytania");
			
			System.out.printf("%d, %s, %s, %s, %s, %d, %d, %.2f, %.2f, %d\n", Id, Autor, Tytul, Cykl, Gatunek,
					liczbaStron, rokWydania, ocena, ocenaLubimyCzytac, rokPrzeczytania);
		}
		

	}

}
