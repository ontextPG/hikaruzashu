package jp.co.aa.milab.model;

public class Attendance {
	
	private String attendId;
	private String empId;
	private String workDate;
	private String clockIn;
	private String clockOut;
	private String workHrs;
	
	public String getAttendId() {
		return attendId;
	}
	public void setAttendId(String attendId) {
		this.attendId = attendId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getClockIn() {
		return clockIn;
	}
	public void setClockIn(String clockIn) {
		this.clockIn = clockIn;
	}
	public String getClockOut() {
		return clockOut;
	}
	public void setClockOut(String clockOut) {
		this.clockOut = clockOut;
	}
	public String getWorkHrs() {
		return workHrs;
	}
	public void setWorkHrs(String workHrs) {
		this.workHrs = workHrs;
	}
	

}
