package com.murari.controller;

import com.murari.dto.EmployeeDTO;
import com.murari.service.EmployeeMgmtService;
import com.murari.vo.EmployeeVO;

public class MainController {
	
	private EmployeeMgmtService service;

	public MainController(EmployeeMgmtService service) {
		this.service = service;
	}
	public String processEmployee(EmployeeVO vo) throws Exception{
		
		EmployeeDTO dto=null;
		String result=null;
		
		//convert EmployeeVO to EmployeeDTO
		dto=new EmployeeDTO();
		dto.setEname(vo.getEname());
		dto.setEadd(vo.getEadd());
		dto.setEdept(Integer.parseInt(vo.getEdept()));
		dto.setBasicSal(Float.parseFloat(vo.getBasicSal()));
		
		//use service
		result=service.calculateNetSalary(dto);
		return result;
	}
	
	

}
