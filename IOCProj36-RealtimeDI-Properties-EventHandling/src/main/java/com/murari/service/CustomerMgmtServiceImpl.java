package com.murari.service;

import com.murari.bo.CustomerBO;
import com.murari.dao.CustomerDAO;
import com.murari.dto.CustomerDTO;

public final class CustomerMgmtServiceImpl implements CustomerMgmtService {
	private  CustomerDAO dao;
	private  String osName;
	private String path;

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public CustomerMgmtServiceImpl(CustomerDAO dao) {
		this.dao = dao;
	}

	@Override
	public String calculateIntrestAmount(CustomerDTO dto) throws Exception {
		System.out.println("osName::"+osName+"  path::"+path);
	    float intrAmt=0.0f;
	    CustomerBO bo=null;
	    int count=0;
		//calculate intrest amount
	    intrAmt=(dto.getPamt()*dto.getRate()*dto.getTime())/100.0f;
		//prepare CustomerBO object having persistable data...
	    bo=new CustomerBO();
	    bo.setCname(dto.getCname());
	    bo.setCadd(dto.getCadd());
	    bo.setPamt(dto.getPamt());
	    bo.setIntramt(intrAmt);
	    //use dAO
	    count=dao.insert(bo);
	    // process the result
	    if(count==0)
	    	  return "Customer Registration failed :: Amt::"+dto.getPamt()+"  intrest::"+intrAmt;
	    else 
	    	 return "Customer Registration Succeded :: Amt::"+dto.getPamt()+"  intrest::"+intrAmt;
	}
}
