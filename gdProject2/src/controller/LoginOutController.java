package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DoctorDao;
import dao.DoctorDaoImpl;
import dao.PatientDao;
import dao.PatientDaoImpl;
import model.Doctor;
import model.Patient;

@WebServlet(name="LoginOutController", urlPatterns= {"/patient_login_input","/doctor_login_input","/manager_login_input","/patient_login","/doctor_login","/manager_login","/logout"})
//login_input : 로그인 화면, login : 로그인, logout : 로그아웃
public class LoginOutController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		//로직
		if(action.equals("patient_login_input")) {
			
		}else if(action.equals("doctor_login_input")) {
		
		}else if(action.equals("manager_login_input")) {
			
		}else if(action.equals("patient_login")) {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			PatientDao dao = new PatientDaoImpl();
			Patient p = dao.login(id, pw);
			
			if(p != null) {
				HttpSession session = req.getSession();
				session.setAttribute("pcode", p.getPcode());
				int pcode = (int)session.getAttribute("pcode");
				PatientDao pdao = new PatientDaoImpl();
				Patient patient = pdao.selectByPcode(pcode);
				req.setAttribute("patient", patient);
			}else {
				req.setAttribute("message", "존재하지 않는 아이디거나 비밀번호가 일치하지 않습니다.");
			}
			
		}else if(action.equals("doctor_login")) {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			DoctorDao dao = new DoctorDaoImpl();
			Doctor d = dao.login(id, pw);
			
			if(d != null) {
				HttpSession session = req.getSession();
				session.setAttribute("dcode", d.getDcode());
				int dcode = (int)session.getAttribute("dcode");
				DoctorDao ddao = new DoctorDaoImpl();
				Doctor doctor = ddao.selectByDcode(dcode);
				req.setAttribute("patient", doctor);
			}else {
				req.setAttribute("message", "존재하지 않는 아이디거나 비밀번호가 일치하지 않습니다.");
			}
			
			
		}else if(action.equals("logout")) {
			HttpSession session = req.getSession();
			
			session.removeAttribute("pcode");
			session.removeAttribute("dcode");
		}
		
		//페이지
		String dispatcherUrl = null;
		if(action.equals("patient_login_input")) {
			dispatcherUrl="/patient/patientLogin.jsp";
			
		}else if(action.equals("doctor_login_input")) {
			dispatcherUrl="doctor/doctorLogin.jsp";
			
		}else if(action.equals("manager_login_input")) {
			dispatcherUrl="manager/managerLogin.jsp";
			
		}else if(action.equals("patient_login")) {
			
			HttpSession session = req.getSession();
			if(session.getAttribute("pcode")!=null) {
				dispatcherUrl="/index.jsp";
			}else {
				dispatcherUrl="/patient/patientLogin.jsp";
			}
			
			
		}else if(action.equals("doctor_login")) {
			
			HttpSession session = req.getSession();
			if(session.getAttribute("dcode")!=null) {
				dispatcherUrl="/index.jsp";
			}else {
				dispatcherUrl="/doctor/doctorLogin.jsp";
			}
			
		}else if(action.equals("logout")) {
			dispatcherUrl="/index.jsp";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
