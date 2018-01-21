package MySQL;
import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/ksiegarnia";
		String user ="root";
		String password = "";
		try {
			//1 Get connection
			Connection myCon = DriverManager.getConnection(url, user, password);
			//2 Create astatement
			Statement myStat = myCon.createStatement();
			//3 Execute SQL query
			ResultSet myRs = myStat.executeQuery("select * from ksiazki");
			//4 Process the result set
			while(myRs.next()){
				System.out.println(myRs.getInt("Id") + " " + myRs.getString("Autor") + " " +
						myRs.getString("Tytul") + " " + myRs.getString("Cykl") + " " + myRs.getString("Gatunek") 
						+ " " + myRs.getInt("Liczba_stron")+
						" " + myRs.getInt("Rok_wydania") + " " + myRs.getFloat("Ocena") + " " + 
						myRs.getFloat("Ocena_lubimyczytac.pl") + " " + myRs.getInt("Rok_przeczytania"));
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
