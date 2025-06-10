package jp.co.aa.milab.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.aa.milab.model.AttendanceForm;

@Mapper
public interface AttendMapper {
	void empClockIn(String empId,String date,String workDate); 
	void empClockOut(String empId,String date,String workDate, String workTime);
	List<Integer> empCheck(String empId, String workDate); 
	String empOutCheck(String empId, String workDate); 
	String empInCheck(String empId, String workDate); 
	void empClockUpdate(AttendanceForm attendanceForm);
	void empClockDelete(String attendId);
//	Attendance empCheck(AttendanceForm attendanceForm);
}
