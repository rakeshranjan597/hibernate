package com.ustglobal.jpahibernatejpqlassign3.dao;

import java.util.List;

import com.ustglobal.jpahibernatejpqlassign3.dto.EmployeeInfo;

public interface EmployeeDAO {
	
	int deleteEmp(int id);
	
	int updateEmp(int id, String name, int sal, String gender);
	
	List<EmployeeInfo> selectAllEmp();
	
	EmployeeInfo selectEmp(int id);
	
	int insertEmp(int id, String name, int sal, String gender);
}
