package kr.or.ddit.servlet01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/01/imageForm.tmpl")	//web.xml 3.xx
public class ImageFormServlet extends AbstractUseTmplServlet {
	// 톰캣은 서블릿 컨테이너로 서블릿의 life cyle을 관리한다.
	// 즉 ImageFormServlet의 life cyle은 톰캣이 관리한다.

	@Override
	protected void setContentType(HttpServletResponse resp) { // mime을 셋팅
		resp.setContentType("text/html;charset=UTF-8");
	}

	@Override
	protected void makeData(HttpServletRequest req) {
		System.out.println("서블릿이 요청 받았음");

		String folder = "d:/contents";
		File contents = new File(folder);
		String[] children = contents.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				String mime = application.getMimeType(name);
				System.out.println("name : " + name);
				return mime != null && mime.startsWith("image/");
			}

		});

		// 두 매서드를 정의 해 놓으면 AbstractUseTmplServlet의 후크매서드가 이 매서를 꺼내서 쓸 수 있다.

		Date today = new Date();
		req.setAttribute("today", today);

		StringBuffer options = new StringBuffer();
		for (String child : children) {
			options.append(String.format("<option>%s</option>", child));
		}
		req.setAttribute("options", options);
	}
}