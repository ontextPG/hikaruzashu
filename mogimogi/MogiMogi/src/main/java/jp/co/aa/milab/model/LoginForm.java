package jp.co.aa.milab.model;

import jakarta.validation.constraints.NotBlank;

public class LoginForm {
	@NotBlank(message="社員IDを入力してください")
	private String empId;
	@NotBlank(message="パスワードを入力してください")
	private String pass;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
