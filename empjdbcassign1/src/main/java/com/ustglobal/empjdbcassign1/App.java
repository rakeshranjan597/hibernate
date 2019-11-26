package com.ustglobal.empjdbcassign1;

import java.util.List;
import java.util.Scanner;

import com.ustglobal.empjdbcassign1.dao.EmployeeDAO;
import com.ustglobal.empjdbcassign1.dto.EmployeeInfo;
import com.ustglobal.empjdbcassign1.util.EmployeeFactory;

public class App {
    public static void main( String[] args ) {
    	System.out.println("Press 1 to get all employee data");
		System.out.println("Press 2 to insert employee data");
		System.out.println("Press 3 to search employee data");
		System.out.println("Press 4 to delete employee data");
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();

		switch(n) {
		
			case 1:
				EmployeeDAO dao1 = EmployeeFactory.getEmployeeDAO();
				List<EmployeeInfo> info1 = dao1.selectEmp();
				for(EmployeeInfo ei1: info1) {
					System.out.println("~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Id is :" + ei1.getId());
					System.out.println("Name is :" + ei1.getName());
					System.out.println("Salary is :" + ei1.getSal());
					System.out.println("Gender is :" + ei1.getGender());
					
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
				
				EmployeeInfo info2 = new EmployeeInfo();
				info2.setId(id2);
				info2.setName(name2);
				info2.setSal(sal2);
				info2.setGender(gender2);
				
				EmployeeDAO dao2 = EmployeeFactory.getEmployeeDAO();
				int res2 = dao2.insertEmp(info2);
				if(res2!=0) {
					System.out.println("~~~~ inserted ~~~~");
				} else {
					System.out.println("~~~~ Failed to insert ~~~~");
				}
				
				break;
				
			case 3:
				System.out.print("Enter the id: ");
				int id3 = obj.nextInt();
				EmployeeDAO dao3 = EmployeeFactory.getEmployeeDAO();
				EmployeeInfo info3 = dao3.searchEmp(id3);
				if (info3!=null) {
					System.out.println("~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Id is :" + info3.getId());
					System.out.println("Name is :" + info3.getName());
					System.out.println("Salary is :" + info3.getSal());
					System.out.println("Gender is :" + info3.getGender());
				} else {
					System.out.println("~~~~ Data Not found ~~~~");
				}
				break;
				
			case 4:
				EmployeeDAO dao4 = EmployeeFactory.getEmployeeDAO();
				System.out.print("Enter the id to delete: ");
				int id4 = obj.nextInt();
				int res4 = dao4.deleteEmp(id4);
				if(res4!=0) {
					System.out.println("~~~~ Deleted ~~~~");
				} else {
					System.out.println("~~~~ Id Not Found ~~~~");
				}
				break;
			default:
				System.out.println("Press valid no.");
		}
    }
}
