package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmp{
public static void main(String[] args) {
try {
//step1: register the driver
DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//step2: Connect the server by supplying URL(ip,port,uname)

Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db582","root","1234");//"url","db username","db password"
//step3: Create statement object to send queries to specified db
Statement statement = connection.createStatement();
//step4: Execute query
int rows = statement.executeUpdate("UPDATE employee SET deptid='204' WHERE eid='123' ");
System.out.println(rows + " row(s) updated.");
// for select queries use executeQuery();

//for non-select queries(update,delete,insert) use executeUpdate
//ResultSet rs=statement.executeQuery(select * from Emp);
/*while(rs.next()) {
System.out.println(rs.getString("eId")+"\t"+rs.getString("ename")+"\t"+rs.getString("deptID"));
}*/
//step5: Close the connection
connection.close();
}
catch(SQLException e) {
e.printStackTrace();
}
}
}