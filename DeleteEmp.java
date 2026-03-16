package com.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmp {
public static void main(String[] args) throws SQLException {
try {
  //Step1: register the driver
  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
  //Step2: Connect the server by supplying URL(ip,port,uname)
  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db582","root","1234");  //"url","db userName","db password"
  //Step3: Create Statement object to send queries to db
  Statement statement = connection.createStatement();
  //int rows = statement.executeUpdate("UPDATE employee SET deptId='584' WHERE eId='101'");
  //System.out.println(rows + " rows(s) updated:");
  int row =statement.executeUpdate("DELETE from employee where eId='234'");
  System.out.println(row + " rows(s) updated:");
  //Step4: Execute query
  ResultSet rs = statement.executeQuery("select * from employee");
  while(rs.next()) {
 System.out.println(rs.getString("eid")+"\t" +rs.getString("ename")+"\t" +rs.getString("deptid")+"\t");
  }
  //Step5: Close the connection
  connection.close();
   }
   catch(SQLException e) {
  e.printStackTrace();
   }
}
}



