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
import javax.servlet.http.HttpSession;

import common.Sql;
import common.page.PageDao;
import common.page.PageDaoImpl;
import common.page.PageGroupResult;
import common.page.PageManager;
import dao.board.QnaDao;
import dao.board.QnaDaoImpl;
import model.board.Comments;
import model.board.Qna;
import validator.QnaError;
import validator.QnaValidator;

@WebServlet(name="QnaController", 
	urlPatterns= {"/qna_list", "/qna_input", "/qna_save", "/qna_detail", "/qna_modify", "/qna_update", "/qna_delete"
					,"/comment_save", "/comment_test"})
public class QnaController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		req.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		req.setAttribute("side", "communication");
		
		if(action.equals("qna_list")) {
			
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			String searchValue = req.getParameter("searchType");
			String searchType = req.getParameter("searchValue");
			
			if(req.getParameter("searchValue") == null) {
				QnaDao dao = new QnaDaoImpl();
				List<HashMap> qnaList = dao.selectAll(requestPage);
				
				//총 줄수 가져오기
				PageDao pageDao = new PageDaoImpl();
				int cnt = pageDao.getCountQnaAll(Sql.QNA_COUNT_ALL_SQL);
				System.out.println(cnt);
				//getPageGroupResult(cnt)
				PageManager pm = new PageManager(requestPage);
				PageGroupResult pgr = pm.getPageGroupResult(cnt);

				req.setAttribute("qnaList", qnaList);
				req.setAttribute("pageGroupResult", pgr); //링크 시작넘버, 끝넘버 객체
			}
			else{
				
				QnaDao dao = new QnaDaoImpl();
				searchType = req.getParameter("searchType");
				searchValue = req.getParameter("searchValue");
				
				if(searchType.equals("nickname")) {
					
					//총 줄수 가져오기
					PageDao pageDao = new PageDaoImpl();
					int cnt = pageDao.getCountQnaSearchNickname(searchValue);
					
					//getPageGroupResult(cnt)
					PageManager pm = new PageManager(requestPage);
					PageGroupResult pgr = pm.getPageGroupResult(cnt);
					
					
					List<HashMap> qnaList = dao.selectByNickname(searchValue, requestPage);
					req.setAttribute("qnaList", qnaList);
					req.setAttribute("pageGroupResult", pgr); //링크 시작넘버, 끝넘버 객체
					
					req.setAttribute("searchValue", searchValue);
					req.setAttribute("searchType", searchType);
				}
				else if((searchType.equals("titleContent"))) {
					List<HashMap> qnaList = dao.selectByTitleOrContent(searchValue, requestPage);
					req.setAttribute("qnaList", qnaList);
				}
				else {
					List<HashMap> qnaList = dao.selectAll(requestPage);
					req.setAttribute("qnaList", qnaList);
				}
			}
			
			HttpSession session = req.getSession();
			if(session.getAttribute("pcode") != null) {
				Object value = session.getAttribute("pcode");
				int pcode = (int)value;
				
				req.setAttribute("pcode", pcode);
				System.out.println(pcode + "list에서 확인");
			}
		}
		else if(action.equals("qna_input")) {
			
		}
		else if(action.equals("qna_save")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			
			HttpSession session = req.getSession();
			Object value = session.getAttribute("pcode");
			
			int pcode = (int)value;
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String img = null; //파일업로드 구현필요
			
			QnaDao dao = new QnaDaoImpl();
			Qna qna = new Qna(pcode, title, content, img); 
			dao.insert(qna);
			
			List<HashMap> qnaList = dao.selectAll(requestPage);
			req.setAttribute("qnaList", qnaList);
		}
		else if(action.equals("qna_detail")) {
			HttpSession session = req.getSession();
			
			QnaDao dao = new QnaDaoImpl();
			int qno = Integer.parseInt(req.getParameter("qno")); //화면에서 가져와
			HashMap qnaDetail = dao.selectByQno(qno);
			req.setAttribute("qnadetail", qnaDetail);
			
			if(session.getAttribute("pcode") != null) {
				Object value = session.getAttribute("pcode");
				int pcodeValue= (int)value;
				int pcode = pcodeValue;
				
				System.out.println( pcode + "유저로그인 되있을때 피코드확인");
				req.setAttribute("userpcode", pcode);
			}else if(session.getAttribute("pcode") == null){
				int pcode = 0;
				System.out.println( pcode + "유저로그인 안되있을때 피코드확인");
				req.setAttribute("pcode", pcode);
			}
			if(session.getAttribute("mcode") != null) {
				Object value = session.getAttribute("mcode");
				int mcode = (int)value;
				req.setAttribute("managerpcode", mcode);
			}
			
			Qna qna = dao.selectCntByQno(qno);
			
			int cnt = qna.getCnt()+1;
			
			Qna qna2 = new Qna(qno ,cnt);
			dao.cntUpdate(qna2);
		}
		else if(action.equals("qna_modify")) {
			
			int qno = Integer.parseInt(req.getParameter("qno"));
			QnaDao dao = new QnaDaoImpl();
			
			HashMap qnaDetail = dao.selectByQno(qno);
			req.setAttribute("qnadetail", qnaDetail);
		}
		else if(action.equals("qna_update")) {
			
			int qno = Integer.parseInt(req.getParameter("qno"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String image = req.getParameter("image");
			
			Qna qna = new Qna(title, content, image, qno);
			
			QnaDao dao = new QnaDaoImpl();
			dao.update(qna);
			
			HttpSession session = req.getSession();
			
			HashMap qnaDetail = dao.selectByQno(qno);
			req.setAttribute("qnadetail", qnaDetail);
			
			if(session.getAttribute("pcode") != null) {
				Object value = session.getAttribute("pcode");
				int pcodeValue= (int)value;
				int pcode = pcodeValue;
				
				System.out.println( pcode + "유저로그인 되있을때 피코드확인");
				req.setAttribute("userpcode", pcode);
			}else if(session.getAttribute("pcode") == null){
				int pcode = 0;
				System.out.println( pcode + "유저로그인 안되있을때 피코드확인");
				req.setAttribute("pcode", pcode);
			}
			if(session.getAttribute("mcode") != null) {
				Object value = session.getAttribute("mcode");
				int mcode = (int)value;
				req.setAttribute("managerpcode", mcode);
			}
		}
		else if(action.equals("qna_delete")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			
			int qno = Integer.parseInt(req.getParameter("qno")); //화면에서 가져와
			QnaDao dao = new QnaDaoImpl();
			dao.delete(qno);
			
			List<HashMap> qnaList = dao.selectAll(requestPage);
			
			req.setAttribute("qnaList", qnaList);
			
		}
		else if(action.equals("comment_save")) {
			
			int qno = Integer.parseInt(req.getParameter("qno")); //화면에서 가져와
			HttpSession session = req.getSession();
			if(session.getAttribute("mcode") != null) {
				
				Object value = session.getAttribute("mcode");
				int mcode = (int)value;
				String content = req.getParameter("content");
				
				Comments comment = new Comments(qno, mcode, content);
				
				QnaDao dao = new QnaDaoImpl();
				dao.insertComment(comment);
				
				HashMap qnaDetail = dao.selectByQno(qno);
				req.setAttribute("qnadetail", qnaDetail);
			}
		}
		else if(action.equals("comment_test")) {
			
			String content = req.getParameter("content");
			int mcode = Integer.parseInt(req.getParameter("mcode"));
			int qno = Integer.parseInt(req.getParameter("qno"));
			
			System.out.println(content + ", " + mcode);
			
			Comments comment = new Comments(qno, mcode, content);
			
			QnaDao dao = new QnaDaoImpl();
			int value = dao.insertComment(comment);
			
			System.out.println(value);
			
			req.setAttribute("result", value);
			req.setAttribute("content", content);
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("qna_list")) {
			dispatcherUrl = "jsp/board/qnaList.jsp";
		}
		else if(action.equals("qna_input")) {
			dispatcherUrl = "jsp/board/qnaInput.jsp";
		}
		else if(action.equals("qna_save")) {
			dispatcherUrl = "jsp/board/qnaList.jsp";
		}
		else if(action.equals("qna_detail")) {
			dispatcherUrl = "jsp/board/qnaDetail.jsp";
		}
		else if(action.equals("qna_modify")) {
			dispatcherUrl = "jsp/board/qnaModify.jsp";
		}
		else if(action.equals("qna_update")) {
			dispatcherUrl = "jsp/board/qnaDetail.jsp";
		}
		else if(action.equals("qna_delete")) {
			dispatcherUrl = "jsp/board/qnaList.jsp"; 
		}
		else if(action.equals("comment_save")) {
			dispatcherUrl = "jsp/board/qnaDetail.jsp";
		}
		else if(action.equals("comment_test")) {
			dispatcherUrl = "ajax/comment2.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
