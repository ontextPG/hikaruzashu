package jp.co.aa.milab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.aa.milab.model.AttendService;
import jp.co.aa.milab.model.AttendanceForm;

@Controller
public class kintaiUpdateController {
	@Autowired
	AttendService as;
	
	//勤怠変更画面を表示
	@GetMapping("/kintaiUpdate")
	public String getKintaiUpdate(String empId) {
		return "kintaiUpdate";
	}
	
	//勤怠情報を更新
	@PostMapping("/kintaiUpdate")
	public String postKintaiUpping(
			@Validated @ModelAttribute("kintaiUpdate") AttendanceForm attendanceForm,
			BindingResult bindingResult) {
		
		//出勤時刻/退勤時刻ともに入力されているか
		if(bindingResult.hasErrors()) {
			//入力エラーの時は勤怠変更画面にリダイレクト
			return "redirect:/kintaiUpdate";
		}
		else {
			//勤怠情報を更新
			as.empClockUpdate(attendanceForm);
			//勤怠一覧にリダイレクト
			return "redirect:/kintaiList";
		}
	}
}
