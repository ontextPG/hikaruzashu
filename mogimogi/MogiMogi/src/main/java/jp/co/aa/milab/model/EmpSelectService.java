package jp.co.aa.milab.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.aa.milab.mapper.EmpSelectMapper;

@Component
public class EmpSelectService {
@Autowired
EmpSelectMapper empSelectMapper;

public List<Employee> empSelectList() {
	return empSelectMapper.empSelectList();
}
public Employee empIdSelect(String empId){
	return empSelectMapper.empIdSelect(empId);
}
public List<Employee> empNameSelect(String empName){
	return empSelectMapper.empNameSelect(empName);
}
public List<Employee> empIdNameSelect(String empId, String empName){
	return empSelectMapper.empIdNameSelect(empId,empName);
}
}
