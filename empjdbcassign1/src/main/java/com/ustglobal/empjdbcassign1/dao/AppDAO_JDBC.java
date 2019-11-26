package com.ustglobal.empjdbcassign1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ustglobal.empjdbcassign1.dto.EmployeeInfo;

public class AppDAO_JDBC implements EmployeeDAO{
	
	private static final String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
	
	public List<EmployeeInfo> selectEmp() {
		String sql = "select * from employee_info";
		try(Connection con = DriverManager.getConnection(url)){
			try(Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					){
				ArrayList<EmployeeInfo> al = new ArrayList<>();
				while(rs.next()) {
					EmployeeInfo info = new EmployeeInfo();
					info.setId(rs.getInt("id"));
					info.setSal(rs.getInt("sal"));
					info.setName(rs.getString("name"));
					info.setGender(rs.getString("gender"));
					
					al.add(info);
				}
				return al;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public EmployeeInfo searchEmp(int id) {
		String sql = "select * from employee_info where id='"+id+"'";
		try(Connection con = DriverManager.getConnection(url);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				){
			if (rs.next()) {
				EmployeeInfo info = new EmployeeInfo();
				info.setId(rs.getInt("id"));
				info.setSal(rs.getInt("sal"));
				info.setName(rs.getString("name"));
				info.setGender(rs.getString("gender"));
				
				return info;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertEmp(EmployeeInfo info) {
		String sql = "insert into employee_info values(?,?,?,?)";
		try(Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(sql);
				){
			ps.setInt(1, info.getId());
			ps.setString(2, info.getName());
			ps.setInt(3, info.getSal());
			ps.setString(4, info.getGender());
			
			int count = ps.executeUpdate();
			return count;
					
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteEmp(int id) {
		String sql = "delete from employee_info where id=?";
		try(Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(sql);
				){
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
