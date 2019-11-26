package com.ustglobal.jpahibernatejpqlassign3.util;

import com.ustglobal.jpahibernatejpqlassign3.dao.EmployeeDAO;
import com.ustglobal.jpahibernatejpqlassign3.dao.EmployeeDAO_JPQL;

public class EmployeeManager {

	private  EmployeeManager() {   }
	
	public static EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAO_JPQL();
	}
}
