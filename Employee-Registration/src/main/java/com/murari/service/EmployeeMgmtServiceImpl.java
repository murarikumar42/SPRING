package com.murari.service;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.jmx.support.RegistrationPolicy;

import com.murari.bo.EmployeeBO;
import com.murari.dao.EmployeeDAO;
import com.murari.dto.EmployeeDTO;

public final class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	private EmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl(EmployeeDAO dao) {
		this.dao=dao;
	}
	@Override
	public String calculateNetSalary(EmployeeDTO dto) throws Exception {
		
		float da=0.0f;
		float hra=0.0f;
		float pf=0.0f;
		float netSal=0.0f;
		EmployeeBO bo=null;
		int count=0;
		
		//calculate net salary
		da=dto.getBasicSal()*0.3f;
		hra=dto.getBasicSal()*0.1f;
		pf=dto.getBasicSal()*0.07f;
		netSal=dto.getBasicSal()+da+hra-pf;
		
		//prepare EmployeeBO object having persistable data
		bo=new EmployeeBO();
		bo.setEname(dto.getEname());
		bo.setEadd(dto.getEadd());
		bo.setEdept(dto.getEdept());
		bo.setBasicSal(dto.getBasicSal());
		bo.setNetSal(netSal);
		
		//use dao
		count=dao.insert(bo);
		
		//process the result
		if(count==0)
			return "Registration failed::BasicSal="+dto.getBasicSal()+"   NetSal="+netSal;
		return "Registration succedded::BasicSsal="+dto.getBasicSal()+"   netsal= "+netSal;
				
				
				
		
	}

}
