package com.murari.service;

import com.murari.bo.CustomerBO;
import com.murari.dao.CustomerDAO;
import com.murari.dto.CustomerDTO;

public final class CustomerMgmtServiceImpl implements CustomerMgmtService {

	private CustomerDAO dao;
	
	public CustomerMgmtServiceImpl(CustomerDAO dao) {
		this.dao = dao;
	}

	@Override
	public String calculateSimpleInterestAmount(CustomerDTO dto) throws Exception {
		float interestAmt=0.0f;
		CustomerBO bo=null;
		int count=0;
		
		//calculate interest amount
		interestAmt=(dto.getPamt()*dto.getRate()*dto.getTime())/100.0f;
		
		//prepare CustomerBO object having persistable data
		bo=new CustomerBO();
		bo.setCname(dto.getCname());
		bo.setCadd(dto.getCadd());
		bo.setPamt(dto.getPamt());
		bo.setInterestAmt(interestAmt);
		
		//use dao
		count=dao.insert(bo);
		
		//process the result
		if(count==0)
			return "Registration failed: Amt:"+dto.getPamt()+"interest:"+interestAmt;
		return "Registration succeded: Amt:"+dto.getPamt()+"interest:"+interestAmt;
	}

}
