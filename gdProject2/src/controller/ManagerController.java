package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManagerDao;
import dao.ManagerDaoImpl;
import model.Subject;
import page.PageDao;
import page.PageDaoImpl;
import page.PageGroupResult;
import page.PageManager;
//, "/mg_search_patient", "/mg_approval_list", "mg_approval_detail"
@WebServlet(name="ManagerController", 
	urlPatterns= {"/mg_search_doctor", "/mg_doctor_list", "/mg_doctor_delete"})
public class ManagerController extends HttpServlet{

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
		
		if(action.equals("mg_doctor_list")) {
			
			ManagerDao dao = new ManagerDaoImpl();
			List<Subject> subjectList = dao.selectAll();
			
			req.setAttribute("subjectList", subjectList);
			
		}
			
		if(action.equals("mg_search_doctor")) {
				
			ManagerDao dao = new ManagerDaoImpl();
			List<Subject> subjectList = dao.selectAll();
				
			req.setAttribute("subjectList", subjectList);
				
			String subjectcode = req.getParameter("subject");
			if(subjectcode.equals("list")) {
				int scode = 0;
				
				List<HashMap> doctorList = dao.selectDoctorBySubject(scode);
				req.setAttribute("doctorList", doctorList);
			}
			else {
				req.setAttribute("subject_val", subjectcode);
				int scode = Integer.parseInt(subjectcode);
				
				List<HashMap> doctorList = dao.selectDoctorBySubject(scode);
				req.setAttribute("doctorList", doctorList);
			}
		}
		if(action.equals("mg_doctor_delete")) {
			
			int dcode = Integer.parseInt(req.getParameter("dcode")); //화면에서 가져와
			
			ManagerDao dao = new ManagerDaoImpl();
			dao.deleteDoctor(dcode);
			
			
			List<Subject> subjectList = dao.selectAll();
			
			req.setAttribute("subjectList", subjectList);
		}
		
		else if(action.equals("mg_search_patient")) {
			
//			req.setAttribute("qnaForm", qnaForm);
		}
		else if(action.equals("mg_approval_list")) {
			
//			req.setAttribute("qnaForm", qnaForm);
		}
		else if(action.equals("mg_approval_detail")) {
			
//			req.setAttribute("qnaForm", qnaForm);
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("mg_doctor_list")) {
			dispatcherUrl = "pages/managerDoctorList.jsp";
		}
		else if(action.equals("mg_search_doctor")) {
			
			dispatcherUrl = "pages/managerDoctorList.jsp";
		}
		else if(action.equals("mg_doctor_delete")) {
			
			dispatcherUrl = "pages/managerDoctorList.jsp";
		}
//		else if(action.equals("mg_approval_detail")) {
//			
//			dispatcherUrl = "pages/qnaDetail.jsp";
//		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
