package checkbook;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.tools.databases.BookInfo;
import com.tools.getHtml.GetHtml;
import com.tools.getHtml.QidianHtml;
import com.tools.mail.EMailSSL;


@SuppressWarnings("serial")
public class CheckBookServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
//		System.out.println(req.getParameter("bookID"));
		BookInfo bi=new BookInfo();
		bi.init(req.getParameter("bookID"));
		
		CheckBook cb=new CheckBook();
		bi=cb.check(bi);
		
		
		req.setAttribute("booktitle", bi.getBooktitle());
		req.setAttribute("time", bi.getUpdateTime());
		req.setAttribute("title", bi.getTitle());
		req.setAttribute("txtBody", bi.getTxtBody());
		try {
			req.getRequestDispatcher("check.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	}
}
