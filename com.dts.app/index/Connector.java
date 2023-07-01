import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Connector {
	public static void main(String[] args) {
		
		// Step 1: Load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// Step 2: Establish Connection
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample","root","Gokul@#63808");
		} catch (SQLException e) {
            
            e.printStackTrace();
        }
        if(con!=null){
            System.out.println("Connection Successful");
        }
        else{
            System.out.println("Check the Connection");
        }
		Scanner sc = new Scanner(System.in);

		int empid=sc.nextInt();

		String empName=sc.next();

		int empSalary=sc.nextInt();

		String sql="insert into emp value(?,?,?)";

		try {

			PreparedStatement ps=con.prepareStatement(sql);

			ps.setInt(1,empid);

			ps.setString(2, empName);

			ps.setInt(3, empSalary);

			ps.executeUpdate();

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		System.out.println("******value are inserted*******");

		String viewSql ="select * from emp";

		try {

			PreparedStatement view =con.prepareStatement(viewSql);

			ResultSet rs=view.executeQuery();

			while(rs.next()) {

				System.out.println(rs.getInt("empid"));

				System.out.println(rs.getString("empName"));

				System.out.println(rs.getInt("empSalary"));

			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

    }
}

