package controller;

import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import dao.ReservationDao;
import dao.ReservationDaoImpl;


@WebServlet(name="ReservationController", 
urlPatterns= {"/reservation", "/subject-doctor", "/schedule", "/doctor-detail"})
public class ReservationController extends HttpServlet{

private static final long serialVersionUID = -3121213149759544408L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	process(req, res);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	process(req, res);
}

private void process(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	res.setCharacterEncoding("UTF-8");
	
	String uri = req.getRequestURI();
	int lastIndex = uri.lastIndexOf("/");
	String action = uri.substring(lastIndex + 1);
	System.out.println(action);
	
	// 肺流 贸府
	if(action.equals("reservation")) {
		ReservationDao rdao = new ReservationDaoImpl();
		List<Subject> subjectList = rdao.selectSubjectAll();
		
		req.setAttribute("side", "reservation");
		req.setAttribute("subjectList", subjectList);
	}
	else if(action.equals("subject-doctor")) {
		ReservationDao rdao = new ReservationDaoImpl();
		String subject = req.getParameter("subject");
		List<Doctor> doctorList = rdao.selectDoctorWithSubject(subject);
		
		req.setAttribute("doctorList", doctorList);
		req.setAttribute("subject", subject);
	}
	else if(action.equals("doctor-detail")) {
		int dcode = Integer.parseInt(req.getParameter("dcode"));
		
		
		ReservationDao rdao = new ReservationDaoImpl();
		req.setAttribute("side", "doctor");
		
	}
	else if(action.equals("schedule")) {
		ReservationDao rdao = new ReservationDaoImpl();
		
	}
	
	// 其捞瘤 贸府
	String dispatcherUrl = null;
	
	if(action.equals("reservation")) {
		dispatcherUrl = "pages/reservation.jsp";
	}
	else if(action.equals("subject-doctor")) {
		dispatcherUrl = "ajax/subject-doctor.jsp";
	}
	else if(action.equals("doctor-detail")) {
		dispatcherUrl = "pages/doctor-detail.jsp";
	}
	else if(action.equals("schedule")) {
		dispatcherUrl = "ajax/schedule.jsp";
	}
	
	
	
	if(dispatcherUrl != null) {
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, res);
	}
}
}

