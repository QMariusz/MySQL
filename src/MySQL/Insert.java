package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {

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
			String sql = "Insert into ksiazki values('2', 'dan','brown','sa','1','2','1','2','1','2')";
			
			myStat.executeUpdate(sql);
			
			System.out.println("Insert complete.");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
