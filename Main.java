package com.Crudoperation.empapp;
import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		String name;
		int id;
		EmployeeDaoIntrf dao= new EmployeeDaoImpl();
		System.out.println("*******  Welcome to Employee Mgt Application ******* \n");
		
		Scanner sc = new Scanner(System.in);
		
		
		do {
			System.out.println("1.Add Employee \n" +
						"2.Show All Employee Details\n" +
						"3.Show Employee based on id \n" +
						"4.Update the Employee \n" +
						"5.Delete the Employee\n"
					);
			System.out.println("Enter your Choice: ");
			
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				Employee emp = new Employee();
				System.out.println("Enter Id:- ");
				 id=sc.nextInt();
				System.out.println("Enter Name:- ");
				 name= sc.next();
				System.out.println("Enter your Salary:-  ");
				 int salary=sc.nextInt();
				System.out.println("Enter age:- ");
				int age=sc.nextInt();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				dao.createEmployee(emp);
				break;
			case 2:
				dao.showEmployee();
				break;
			case 3:
				System.out.println("Enter Id to show the Details:");
				int empid=sc.nextInt();
				dao.showEmployeeBasedOnId(empid);
			case 4:
				System.out.println("Enter the Employee id for the update the Details:");
				int empid1=sc.nextInt();
				System.out.println("Enter the new name:");
				 name=sc.next();
				dao.updateEmployee(empid1, name);
				break;
				
			case 5:
				System.out.println("Enter the id for delete the employee record");
				id=sc.nextInt();
				dao.deleteEmployee(id);
				
			case 6:
				System.out.println("Thank you for using Our Applicaton......!!!!!!");
				System.exit(0);
			default:
				System.out.println("Please Enter valid choice");
				break;
			}
			
		}while(true);
		
	}

}
