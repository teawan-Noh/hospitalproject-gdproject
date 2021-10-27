package controller.user;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.user.ManagerDao;
import dao.user.ManagerDaoImpl;
import model.user.Patient;
import model.user.Subject;
import common.page.PageDao;
import common.page.PageDaoImpl;
import common.page.PageGroupResult;
import common.page.PageManager;
//, "mg_approval_detail"
@WebServlet(name="ManagerController", 
	urlPatterns= {"/mg_doctor_list", "/mg_doctor_search", "/mg_doctor_delete", 
					"/mg_patient_list", "/mg_patient_search", "/mg_approval_list", "/mg_approval_search"})
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
		else if(action.equals("mg_doctor_delete")) {
			
			int dcode = Integer.parseInt(req.getParameter("dcode")); //화면에서 가져와
			
			ManagerDao dao = new ManagerDaoImpl();
			dao.deleteDoctor(dcode);
			
			
			List<Subject> subjectList = dao.selectSubjectAll();
			
			req.setAttribute("subjectList", subjectList);
			
		}
		
		else if(action.equals("mg_patient_list")) {
			
			ManagerDao dao = new ManagerDaoImpl();
			List<Patient> patientList = dao.selectPatientAll();
			req.setAttribute("patientList", patientList);
		}
		else if(action.equals("mg_patient_search")) {
			
			String name = req.getParameter("search");
			
			ManagerDao dao = new ManagerDaoImpl();
			
			if(name !=null) {
				List<Patient> patientList = dao.selectPatientByName(name);
				req.setAttribute("patientList", patientList);
			}
			else if(name == null) {
				List<Patient> patientList = dao.selectPatientAll();
				req.setAttribute("patientList", patientList);
			}
			
		}
		else if(action.equals("mg_approval_list")) {
			
			ManagerDao dao = new ManagerDaoImpl();
			
			List<HashMap> approvalList = dao.selectApprovalAll();
			
			req.setAttribute("approvalList", approvalList);
		}
		else if(action.equals("mg_approval_search")) {
			
			String name = req.getParameter("search");
			
			ManagerDao dao = new ManagerDaoImpl(); 
			
			if(name !=null) {
				List<HashMap> approvalList = dao.selectApprovalByName(name);
				req.setAttribute("approvalList", approvalList);
			}
			else if(name == null) {
				List<HashMap> approvalList = dao.selectApprovalAll();
				req.setAttribute("approvalList", approvalList);
			}
		}
		else if(action.equals("mg_approval_detail")) {
			
//			req.setAttribute("qnaForm", qnaForm);
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
		else if(action.equals("mg_approval_list")) {
			
			dispatcherUrl = "jsp/manager/managerApprovalList.jsp";
		}
		else if(action.equals("mg_approval_search")) {
			
			dispatcherUrl = "jsp/manager/managerApprovalList.jsp";
		}
//		else if(action.equals("mg_approval_detail")) {
//			
//			dispatcherUrl = "pages/qnaDetail.jsp";
//		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
