package jp.co.aa.milab.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.aa.milab.mapper.AttendMapper;

@Component
public class AttendService {
	
	@Autowired
	AttendMapper attendMapper;
	
	public void empClockIn(String empId,String date,String workDate) {
		attendMapper.empClockIn(empId, date,workDate);
	}
	 public void empClockOut(String empId,String date,String workDate, String workTime) {
		attendMapper.empClockOut(empId, date,workDate,workTime);
	}
	 
	 public List<Integer> empCheck(String empId,String workDate) {
		 return attendMapper.empCheck(empId,workDate);
	 }
	 public String empOutCheck(String empId,String workDate) {
		 return attendMapper.empOutCheck(empId,workDate);
		 
	 }
	 public String empInCheck(String empId,String workDate) {
		 return attendMapper.empInCheck(empId,workDate);
		 
	 }
//	 public Attendance empCheck(AttendanceForm attendanceForm) {
//		 return attendMapper.empCheck(attendanceForm);
//	 }
	 
	 public void empClockUpdate(AttendanceForm attendanceForm) {
		 attendMapper.empClockUpdate(attendanceForm);
		 
	 }
	 public void empClockDelete(String attendId) {
		attendMapper.empClockDelete(attendId);
		 
	 }
	 
	
	

}
