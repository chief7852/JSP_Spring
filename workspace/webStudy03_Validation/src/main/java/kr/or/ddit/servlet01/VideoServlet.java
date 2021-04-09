package kr.or.ddit.servlet01;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/01/video.do")
public class VideoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{//파라미터가 안넘어가서 서비스 제공 불가능
			String imageFilename = req.getParameter("video");
			if(imageFilename==null || imageFilename.isEmpty()) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);	//400
				return;
			}
		
			String folder = "d:/contents";
			File imageFile = new File(folder, imageFilename);
			if(!imageFile.exists()) {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND);	//404 [400번대는 클라이언트 잘못!]
				return;
			}
			
			String mime = getServletContext().getMimeType(imageFilename);
			if(mime==null || !mime.startsWith("video/mp4")) {
				resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);	//415
				return;
			}
			resp.setContentType(mime);
	
			FileInputStream fis = new FileInputStream(imageFile);
			//FileInputStream 파일에서 바이트 단위로 입력할 수 있도록 하기위해쓰고
			//데이터를 읽거나 쓸 수 있다.
			//FileInputStream 객체를 생성할 때 데이터를 읽어올 파일을 지정한다.
			OutputStream os = resp.getOutputStream();
			byte[] buffer = new byte[1024];
			int pointer = -1;
			while((pointer = fis.read(buffer))!=-1){
				os.write(buffer, 0, pointer);
			}
					
		}
	
}

