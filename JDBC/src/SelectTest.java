import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/*
 * XE =
  (DESCRIPTION =
    (ADDRESS = (PROTOCOL = TCP)(HOST = Ijaj)(PORT = 1521))
    (CONNECT_DATA =
      (SERVER = DEDICATED)
      (SERVICE_NAME = XE)
    )
  )
  
  
  D:\OracleXE184_Win64\dbhomeXE\jdbc\lib
 */
public class SelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver Registered...");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "Newuser123");
			System.out.println("Connected to Database "+conn);
			Statement statement=conn.createStatement();
			System.out.println("Statement created: "+statement);
			Scanner sc=new Scanner(System.in);
			//System.out.println("Enter job to search ");

			//String v_job=sc.nextLine();
		    Scanner scan2 = new Scanner(System.in);
		            System.out.println("Enter starting date : ");
		            String fromDate = scan2.nextLine();
		           
		            Scanner scan3 = new Scanner(System.in);
		            System.out.println("Enter ending date   : ");
		            String toDate = scan3.nextLine();
		           
		            //ResultSet dateRs = statement.executeQuery("select * from emp where hiredate between '01-Jan-81' and '31-Dec-81'");
		            ResultSet dateRs = statement.executeQuery("select * from emp where hiredate between "+"'"+fromDate+"'"+" and "+"'"+toDate+"'");
		           

			
			//ResultSet rs = statement.executeQuery("select * from emp where job="+"'"+v_job+"'");
			while(dateRs.next())
			{
				System.out.println("Emp number : "+dateRs.getInt(1));
				System.out.println("Emp Name : "+dateRs.getString(2));
				System.out.println("Emp Job : "+dateRs.getString(3));
				System.out.println("Emp Manager : "+dateRs.getString(4));
				System.out.println("Emp Hire Date : "+dateRs.getString(5));
				System.out.println("Emp Salary : "+dateRs.getInt(6));
				System.out.println("Emp Commision: "+dateRs.getString(7));
				System.out.println("Dept ID: "+dateRs.getInt(8));
				System.out.println("-----------------------");
			}
			sc.close();
			dateRs.close();
			conn.close();
			System.out.println("DB resourses are closed.....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
