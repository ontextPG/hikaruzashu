package jp.co.aa.milab.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.aa.milab.model.Attendance;

@Mapper
public interface EmpAttendMapper {
	
	 // 社員勤怠情報検索													
    List<Attendance> selectAttend(String empId);	

}


