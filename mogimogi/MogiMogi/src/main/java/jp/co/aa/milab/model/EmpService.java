package jp.co.aa.milab.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.aa.milab.mapper.EmpMapper;

@Component
public class EmpService {
	
	@Autowired
	EmpMapper empMapper;
	
	public void empRegist(EmployeeForm empForm) {
	}
	public void empUpdate(EmployeeForm empForm) {
	}
	public void empDelete(String empId) {
	}

}
