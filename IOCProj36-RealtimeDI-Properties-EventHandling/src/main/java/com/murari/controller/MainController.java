package com.murari.controller;

import com.murari.dto.CustomerDTO;
import com.murari.service.CustomerMgmtService;
import com.murari.vo.CustomerVO;

public  final class MainController {
	private CustomerMgmtService service;
 
	  //for constructor injection
	public MainController(CustomerMgmtService service) {
		this.service = service;
	}
	
	public  String  processCustomer(CustomerVO  vo)throws Exception{
		CustomerDTO dto=null;
		String result=null;
		//convert  VO class object to DTO class object
		dto=new CustomerDTO();
		dto.setCname(vo.getCname());
		dto.setCadd(vo.getCadd());
		dto.setPamt(Float.parseFloat(vo.getpAmt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		//use service
		result=service.calculateIntrestAmount(dto);
		return result;
		
	}
	
	

}
