package jp.co.aa.milab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aa.milab.model.EmpService;

@Controller
public class EmpDeleteController {
	@Autowired
	EmpService empService;
	
	//社員削除
	@PostMapping("/empDelete")
	 public String postEmpDelete(@RequestParam(name = "empId", defaultValue = "") String empId) {
	//削除処理
	empService.empDelete(empId);
	//社員リストにリダイレクト
	 return "redirect:/empList.html";	
	}

}
