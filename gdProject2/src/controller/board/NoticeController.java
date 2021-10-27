package controller.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Sql;
import common.page.PageDao;
import common.page.PageDaoImpl;
import common.page.PageGroupResult;
import common.page.PageManager;
import dao.board.NoticeDao;
import dao.board.NoticeDaoImpl;

@WebServlet(name="NoticeController", urlPatterns= {"/notice_list","/manager/notice_input","/manager/notice_save","/notice_detail","/notice_update","/notice_delete","/notice_search"})
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
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			System.out.println(requestPage);
			
			NoticeDao dao = new NoticeDaoImpl();
			List<HashMap<String,Object>> list = dao.selectAll(requestPage);
			
			//총 줄수 가져오기
			PageDao pdao = new PageDaoImpl();
			int line = pdao.getCountNotice(Sql.NOTICE_COUNT_SQL);
			
			//getPageGroupResult() 불러오기
			PageManager manager = new PageManager(requestPage);
			PageGroupResult pgr =  manager.getPageGroupResult(line);
			
			req.setAttribute("noticeList", list);
			req.setAttribute("pageGroupResult", pgr);
			
			
			
		}else if(action.equals("notice_input")) {
			
			
			
		}else if(action.equals("notice_detail")) {
			int ncode = Integer.parseInt(req.getParameter("ncode"));
			NoticeDao dao = new NoticeDaoImpl();
			List<HashMap<String,Object>> detail = dao.selectByNcode(ncode);
			req.setAttribute("detail", detail);
			
			
		}else if(action.equals("notice_save")) {
			

		}else if(action.equals("notice_update")) {
			

		}else if(action.equals("notice_delete")) {
			
		}else if(action.equals("notice_search")) {
			
			
		}
		
		//페이지
		String dispatcherUrl = null;
		if(action.equals("notice_list")) {
			dispatcherUrl="/jsp/board/noticeList.jsp";
		}else if(action.equals("notice_input")) {
			dispatcherUrl="";
		}else if(action.equals("notice_detail")) {
			dispatcherUrl="/jsp/board/noticeDetail.jsp";
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
