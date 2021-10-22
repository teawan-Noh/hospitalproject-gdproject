package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDao;
import dao.PatientDaoImpl;
import model.Patient;


@WebServlet(name="PatientController", urlPatterns= {"/patient_input","/idcheck","/patient_save"})
//patient_input : 회원가입 화면, idcheck : 중복체크, patient_save : 저장
public class PatientController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		//로직
		if(action.equals("patient_input")) {
			
			
		}else if(action.equals("idcheck")) {
			String id = req.getParameter("id_value");
			PatientDao dao = new PatientDaoImpl();
			int cnt = dao.selectCntById(id);
			
			if(cnt>0) {
				req.setAttribute("useTF", false);
			}else {
				req.setAttribute("useTF", true);
			}
			
		}else if(action.equals("patient_save")) {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String nickName = req.getParameter("nickName");
			String name = req.getParameter("name");
			String tel = req.getParameter("tel");
			String birth = req.getParameter("birth");
			String gender = req.getParameter("gender");
			String email = req.getParameter("email");
			int postcode = Integer.parseInt(req.getParameter("postcode"));
			String address = req.getParameter("address");
			String address2 = req.getParameter("address2");
			
			Patient patient = new Patient(id,pw,nickName,name,tel,birth,gender,email,postcode,address,address2);
			req.setAttribute("patient", patient);
			PatientDao dao = new PatientDaoImpl();
			dao.insert(patient);
		}
		
		
		//페이지
		String dispatcherUrl = null;
		if(action.equals("patient_input")) {
			dispatcherUrl="/patient/join.jsp";
		}else if(action.equals("idcheck")) {
			dispatcherUrl="/ajax/idcheck.jsp";
		}else if(action.equals("patient_save")) {
			dispatcherUrl="index.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
