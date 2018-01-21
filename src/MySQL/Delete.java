package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/ksiegarnia";
		String user ="root";
		String password = "";
		try {
			//1 Get connection
			Connection myCon = DriverManager.getConnection(url, user, password);
			//2 Create astatement
			Statement myStat = myCon.createStatement();
			//3 Execute SQL query
			String sql = "Delete from ksiazki where Id=2";
			
			int rowsAffected = myStat.executeUpdate(sql);
						
			System.out.println("Rows affected " + rowsAffected);
			System.out.println("Delete complete.");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
