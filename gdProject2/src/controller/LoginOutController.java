package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginOutController", urlPatterns= {"/patient_login_input","/doctor_login_input","/manager_login_input","/login","/logout"})
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
			
		}else if(action.equals("login")) {
			
		}else if(action.equals("logout")) {
			
		}
		
		//페이지
		String dispatcherUrl = null;
		if(action.equals("patient_login_input")) {
			dispatcherUrl="/patient/patientLogin.jsp";
		}else if(action.equals("doctor_login_input")) {
			dispatcherUrl="doctor/doctorLogin.jsp";
		}else if(action.equals("manager_login_input")) {
			dispatcherUrl="manager/managerLogin.jsp";
		}else if(action.equals("login")) {
			dispatcherUrl="";
		}else if(action.equals("logout")) {
			dispatcherUrl="/index.jsp";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
