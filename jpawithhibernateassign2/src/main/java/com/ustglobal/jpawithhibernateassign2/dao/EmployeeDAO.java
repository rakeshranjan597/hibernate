package com.ustglobal.jpawithhibernateassign2.dao;

import java.util.List;

import com.ustglobal.jpawithhibernateassign2.dto.EmployeeInfo;

public interface EmployeeDAO {
	
	EmployeeInfo selectEmp(int id);
	
	void deleteEmp(int id);
	
	void updateEmp(int id, String name, int sal, String gender);
	
	void insertEmp(EmployeeInfo info);
	
	List<EmployeeInfo> selectAllEmp();
	
}
