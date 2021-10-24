package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoctorDao;
import dao.DoctorDaoImpl;
import dao.ReservationDao;
import dao.ReservationDaoImpl;
import model.Doctor;
import model.Subject;

@WebServlet(name = "DoctorController", urlPatterns = {"/doctor_input", "/doctor_save", "/didcheck"})
public class DoctorController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req, resp);
	}
	
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		if(action.equals("doctor_input")) {
			ReservationDao dao = new ReservationDaoImpl();
			List<Subject> subjectList = dao.selectSubjectAll();
			req.setAttribute("subjectList", subjectList);
		} else if(action.equals("didcheck")) {
			String id = req.getParameter("id_value");
			DoctorDao dao = new DoctorDaoImpl();
			int cnt = dao.selectCntById(id);
			
			if(cnt > 0) {
				req.setAttribute("useTF", false);
			}else {
				req.setAttribute("useTF", true);
			}
		} else if(action.equals("doctor_save")) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String birth = req.getParameter("birth");
			String career = req.getParameter("career");
			int scode = Integer.parseInt(req.getParameter("selectsubject"));
			int licenseno = Integer.parseInt(req.getParameter("licenseno"));
			int postcode = Integer.parseInt(req.getParameter("postcode"));
			String address = req.getParameter("address");
			String address2 = req.getParameter("address2");
			String email = req.getParameter("email");
			String tel = req.getParameter("tel");
			
			//System.out.println(id +" " + pwd +" " + name +" " + birth +" " + scode +" " + licenseno +" " + postcode +" " + address +" " + address2 +" " + email +" " + tel );
			DoctorDao dao = new DoctorDaoImpl();
			Doctor doctor = new Doctor(scode, id, pwd, name, birth, licenseno, postcode, address, address2, career, tel, email);
			dao.insert(doctor);
		}
		
		String dispatcherUrl = null;
		if(action.equals("doctor_input")) {
			dispatcherUrl = "inputDoctor.jsp";
		} else if(action.equals("didcheck")) {
			dispatcherUrl="/ajax/idcheck.jsp";
		} else if(action.equals("doctor_save")) {
			dispatcherUrl = "doctor_input";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
