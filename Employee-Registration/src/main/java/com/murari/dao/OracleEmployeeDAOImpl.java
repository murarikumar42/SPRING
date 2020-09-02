package com.murari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.murari.bo.EmployeeBO;

public final class OracleEmployeeDAOImpl implements EmployeeDAO {
	private static final String EMPLOYEE_INSERT_QUERY="INSERT INTO SPRING_EMPLOYEE VALUES(CNO_SE1.NEXTVAL,?,?,?,?,?)";
	private DataSource ds;
	
	//constructor injection
	public OracleEmployeeDAOImpl (DataSource ds) {
		this.ds=ds;
	}
	
	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		
		//jdbc code to insert value
		
		//get pooled jdbc connection
		con=ds.getConnection();
		
		//create preparedStatement
		ps=con.prepareStatement(EMPLOYEE_INSERT_QUERY);
		
		//set values to query parameter
		ps.setString(1, bo.getEname());
		ps.setInt(2, bo.getEdept());
		ps.setString(3, bo.getEadd());
		ps.setFloat(4, bo.getBasicSal());
		ps.setFloat(5, bo.getNetSal());
		
		//execute the sql query
		count=ps.executeUpdate();
		
		//close jdbc
		ps.close();
		con.close();
		
		return count;
		
	}

}
