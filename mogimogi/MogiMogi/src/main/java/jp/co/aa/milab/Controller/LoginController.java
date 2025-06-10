package jp.co.aa.milab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.aa.milab.model.EmpSelectService;
import jp.co.aa.milab.model.Employee;
import jp.co.aa.milab.model.LoginForm;

@Controller
public class LoginController {
	
	@Autowired
	EmpSelectService ess;
	@Autowired
	HttpSession session;
	
	@GetMapping("/login")
	public String getLogin(@ModelAttribute("loginForm") LoginForm loginForm) {
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(  @Validated @ModelAttribute("loginForm") LoginForm loginForm,BindingResult bindingResult,
										Model model) {
		
		if(bindingResult.hasErrors()) {
			return"login";
		}
		
		
		Employee emp = ess.empIdSelect(loginForm.getEmpId());
		//社員がいるか
		if (emp == null) {
		    model.addAttribute("message", "社員IDが存在しません");
		    return "login";
		}

		// パスワード確認
		if (emp.getPass() == null || !emp.getPass().equals(loginForm.getPass())) {
		    model.addAttribute("message", "パスワードが正しくありません");
		    return "login";
		}

		//ログイン
		//sesisonにデータを保存
	
		session.setAttribute("empId",emp.getEmpId());
		session.setAttribute("empName",emp.getEmpName());
			return "redirect:/menu";
	}
	
	@GetMapping("logout")
	public String getLogout() {
		//すべてのsessionをけす
		session.invalidate(); 
		return "redirect:/login";
		
	}
	
}

