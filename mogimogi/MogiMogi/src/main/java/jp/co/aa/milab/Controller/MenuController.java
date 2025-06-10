package jp.co.aa.milab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	
	//メニュー画面を表示
	@GetMapping("/menu")
	public String getMenu() {
		return "menu";
	}
	
	//勤怠一覧を表示
	@GetMapping("/kintaiList")
	public String getKintaiList() {
		return "kintaiList";
	}
	
	//社員一覧を表示
	@GetMapping("/empList")
	public String getEmpList() {
		return "empList";
	}
}
