package controller.board;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="NoticeController", urlPatterns= {"/notice_list","/private/notice_input","/private/notice_save","/notice_detail","/notice_update","/notice_delete","/notice_search"})
public class NoticeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		process(req,resp);

	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		//로직
		if(action.equals("notice_list")) {
			
		}else if(action.equals("notice_input")) {
			
			
			
		}else if(action.equals("notice_detail")) {
			
			
			
		}else if(action.equals("notice_save")) {
			

		}else if(action.equals("notice_update")) {
			

		}else if(action.equals("notice_delete")) {
			
		}else if(action.equals("bbs_search")) {
			
		}else if(action.equals("bbs_updateResult")) {
			
		}
		
		//페이지
		String dispatcherUrl = null;
		if(action.equals("notice_list")) {
			dispatcherUrl="/pages/noticeList.jsp";
		}else if(action.equals("notice_input")) {
			dispatcherUrl="";
		}else if(action.equals("notice_detail")) {
			dispatcherUrl="";
		}else if(action.equals("notice_save")) {
			dispatcherUrl="";
		}else if(action.equals("notice_update")) {
			dispatcherUrl="";
		}else if(action.equals("notice_delete")) {
			dispatcherUrl="";
		}else if(action.equals("notice_search")) {
			dispatcherUrl="";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}

}
