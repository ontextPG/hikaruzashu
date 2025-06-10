package jp.co.aa.milab.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.aa.milab.model.Employee;

@Mapper
public interface EmpSelectMapper {
	
	 // 社員情報全件リスト検索														
    List<Employee> empSelectList();	
    
    // 社員ID検索															
    Employee empIdSelect(String empId);
    
    // 社員氏名検索															
    List<Employee> empNameSelect(String empName);
    
    //社員IDが社員氏名で社員情報をあいまい検索
    List<Employee> empIdNameSelect(String empId,String empName);

}
