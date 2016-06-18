package com.cxfjaxws.client;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cxfjaxws.EmployeeType;
import com.cxfjaxws.GetEmployeeListResponseType;
import com.cxfjaxws.GetEmployeeRequestType;
import com.cxfjaxws.GetEmployeeResponseType;
import com.cxfjaxws.NoArgType;
import com.cxfjaxws.ObjectFactory;
import com.cxfjaxws.vo.EmpAddr;
import com.cxfjaxws.vo.EmployeeVo;
import com.service.cxfjaxws.EmployeePortTypeImplService;

public class EmployeeClient {
	private final Logger logger = LoggerFactory.getLogger(EmployeeClient.class);

	private EmployeePortTypeImplService employeeClient = new EmployeePortTypeImplService();

	public EmployeeVo getEmployee(BigInteger id) {
		logger.info("########################### getEmployee starts");
		ObjectFactory objectFactory = new ObjectFactory();
		GetEmployeeRequestType getEmployeeRequest = objectFactory.createGetEmployeeRequestType();
		getEmployeeRequest.setId(id);
		GetEmployeeResponseType getEmployeeResponseType = employeeClient.getEmployeePortTypeImplPort()
				.getEmployee(getEmployeeRequest);
		EmployeeType employee = getEmployeeResponseType.getEmployee();
		EmpAddr addr = new EmpAddr(employee.getAddr().getDNo(), employee.getAddr().getLine(),
				employee.getAddr().getStreet(), employee.getAddr().getCity(), employee.getAddr().getState(),
				employee.getAddr().getCountry(), employee.getAddr().getZipcode());
		EmployeeVo employeeVo = new EmployeeVo(employee.getId(), employee.getFirstname(), employee.getLastname(), addr,
				employee.getDept(), employee.getDOJ().toGregorianCalendar().getTime());
		logger.info("employeeVo :: " + employeeVo);
		logger.info("########################### getEmployee ends");
		return employeeVo;
	}

	public List<EmployeeVo> getEmployees() {
		logger.info("########################### getEmployee starts");
		ObjectFactory objectFactory = new ObjectFactory();
		NoArgType noArgType = objectFactory.createNoArgType();
		GetEmployeeListResponseType employees = employeeClient.getEmployeePortTypeImplPort().getEmployees(noArgType);
		List<EmployeeVo> employeeVos = new ArrayList<EmployeeVo>();
		List<EmployeeType> empList = employees.getEmployee();
		for (EmployeeType employee : empList) {
			EmpAddr addr = new EmpAddr(employee.getAddr().getDNo(), employee.getAddr().getLine(),
					employee.getAddr().getStreet(), employee.getAddr().getCity(), employee.getAddr().getState(),
					employee.getAddr().getCountry(), employee.getAddr().getZipcode());
			EmployeeVo employeeVo = new EmployeeVo(employee.getId(), employee.getFirstname(), employee.getLastname(),
					addr, employee.getDept(), employee.getDOJ().toGregorianCalendar().getTime());
			employeeVos.add(employeeVo);
		}
		for (EmployeeVo employeeVo : employeeVos) {
			logger.info("employeeVo :: " + employeeVo);
		}
		logger.info("########################### getEmployee ends");
		return employeeVos;
	}

	public static void main(String[] args) {
		EmployeeClient client = new EmployeeClient();
		client.getEmployee(new BigInteger("1"));
		client.getEmployees();
	}
}
