package jp.co.aa.milab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.aa.milab.model.EmpSelectService;
import jp.co.aa.milab.model.EmpService;
import jp.co.aa.milab.model.Employee;
import jp.co.aa.milab.model.EmployeeForm;

@Controller
public class EmpRegistController {
	@Autowired
	EmpService empService;
	@Autowired
	EmpSelectService empSelectService;
	@Autowired
	HttpSession session;
	
	
@GetMapping("/empRegist")
public String getEmpRegist(@ModelAttribute("employeeForm")EmployeeForm employeeForm) {
	return "empRegist";
}


@PostMapping("/empRegist")
public String postEmpRegist(@ModelAttribute("employeeForm")EmployeeForm employeeForm,
		BindingResult bindingResult,
		Model model) {
	Employee empList = empSelectService.empIdSelect(employeeForm.getEmpId());
	if(bindingResult.hasErrors()) {
		return "empRegist";
	}else if(empList!=null) {
		bindingResult.rejectValue("empId", null,"社員IDが存在しています");
		return "empRegist";
	}else {
		session.setAttribute("employeeForm", employeeForm);
		empService.empRegist(employeeForm);
		return"redirect:/menu";
	}
}
}

