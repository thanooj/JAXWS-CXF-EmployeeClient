package com.cxfjaxws.client;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cxfjaxws.EmployeeRequest;
import com.cxfjaxws.EmployeeResponse;
import com.cxfjaxws.ObjectFactory;
import com.cxfjaxws.vo.EmpAddr;
import com.cxfjaxws.vo.EmployeeVo;
import com.service.cxfjaxws.EmployeePortTypeImplService;

public class EmployeeClient {
	private final Logger logger = LoggerFactory.getLogger(EmployeeClient.class);
	
	
	private EmployeePortTypeImplService employeeClient = new EmployeePortTypeImplService();

	public List<EmployeeVo> getEmployee(BigInteger id) {
		logger.info("########################### getEmployee starts");
		ObjectFactory objectFactory = new ObjectFactory();
		EmployeeRequest employeeRequest = objectFactory.createEmployeeRequest();
		employeeRequest.setId(id);
		EmployeeResponse employee = employeeClient.getEmployeePortTypeImplPort().getEmployee(employeeRequest);
		List<EmployeeVo> employeeVos = new ArrayList<EmployeeVo>();
		EmpAddr addr = new EmpAddr(employee.getAddr().getDNo(), employee.getAddr().getLine(), employee.getAddr().getStreet(), employee.getAddr().getCity(), employee.getAddr().getState(), employee.getAddr().getCountry(), employee.getAddr().getZipcode());
		EmployeeVo employeeVo = new EmployeeVo(employee.getId(),employee.getFirstname(),employee.getLastname(), addr, employee.getDept(), employee.getDOJ().toGregorianCalendar().getTime());
		employeeVos.add(employeeVo);
		logger.info("employeeVo :: "+employeeVo);
		logger.info("########################### getEmployee ends");
		return employeeVos;
	}

	public static void main(String[] args) {
		EmployeeClient client = new EmployeeClient();
		client.getEmployee(new BigInteger("1"));
	}
}
