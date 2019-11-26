package com.ustglobal.jpahibernatejpqlassign3;

import java.util.List;
import java.util.Scanner;

import com.ustglobal.jpahibernatejpqlassign3.dao.EmployeeDAO;
import com.ustglobal.jpahibernatejpqlassign3.dto.EmployeeInfo;
import com.ustglobal.jpahibernatejpqlassign3.util.EmployeeManager;

public class App {
    public static void main( String[] args ){
    	System.out.println("Press 1 to update employee data: ");
		System.out.println("Press 2 to insert employee data: ");
		System.out.println("Press 3 to search employee data: ");
		System.out.println("Press 4 to delete employee data: ");
		System.out.println("Press 5 to get all employee data: ");
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		
		switch(n) {
		
			case 1:
				System.out.print("Enter the id to update: ");
				int id1 = obj.nextInt();
				obj.nextLine();
				System.out.print("Enter the name: ");
				String name1 = obj.nextLine();
				System.out.print("Enter the Salary: ");
				int sal1 = obj.nextInt();
				System.out.print("Enter the Gender: ");
				String gender1 = obj.next();
				
				EmployeeDAO dao1 = EmployeeManager.getEmployeeDAO();
				int result1 = dao1.updateEmp(id1,name1,sal1,gender1);
				if (result1!=0) {
					System.out.println("~~~~ Data Updated ~~~~");
				} else {
					System.out.println("~~~~ Failed To Update ~~~~");
				}
				
				break;
			
			case 2:
				System.out.print("Enter the id: ");
				int id2 = obj.nextInt();
				obj.nextLine();
				System.out.print("Enter the name: ");
				String name2 = obj.nextLine();
				System.out.print("Enter the Salary: ");
				int sal2 = obj.nextInt();
				System.out.print("Enter the Gender: ");
				String gender2 = obj.next();
				
				EmployeeDAO dao2 = EmployeeManager.getEmployeeDAO();
				int result2 = dao2.insertEmp(id2, name2, sal2, gender2);
				if (result2!=0) {
					System.out.println("~~~~ Data Inseted ~~~~");
				} else {
					System.out.println("~~~~ Failed To Insert ~~~~");
				}
				break;
			
			case 3:
				System.out.print("Enter the id to search: ");
				int id3 = obj.nextInt();
				EmployeeDAO dao3 = EmployeeManager.getEmployeeDAO();
				EmployeeInfo info3 = dao3.selectEmp(id3);
				if (info3!=null) {
					System.out.println("~~~~~~~~~~~~~~~");
					System.out.println("Id is: "+ info3.getId());
					System.out.println("Name is: "+ info3.getName());
					System.out.println("Salary is: "+ info3.getSal());
					System.out.println("Gender is: "+ info3.getGender());
				} else {
					System.out.println("~~~~ Data Not Available ~~~~");
				}
				
				break;
			
			case 4:
				System.out.print("Enter the id: ");
				int id4 = obj.nextInt();
				
				EmployeeDAO dao4 = EmployeeManager.getEmployeeDAO();
				int result4 = dao4.deleteEmp(id4);
				if (result4!=0) {
					System.out.println("~~~~ Data Deleted ~~~~");
				} else {
					System.out.println("~~~~ Failed To Delete ~~~~");
				}
				
				break;
				
			case 5:
				EmployeeDAO dao5 = EmployeeManager.getEmployeeDAO();
				List<EmployeeInfo> info5 = dao5.selectAllEmp();
				if (info5!=null) {
					for(EmployeeInfo info: info5) {
						System.out.println("~~~~~~~~~~~~~~~");
						System.out.println("Id is: "+ info.getId());
						System.out.println("Name is: "+ info.getName());
						System.out.println("Salary is: "+ info.getSal());
						System.out.println("Gender is: "+ info.getGender());
					}
				} else {
					System.out.println("~~~~ Data Not Available ~~~~");
				}

				break;
			
			default:
				System.out.println("Press Valid Input.");
			
		}
    }
}
