package controller.user;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ask.ReservationDao;
import dao.ask.ReservationDaoImpl;
import dao.user.ManagerDao;
import dao.user.ManagerDaoImpl;
import model.user.Patient;
import model.user.Subject;

import common.page.PageDao;
import common.page.PageDaoImpl;
import common.page.PageGroupResult;
import common.page.PageManager;

@WebServlet(name="ManagerController", 
	urlPatterns= {"/mg_doctor_list", "/mg_doctor_search", "/mg_doctor_delete", 
					"/mg_patient_list", "/mg_patient_search", "/mg_rest_list", "/mg_rest_search", "/mg_rest_detail",
					"/mg_rest_approve", "/mg_rest_reject", "/ms_reservation_list"})
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
		
		req.setAttribute("side", "manager");
		
		if(action.equals("mg_doctor_list")) {
			
			ManagerDao dao = new ManagerDaoImpl();
			List<Subject> subjectList = dao.selectSubjectAll();
			
			req.setAttribute("subjectList", subjectList);
		}
		else if(action.equals("mg_doctor_search")) {
				
			ManagerDao dao = new ManagerDaoImpl(); 
			List<Subject> subjectList = dao.selectSubjectAll();
				
			req.setAttribute("subjectList", subjectList);
			
			String subjectcode = req.getParameter("subject");
			if(subjectcode.equals("list")) {
				int scode = 0;
				
				List<HashMap<String, String>> doctorList = dao.selectDoctorBySubject(scode);
				req.setAttribute("doctorList", doctorList);
			}
			else {
				req.setAttribute("subject_val", subjectcode);
				int scode = Integer.parseInt(subjectcode);
				
				List<HashMap<String, String>> doctorList = dao.selectDoctorBySubject(scode);
				req.setAttribute("doctorList", doctorList);
			}
		}
		else if(action.equals("mg_doctor_delete")) {
			
			int dcode = Integer.parseInt(req.getParameter("dcode")); //화면에서 가져와
			
			ManagerDao dao = new ManagerDaoImpl();
			dao.deleteDoctor(dcode);
			
			List<Subject> subjectList = dao.selectSubjectAll();
			
			req.setAttribute("subjectList", subjectList);
		}
		
		else if(action.equals("mg_patient_list")) {
			
			ManagerDao dao = new ManagerDaoImpl();
			List<HashMap<String, String>> patientList = dao.selectPatientAll();
			req.setAttribute("patientList", patientList);
		}
		else if(action.equals("mg_patient_search")) {
			
			String name = req.getParameter("search");
			
			ManagerDao dao = new ManagerDaoImpl();
			
			if(name !=null) {
				List<HashMap<String, String>> patientList = dao.selectPatientByName(name);
				
				req.setAttribute("patientList", patientList);
				System.out.println(patientList);
			}
			else if(name == null) {
				List<HashMap<String, String>> patientList = dao.selectPatientAll();
				req.setAttribute("patientList", patientList);
			}
			
		}
		else if(action.equals("mg_rest_list")) {
			
			ManagerDao dao = new ManagerDaoImpl();
			
			List<HashMap<String, String>> restList = dao.selectRestAll();
			
			req.setAttribute("restList", restList);
		}
		else if(action.equals("mg_rest_search")) {
			
			String name = req.getParameter("search");
			
			ManagerDao dao = new ManagerDaoImpl(); 
			
			if(name !=null) {
				List<HashMap<String, String>> restList = dao.selectRestByName(name);
				req.setAttribute("restList", restList);
			}
			else if(name == null) {
				List<HashMap<String, String>> restList = dao.selectRestAll();
				req.setAttribute("restList", restList);
			}
		}
		else if(action.equals("mg_rest_detail")) {
			
			int rcode = Integer.parseInt(req.getParameter("rcode")); //화면에서 가져와
			ManagerDao dao = new ManagerDaoImpl(); 
			
			HashMap<String, String> restDetail = dao.selectRestByRcode(rcode);
			req.setAttribute("restdetail", restDetail);
		}
		else if(action.equals("mg_rest_approve")) {
			
			int rcode = Integer.parseInt(req.getParameter("rcode")); //화면에서 가져와
			ManagerDao dao = new ManagerDaoImpl(); 
			dao.updateRestApprove(rcode);
			
			List<HashMap<String, String>> restList = dao.selectRestAll();
			
			req.setAttribute("restList", restList);
		}
		else if(action.equals("mg_rest_reject")) {
			
			int rcode = Integer.parseInt(req.getParameter("rcode")); //화면에서 가져와
			ManagerDao dao = new ManagerDaoImpl(); 
			dao.updateRestReject(rcode);
			
			List<HashMap<String, String>> restList = dao.selectRestAll();
			
			req.setAttribute("restList", restList);
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("mg_doctor_list")) {
			dispatcherUrl = "jsp/manager/managerDoctorList.jsp";
		}
		else if(action.equals("mg_doctor_search")) {
			dispatcherUrl = "jsp/manager/managerDoctorList.jsp";
		}
		else if(action.equals("mg_doctor_delete")) {
			dispatcherUrl = "jsp/manager/managerDoctorList.jsp";
		}
		else if(action.equals("mg_patient_list")) {
			
			dispatcherUrl = "jsp/manager/managerPatientList.jsp";
		}
		else if(action.equals("mg_patient_search")) {
			
			dispatcherUrl = "jsp/manager/managerPatientList.jsp";
		}
		else if(action.equals("mg_rest_list")) {
			
			dispatcherUrl = "jsp/manager/managerRestApprovalList.jsp";
		}
		else if(action.equals("mg_rest_search")) {
			
			dispatcherUrl = "jsp/manager/managerRestApprovalList.jsp";
		}
		else if(action.equals("mg_rest_detail")) {
			
			dispatcherUrl = "jsp/manager/managerRestApprovalDetail.jsp";
		}
		else if(action.equals("mg_rest_approve")) {
			
			dispatcherUrl = "jsp/manager/managerRestApprovalList.jsp";
		}
		else if(action.equals("mg_rest_reject")) {
			
			dispatcherUrl = "jsp/manager/managerRestApprovalList.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
