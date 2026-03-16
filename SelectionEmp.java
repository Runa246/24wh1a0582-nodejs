import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectionEmp {
	public static void main(String[] args) {
		try {
			//step1: register the driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//step2: Connect the server by supplying URL(ip,port,uname)
                    //step3: Create statement object to send queries to specified db
                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db582","root","1234") //"url","db username","db password"
                    ) {
                        //step3: Create statement object to send queries to specified db
                        Statement statement = connection.createStatement();
                        //step4: Execute query
                        ResultSet rs = statement.executeQuery("select * from employee");
                        while (rs.next()) {
                            System.out.println(rs.getString("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("deptid"));
                        }
                        //step5: Close the connection
                    }
			}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
