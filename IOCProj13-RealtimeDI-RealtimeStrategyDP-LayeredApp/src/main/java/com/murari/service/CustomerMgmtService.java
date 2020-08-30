package com.murari.service;

import com.murari.dto.CustomerDTO;

public interface CustomerMgmtService {

	public String calculateSimpleInterestAmount(CustomerDTO dto)throws Exception;
}
