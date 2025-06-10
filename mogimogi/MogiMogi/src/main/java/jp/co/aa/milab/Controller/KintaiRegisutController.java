package jp.co.aa.milab.Controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import jp.co.aa.milab.model.AttendService;

@Controller
public class KintaiRegisutController {
	
	@Autowired
	AttendService as;
	@Autowired
	HttpSession session;
	

	
	
	@GetMapping("/kintaiRegist")
	public String getKintaiRegist() {
		//現在日付
        LocalDate nowDate = LocalDate.now();
        //yyyy-MM-ddに変換
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //String型に変換
        String dateString = nowDate.format(formatter);
      //今日の日付と社員IDで検索して今日出勤したか
        List<Integer> attendCheck=as.empCheck((String) session.getAttribute("empId"), dateString);
		if(attendCheck!=null && !attendCheck.isEmpty()) {	
			//退勤チェック
		if(as.empOutCheck((String) session.getAttribute("empId"), dateString) == null&&session.getAttribute("attend")==null){
			//していない場合出勤状態にする
			session.setAttribute("attend",1);
			//出勤時間をsessionに登録
			String timeString = as.empInCheck((String) session.getAttribute("empId"), dateString).formatted(DateTimeFormatter.ofPattern("HH:mm"));
			session.setAttribute("InTime", timeString); // HH:mm のみ

		}
		}
		System.out.println(session.getAttribute("InTime"));
		return"kintaiRegist";
	}
	
	
	@PostMapping("/kintaiRegist")
	public String postKintaiRegist(RedirectAttributes attr) {
		//現在時刻
		LocalTime now = LocalTime.now(); 
		//時取得
        int hour = now.getHour(); 
        //分取得
        int minute = now.getMinute();   
        //String型に変換（00:00）
        String timeString = String.format("%02d:%02d", hour, minute);
       
        //現在日付
        LocalDate nowDate = LocalDate.now();
        //yyyy-MM-ddに変換
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //String型に変換
        String dateString = nowDate.format(formatter);
        
        //sessionに勤怠が保存されているか
		if(session.getAttribute("attend")==null) {
		
			//今日の日付と社員IDで検索して今日出勤したか
			List<Integer> attendCheck=as.empCheck((String) session.getAttribute("empId"), dateString);
			if(attendCheck!=null && !attendCheck.isEmpty()) {				
				//働いた場合				
				System.out.println(as.empOutCheck((String) session.getAttribute("empId"), dateString));
				attr.addFlashAttribute("message", "あんだもう働いたよ");
				return "redirect:/menu";
				
			}else {
				//働いていない場合
			//勤怠をsessionに保存
			session.setAttribute("attend",1);
			//出勤登録
			as.empClockIn((String) session.getAttribute("empId"),timeString,dateString);
			//sessionに出勤時間を保存
			session.setAttribute("InTime", timeString);
			attr.addFlashAttribute("message", "がんばれ");
			return "redirect:/menu";
			}
			
			
		}
			//退勤処理
			//出勤時間を変数に保存
			String inTimeStr = (String) session.getAttribute("InTime");
			//inTimeStrをLocalTime型に変換（HH:ｍｍ）
			LocalTime inTime = LocalTime.parse(inTimeStr, DateTimeFormatter.ofPattern("HH:mm"));
			//inTimeからnowまでの時間をDuration型で計算
			Duration duration = Duration.between(inTime, now);
			//何時間立ったか
			long hours = duration.toHours();
			//60で割って分を計算
			long minutes = duration.toMinutes() % 60;

			// 00:00形式の勤務時間文字列
			String workTime = String.format("%02d:%02d", hours, minutes);

			//sessionから勤怠を削除
			session.removeAttribute("attend");
			//退勤処理
			as.empClockOut((String) session.getAttribute("empId"),timeString,dateString,workTime);
			attr.addFlashAttribute("message", "おつかれ");
		
		return "redirect:/menu";
		
	}

}
