package com.ustglobal.empjdbcassign1.dao;

import java.util.List;

import com.ustglobal.empjdbcassign1.dto.EmployeeInfo;

public interface EmployeeDAO {
		
	List<EmployeeInfo> selectEmp();
	
	EmployeeInfo searchEmp(int id);
	
	int insertEmp(EmployeeInfo info);
	
	int deleteEmp(int id);
}
