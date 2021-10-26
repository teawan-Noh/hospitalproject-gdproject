package controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import page.PageDao;
import page.PageDaoImpl;
import page.PageGroupResult;
import page.PageManager;
import dao.ReservationDao;
import dao.ReservationDaoImpl;
import dao.Sql;


@WebServlet(name="ReservationController", 
urlPatterns= {"/reservation", "/subject-doctor", "/schedule", 
		"/doctor-detail", "/rsv-time", "/book", "/reservation-list",
		"/reservation-detail", "/reservation-doctor-list"})
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
		
		int pcode = 2; // req.getParameter("pcode");
		
		req.setAttribute("pcode", pcode);
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
		int dcode = Integer.parseInt(req.getParameter("dcode"));
		List<Map<String, String>> scheduleList = rdao.selectScheduleByDcode(dcode);
		
		for(Map<String, String> m: scheduleList) {
			for(String key: m.keySet()) {
				
				System.out.println(String.format("虐 : %s, 蔼 : %s", key, m.get(key)));
			}
		}
		
		req.setAttribute("scheduleList", scheduleList);
		
	}
	else if(action.equals("rsv-time")) {
		ReservationDao rdao = new ReservationDaoImpl();
		int dcode = Integer.parseInt(req.getParameter("dcode"));
		String rsvdate = req.getParameter("rsvdate");
		
		List<Reservation> rsvList = rdao.selectReservationByDcodeAndRsvDate(dcode, rsvdate);
		List<String> availableList = new ArrayList<String>();
		
		for(Reservation rsv: rsvList) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date date = sdf.parse(rsv.getRsvdate());
				String time = String.format("%02d", date.getHours()) + ":" + String.format("%02d", date.getMinutes());
				availableList.add(time);
			} catch (ParseException e) {
				// TODO 磊悼 积己等 catch 喉废
				e.printStackTrace();
			}
		}
		req.setAttribute("rsvList", availableList);
		
	}
	else if(action.equals("book")) {
		ReservationDao rdao = new ReservationDaoImpl();
		
		int pcode = Integer.parseInt(req.getParameter("pcode"));
		int dcode = Integer.parseInt(req.getParameter("dcode"));
		String rsvdate = req.getParameter("rsvdate");
		
		System.out.println(pcode);
		System.out.println(dcode);
		System.out.println(rsvdate);
		
		int cnt = rdao.insertReservation(pcode, dcode, rsvdate);
		res.getWriter().print(cnt);
	}
	else if(action.equals("reservation-list")) {
		String termStr= req.getParameter("term");
		if(termStr == null) {
			termStr = "-9999";
		}
		int term = Integer.parseInt(termStr);


		int requestPage = Integer.parseInt(req.getParameter("reqPage"));

		ReservationDao rdao = new ReservationDaoImpl();
		PageDao pdao = new PageDaoImpl();

		int pcode = 2; // req.getParameter("pcode");
		
		List<Map<String, String>> rsvList = rdao.selectReservationPage(pcode, requestPage);
		int cnt = pdao.getCount(pcode);
		
		PageManager pm = new PageManager(requestPage);
		PageGroupResult pgr = pm.getPageGroupResult(cnt);
		
		req.setAttribute("pageGroupResult", pgr);
		
		req.setAttribute("rsvList", rsvList);
		req.setAttribute("side", "reservation");
		
	}
	else if(action.equals("reservation-detail")) {
		ReservationDao rdao = new ReservationDaoImpl();
		int rcode = Integer.parseInt(req.getParameter("rcode"));
		Map<String, String> rsvInfo = rdao.selectReservationByRcode(rcode);

		System.out.println(rsvInfo.get("pname"));
		
		req.setAttribute("side", "reservation");
		req.setAttribute("rsvInfo", rsvInfo);
	}
	else if(action.equals("reservation-doctor-list")) {
		String termStr= req.getParameter("term");
		if(termStr == null) {
			termStr = "-9999";
		}
		int term = Integer.parseInt(termStr);


		int requestPage = Integer.parseInt(req.getParameter("reqPage"));

		ReservationDao rdao = new ReservationDaoImpl();
		PageDao pdao = new PageDaoImpl();

		int dcode = 1; // req.getParameter("pcode");
		
		List<Map<String, String>> rsvList = rdao.selectReservationByDcodePage(dcode, requestPage);
		int cnt = pdao.getCount(dcode);
		
		PageManager pm = new PageManager(requestPage);
		PageGroupResult pgr = pm.getPageGroupResult(cnt);
		
		req.setAttribute("pageGroupResult", pgr);
		
		req.setAttribute("rsvList", rsvList);
		req.setAttribute("side", "task");
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
	else if(action.equals("rsv-time")) {
		dispatcherUrl = "ajax/rsv-time.jsp";
	}
	else if(action.equals("book")) {
	}
	else if(action.equals("reservation-list")) {
		dispatcherUrl = "pages/reservation-list.jsp";
	}
	else if(action.equals("reservation-detail")) {
		dispatcherUrl = "pages/reservation-detail.jsp";
	}
	else if(action.equals("reservation-doctor-list")) {
		dispatcherUrl = "pages/reservation-doctor-list.jsp";
	}
	
	
	if(dispatcherUrl != null) {
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, res);
	}
}
}

