package jp.co.aa.milab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.aa.milab.model.EmpService;
import jp.co.aa.milab.model.EmployeeForm;


public class EmpUpdateController {
	
	@Controller
	public class UserController {
		
	    @Autowired
	    EmpService es;
	    
	    // 社員変更画面の表示																								
	    @GetMapping("/empUpdate")
	    public String getEmpUpdate(@ModelAttribute("employeeForm")String empId) {																									
	        // empUpdate.htmlを表示
	    	return "empUpdate";
	    	}
	    
	    // 社員情報変更
	    @PostMapping("/empUpdate")
	    public String postRegist(@Validated
	    		@ModelAttribute("empUpdate") EmployeeForm employeeForm,
	    		BindingResult bindingResult
	    		) {
	    	
	    	// 入力チェック
	    	if(bindingResult.hasErrors()) {																									
            // empUpdate.htmlを表示																							
            return "empUpdate";
            }
	    	else {
	    		// 更新処理
	    		es.empUpdate(employeeForm);
	    		//社員一覧画面にリダイレクト
		    	return "redirect:/kintaiList";
	    		}
	    	
	    	}	
    
    
    }
}
