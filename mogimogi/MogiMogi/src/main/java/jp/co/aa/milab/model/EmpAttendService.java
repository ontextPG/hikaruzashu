package jp.co.aa.milab.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.aa.milab.mapper.EmpAttendMapper;

@Component
public class EmpAttendService {
	
	@Autowired
	EmpAttendMapper empAttendMapper;
	
	 // 社員勤怠情報検索													
    List<Attendance> selectAttend(String empId){
    	return empAttendMapper.selectAttend(empId);
    	
    }

}
