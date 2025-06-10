package jp.co.aa.milab.model;

import jakarta.validation.constraints.NotBlank;

public class AttendanceForm {
	
	
	private String attendId;

	private String workDate;
	@NotBlank(message="出勤時刻を入力してください")
	private String clockIn;
	@NotBlank(message="退勤時刻を入力してください")
	private String clockOut;

	private String workHrs;
	
	public String getAttendId() {
		return attendId;
	}
	public void setAttendId(String attendId) {
		this.attendId = attendId;
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
