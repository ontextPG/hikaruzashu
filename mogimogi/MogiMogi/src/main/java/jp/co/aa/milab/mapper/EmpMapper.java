package jp.co.aa.milab.mapper;

import org.apache.ibatis.annotations.Mapper;

import jp.co.aa.milab.model.EmployeeForm;

@Mapper															
public interface EmpMapper {	
	
	    // 社員新規登録															
	    void empRegist(EmployeeForm employeeform);														
																
	    // 社員編集															
	    void empUpdate(EmployeeForm employeeform);	
	    
	    // 社員削除								
	    void empDelete(String empId);								
													

}
