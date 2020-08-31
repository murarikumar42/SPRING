package com.murari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.murari.bo.CustomerBO;

public final class CustomerDAOImpl implements CustomerDAO {
	private static final String CUSTOMER_INSERT_QUERY="INSERT INTO SPRING_CUSTOMER VALUES(CNO_SEQ01.NEXTVAL,?,?,?,?)";
	private DataSource ds;
	
	//constructor injection
	public CustomerDAOImpl(DataSource ds) {
		this.ds = ds;
	}


	@Override
	public int insert(CustomerBO bo) throws Exception {
		//jdbc code to insert record
		
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		
		//get pooled jdbc connection
		con=ds.getConnection();
		
		//create preparedStatement object
		ps=con.prepareStatement(CUSTOMER_INSERT_QUERY);
		
		//set values to query parameters
		ps.setString(1, bo.getCname());
		ps.setString(2, bo.getCadd());
		ps.setFloat(3, bo.getPamt());
		ps.setFloat(4, bo.getInterestAmt());
		
		//execute the sql query
		count=ps.executeUpdate();
		
		//close jdbc objs
		ps.close();
		con.close();
		
		return count;
	}

}
