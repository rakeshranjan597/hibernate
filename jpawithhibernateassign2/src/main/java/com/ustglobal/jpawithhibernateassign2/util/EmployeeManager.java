package com.ustglobal.jpawithhibernateassign2.util;

import com.ustglobal.jpawithhibernateassign2.dao.EmployeeDAO;
import com.ustglobal.jpawithhibernateassign2.dao.EmployeeDAO_Hib;

public class EmployeeManager {
	
	private EmployeeManager() {		}
	
	public static EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAO_Hib();
	}
}
