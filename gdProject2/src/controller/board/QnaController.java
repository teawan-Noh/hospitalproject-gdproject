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

import dao.board.QnaDao;
import dao.board.QnaDaoImpl;
import model.board.Comments;
import model.board.Qna;
import validator.QnaError;
import validator.QnaValidator;

@WebServlet(name="QnaController", 
	urlPatterns= {"/qna_list", "/qna_input", "/qna_save", "/qna_search", "/qna_detail", "/qna_modify", "/qna_update", "/qna_delete"
					,"/comment_save"})
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
			
			QnaDao dao = new QnaDaoImpl();
			List<HashMap> qnaList = dao.selectAll();
			req.setAttribute("qnaList", qnaList);
			
			HttpSession session = req.getSession();
			if(session.getAttribute("pcode") != null) {
				Object value = session.getAttribute("pcode");
				int pcode = (int)value;
				
				req.setAttribute("pcode", pcode);
				System.out.println(pcode + "list에서 확인");
			}
		}
		else if(action.equals("qna_input")) {
			
//			HttpSession session = req.getSession();
//			Object value = session.getAttribute("pcode");
//			int pcodeValue = (int)value;
//			int pcode = pcodeValue;
//			
//			req.setAttribute("pcode", pcode);
		}
		else if(action.equals("qna_save")) {
			
			HttpSession session = req.getSession();
			Object value = session.getAttribute("pcode");
			
			int pcode = (int)value;
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String img = null; //파일업로드 구현필요
			
			Qna qna = new Qna(pcode, title, content, img); 
			QnaDao dao = new QnaDaoImpl();
			dao.insert(qna);
//			Qna qnaForm = new Qna(pcode, title, content, img); 
			
			//체크
//			QnaValidator validator = new QnaValidator();
//			QnaError qnaErrors = validator.validate(qnaForm);//v2
//
//			if(!qnaErrors.isResult()) {//v2
//				Qna qna = new Qna();
//				qna.setTitle(qnaForm.getTitle());
//				qna.setContent(qnaForm.getContent());
//				
//				QnaDao dao = new QnaDaoImpl();
//				dao.insert(qna);
//				
//				req.setAttribute("message", "잘 저장되었습니다.");
//			}
//			else {
//				req.setAttribute("qnaErrors", qnaErrors);//v2
//				req.setAttribute("qnaForm", qnaForm);
//			}
			
			List<HashMap> qnaList = dao.selectAll();
			req.setAttribute("qnaList", qnaList);
		}
		else if(action.equals("qna_search")) {
			
			QnaDao dao = new QnaDaoImpl();
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			if(searchType.equals("nickname")) {
				List<HashMap> qnaList = dao.selectByNickname(searchValue);
				req.setAttribute("qnaList", qnaList);
			}
			else if((searchType.equals("titleContent"))) {
				List<HashMap> qnaList = dao.selectByTitleOrContent(searchValue);
				req.setAttribute("qnaList", qnaList);
			}
			else {
				List<HashMap> qnaList = dao.selectAll();
				req.setAttribute("qnaList", qnaList);
			}
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
			
			int qno = Integer.parseInt(req.getParameter("qno")); //화면에서 가져와
			QnaDao dao = new QnaDaoImpl();
			dao.delete(qno);
			
			List<HashMap> qnaList = dao.selectAll();
			
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
		else if(action.equals("qna_search")) {
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
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
