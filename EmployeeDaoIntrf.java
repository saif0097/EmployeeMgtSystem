package com.Crudoperation.empapp;

public interface EmployeeDaoIntrf {
	
	//Create employee
	public void createEmployee(Employee emp);
	// Show all employee
	public void showEmployee();
	//show employee based on id
	public void showEmployeeBasedOnId(int id);
	//update employee
	public void updateEmployee(int id,String name);
	//delete employee
	public void deleteEmployee(int id);

}
