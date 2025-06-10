package jp.co.aa.milab.model;

import jakarta.validation.constraints.NotBlank;

public class EmployeeForm {
	
	private String attendId;
	@NotBlank(message="社員IDを入力してください")
	private String empId;
	@NotBlank(message="氏名を入力してください")
	private String empName;
	@NotBlank(message="パスワードを入力してください")
	private String pass;
	private String totalWorkHrs;
	@NotBlank(message="メールアドレスを入力してください")
	private String mail;
	@NotBlank(message="入社日を入力してください")
	private String empDateJoin;
	private String positionId;
	private String depaId;
	
	
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
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTotalWorkHrs() {
		return totalWorkHrs;
	}
	public void setTotalWorkHrs(String totalWorkHrs) {
		this.totalWorkHrs = totalWorkHrs;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getEmpDateJoin() {
		return empDateJoin;
	}
	public void setEmpDateJoin(String empDateJoin) {
		this.empDateJoin = empDateJoin;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getDepaId() {
		return depaId;
	}
	public void setDepaId(String depaId) {
		this.depaId = depaId;
	}


}
