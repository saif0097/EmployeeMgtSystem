package com.Crudoperation.empapp;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class EmployeeDaoImpl implements EmployeeDaoIntrf{

	Connection con;

	@Override
	public void createEmployee(Employee emp) {
		System.out.println("EmployeeDaolmpl::createEmployee");
		 con = DBConnection.createDBConnection();

		// TODO Auto-generated method stub
		 String query=" insert into employee  values(?,?,?,?)";
		 try {
			PreparedStatement pstm= (PreparedStatement) con.prepareStatement(query);
			pstm.setInt(1,emp.getId());
			pstm.setString(2,emp.getName());
			pstm.setInt(3,(int) emp.getSalary());
			pstm.setInt(4, emp.getAge());
		int cnt=pstm.executeUpdate();
		String resp = "Error occured";
		if(cnt==1) {
			resp="user added";
		}
		System.out.println(resp);
		 }catch(Exception ex){
				System.out.println(ex);

			 ex.printStackTrace();
		 }
		 
	}

	@Override
	public void showEmployee() {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnection();
		String query="select * from employee";
		System.out.println("Employee Details as Below: ");
		System.out.println("-------------------------------------------------------------------");
		System.out.format("%s\t%s\t%s\t%s\n","ID","Name","  Salary","age");
		System.out.println("-------------------------------------------------------------------");
		try {
			Statement stmt= (Statement) con.createStatement();
			ResultSet result= stmt.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n",
						result.getInt(1),
						result.getString(2),
						result.getDouble(3),
						result.getInt(4));
				System.out.println("-------------------------------------------------------------------");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void showEmployeeBasedOnId(int id) {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnection();
		String query="select * from employee where id=" +id;
		System.out.println("The Details Employee Are:");
		System.out.println("-------------------------------------------------------------------");
		System.out.format("%s\t%s\t%s\t%s\n","ID","Name","  Salary","age");
		System.out.println("-------------------------------------------------------------------");
		try {
			Statement stmt=(Statement) con.createStatement();
			ResultSet result= stmt.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n",
						result.getInt(1),
						result.getString(2),
						result.getDouble(3),
						result.getInt(4));
				System.out.println("-------------------------------------------------------------------");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(int id, String name) {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnection();
		String query="update employee set name=? where id=?";
		try {
			PreparedStatement pstm=(PreparedStatement) con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setInt(2, id);
			int cnt=pstm.executeUpdate();
			if(cnt!=0) {
				System.out.println("Employee Details updated Successfuly");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnection();
		String query="delete from employee where id=?";
		try {
			PreparedStatement pstm= (PreparedStatement) con.prepareStatement(query);
			pstm.setInt(1, id);
		int cnt=pstm.executeUpdate();
		if(cnt!=0) {
			System.out.println("Employee Deleted Successfully......");
		}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	

}
