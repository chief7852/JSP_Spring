package kr.or.ddit;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.WriterException;

@Controller
public class QRCodeController {

    @RequestMapping("/services/qrcode/text2qrcode.do")
    public void text2QRCode(@RequestParam("width") int width,
            @RequestParam("height") int height,
            @RequestParam("memId") String memId,
            @RequestParam("date") String date,
            @RequestParam("name") String name,
            @RequestParam("money") String money,
            HttpServletResponse response)
            throws IOException, WriterException {
    	
    	String json = String.format("{"
    			+ "이름 : %s,"
    			+ "날짜 : %s,"
    			+ "이용권 : %s,"
    			+ "포켓코인 : %s"
    			+ "}", memId,date,name,money); 
    	
        ServletOutputStream sos = response.getOutputStream();
        QRCodeUtils.text2QRCode(json, width, height, sos);
        sos.flush();
        sos.close();
    }

}
