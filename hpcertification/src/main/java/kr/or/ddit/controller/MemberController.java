package kr.or.ddit.controller;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	//문자를 보낼때 맵핑되는 메소드
    @RequestMapping(value = "/sendSms.do" ,method = RequestMethod.POST)
      public String sendSms(
    		  @RequestParam("to")String to,
    		  @RequestParam("text") String text
    		  ) throws Exception {
    	logger.info("컨트롤러 접근완료 %s, %s",to,text);
    	String api_key = "NCS2BHRMQKWJLZGF";
        String api_secret = "QM4KJEJRWMUTZQS0QUST7PUIB85LH63L";
        Message coolsms = new Message(api_key, api_secret);
        HashMap<String, String> set = new HashMap<String, String>();

        set.put("to", to); // 받는 사람
        set.put("from", "01046867852"); // 발신번호
        set.put("text", "안녕하세요 인증번호는 ["+text+"]입니다"); // 문자내용
        set.put("type", "sms"); // 문자 타입

        
        JSONObject result = coolsms.send(set); // 보내기&전송결과받기
        String res = result.toJSONString();
		/*
		 * if ((boolean)result.get("status") == true) { // 메시지 보내기 성공 및 전송결과 출력
		 * System.out.println("성공"); System.out.println(result.get("group_id")); //
		 * 그룹아이디 System.out.println(result.get("result_code")); // 결과코드
		 * System.out.println(result.get("result_message")); // 결과 메시지
		 * System.out.println(result.get("success_count")); // 메시지아이디
		 * System.out.println(result.get("error_count")); // 여러개 보낼시 오류난 메시지 수 } else {
		 * // 메시지 보내기 실패 System.out.println("실패");
		 * System.out.println(result.get("code")); // REST API 에러코드
		 * System.out.println(result.get("message")); // 에러메시지 }
		 */
       
        return res;
      }

}
