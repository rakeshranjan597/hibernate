package com.ustglobal.empjdbcassign1.util;

import com.ustglobal.empjdbcassign1.dao.AppDAO_JDBC;
import com.ustglobal.empjdbcassign1.dao.EmployeeDAO;

public class EmployeeFactory {

	private EmployeeFactory() {}
	
	public static EmployeeDAO getEmployeeDAO() {
		return new AppDAO_JDBC();
	}
	
}


