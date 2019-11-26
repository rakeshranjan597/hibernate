package com.ustglobal.jpawithhibernateassign2;

import java.util.List;
import java.util.Scanner;

import com.ustglobal.jpawithhibernateassign2.dao.EmployeeDAO;
import com.ustglobal.jpawithhibernateassign2.dto.EmployeeInfo;
import com.ustglobal.jpawithhibernateassign2.util.EmployeeManager;


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
				dao1.updateEmp(id1,name1,sal1,gender1);
				
				break;
				
			case 2:
				System.out.print("~~~ How many Employee details you want to store: ~~~");
				int no = obj.nextInt();
				for(int i=0; i<no; i++) {
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
					
					EmployeeDAO dao2 = EmployeeManager.getEmployeeDAO();
					dao2.insertEmp(info2);
				}
				break;
				
			case 3:
				System.out.print("Enter the id: ");
				int id3 = obj.nextInt();
				EmployeeDAO dao3 = EmployeeManager.getEmployeeDAO();
				EmployeeInfo info3 = dao3.selectEmp(id3);
				if(info3!=null) {
					System.out.println("~~~~~~~~~~~~~~~~");
					System.out.println("Id is: "+ info3.getId());
					System.out.println("Name is: "+ info3.getName());
					System.out.println("Salery is: "+ info3.getSal());
					System.out.println("Gender is: "+ info3.getGender());
				} else {
					System.out.println("~~~~ Data Not Available ~~~~");
				}
				break;
				
			case 4:
				System.out.print("Enter the id: ");
				int id4 = obj.nextInt();
				
				EmployeeDAO dao4 = EmployeeManager.getEmployeeDAO();
				dao4.deleteEmp(id4);
				break;
			
			case 5:
				EmployeeDAO dao5 = EmployeeManager.getEmployeeDAO();
				List<EmployeeInfo> info5 = dao5.selectAllEmp();
				if(info5!=null) {
					for(EmployeeInfo info: info5) {
						System.out.println("~~~~~~~~~~~~~~~~");
						System.out.println("Id is: "+ info.getId());
						System.out.println("Name is: "+ info.getName());
						System.out.println("Salery is: "+ info.getSal());
						System.out.println("Gender is: "+ info.getGender());
					}
				} else {
					System.out.println("~~~~ Data Not Available ~~~~");
				}
			
			default:
				System.out.println("Press Valid Number.");
		}
    }
}
