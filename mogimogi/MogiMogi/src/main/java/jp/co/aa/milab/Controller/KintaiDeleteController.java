package jp.co.aa.milab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aa.milab.model.AttendService;

public class KintaiDeleteController {
	
	@Autowired
	AttendService as;
	
	// 勤怠情報削除																									
    @PostMapping("/kintaiDelete")																									
    public String postKintaiDelete(@RequestParam(name = "attendId", defaultValue = "") String attendId) {																									
    	// 削除処理																									
    	as.empClockDelete(attendId);																									
    	// 勤怠一覧画面にリダイレクト																									
    	return "redirect:/kintaiList";																									
    }

}
