package com.Crudoperation.empapp;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnection {
	
	static Connection con;
	
	public static Connection createDBConnection() {
		try {
			//load the Driver class
			System.out.println("DBConnection::CreateDBConnection");
			Class.forName("com.mysql.jdbc.Driver");
			//get connection
			
			String url="jdbc:mysql://localhost:3306/employeedb?useSSl=false";
			String username="root";
			String password="root";
			
			con= (Connection) DriverManager.getConnection(url,username,password);
			System.out.println(con);
		}
		catch(Exception ex){
			System.out.println(ex);

			ex.printStackTrace();
		}
		return con;
	
	}
	}



