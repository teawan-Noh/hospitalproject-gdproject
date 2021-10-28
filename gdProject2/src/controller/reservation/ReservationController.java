package controller.reservation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.page.PageDao;
import common.page.PageDaoImpl;
import common.page.PageGroupResult;
import common.page.PageManager;
import dao.ask.ReservationDao;
import dao.ask.ReservationDaoImpl;
import model.ask.Reservation;

import model.user.Doctor;
import model.user.Subject;


@WebServlet(name="ReservationController", 
urlPatterns= {"/reservation", "/subject-doctor", "/schedule", 
		"/doctor-detail", "/rsv-time", "/book", "/reservation-list",
		"/reservation-detail", "/reservation-doctor-list",
		"/reservation-delete", "/reservation-update"})
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
		HttpSession session = req.getSession();
		Object pcodeObj = session.getAttribute("pcode");
		Object dcodeObj = session.getAttribute("dcode");

		int sessionPcode = pcodeObj == null ? 0 : Integer.parseInt(pcodeObj.toString());
		int sessionDcode = dcodeObj == null ? 0 : Integer.parseInt(dcodeObj.toString());
		
		// 로직 처리
		// 환자로 로그인
		// reservation, book, reservation-list, reservation-delete, reservation-update
		if(action.equals("reservation-detail")) {
			String user = req.getParameter("user");
			ReservationDao rdao = new ReservationDaoImpl();
			int rcode = Integer.parseInt(req.getParameter("rcode"));
			Map<String, String> rsvInfo = rdao.selectReservationByRcode(rcode);
	
			System.out.println(rsvInfo.get("pname"));
			if(user != null) {
				req.setAttribute("side", "task");
			}
			else {
				req.setAttribute("side", "reservation");
			}
			req.setAttribute("rsvInfo", rsvInfo);
		}
		else if(sessionPcode != 0) {
			if(action.equals("reservation")) {
				ReservationDao rdao = new ReservationDaoImpl();
				List<Subject> subjectList = rdao.selectSubjectAll();
				
				int pcode = sessionPcode; // req.getParameter("pcode");
				int rcode = req.getParameter("rcode") == null ? 0 : Integer.parseInt(req.getParameter("rcode"));


				String url = this.getClass().getResource("").getPath(); 
				url = url.substring(1,url.indexOf(".metadata"))+"gdProject2/WebContent";
				System.out.println(url);
				System.out.println(rcode);
				
				String subject = req.getParameter("subject");
				int dcode = req.getParameter("dcode") == null ? 0 : Integer.parseInt(req.getParameter("dcode"));
				String dname = req.getParameter("dname");
		
				req.setAttribute("pcode", pcode);
				req.setAttribute("rcode", rcode);
				req.setAttribute("subject", subject);
				req.setAttribute("dcode", dcode);
				req.setAttribute("dname", dname);
		
				
				req.setAttribute("side", "reservation");
				req.setAttribute("subjectList", subjectList);
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
				int requestPage = Integer.parseInt(req.getParameter("reqPage"));
		
				ReservationDao rdao = new ReservationDaoImpl();
				PageDao pdao = new PageDaoImpl();
		
				int pcode = sessionPcode; // req.getParameter("pcode");
				
				List<Map<String, String>> rsvList = rdao.selectReservationPage(pcode, requestPage);
				int cnt = pdao.getCountPatient(pcode);
				
				PageManager pm = new PageManager(requestPage);
				PageGroupResult pgr = pm.getPageGroupResult(cnt);
				
				req.setAttribute("pageGroupResult", pgr);
				
				req.setAttribute("rsvList", rsvList);
				req.setAttribute("side", "reservation");
			}
			else if(action.equals("reservation-delete")) {
				ReservationDao rdao = new ReservationDaoImpl();
				int rcode = Integer.parseInt(req.getParameter("rcode"));
				
				rdao.deleteReservation(rcode);
			}
			else if(action.equals("reservation-update")) {
				ReservationDao rdao = new ReservationDaoImpl();
				int rcode = Integer.parseInt(req.getParameter("rcode"));
				int pcode = Integer.parseInt(req.getParameter("pcode"));
				int dcode = Integer.parseInt(req.getParameter("dcode"));
				String rsvdate = req.getParameter("rsvdate");
				
				rdao.updateReservation(rcode, pcode, dcode, rsvdate);
				req.setAttribute("rcode", rcode);
			}
			else if(action.equals("subject-doctor")) {
				ReservationDao rdao = new ReservationDaoImpl();
				String subject = req.getParameter("subject");
				List<Doctor> doctorList = rdao.selectDoctorWithSubject(subject);
				
				req.setAttribute("doctorList", doctorList);
				req.setAttribute("subject", subject);
			}
			else if(action.equals("schedule")) {
				ReservationDao rdao = new ReservationDaoImpl();
				int dcode = Integer.parseInt(req.getParameter("dcode"));
				List<Map<String, String>> scheduleList = rdao.selectScheduleByDcode(dcode);
				
				for(Map<String, String> m: scheduleList) {
					for(String key: m.keySet()) {
						
						System.out.println(String.format("키 : %s, 값 : %s", key, m.get(key)));
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
						// TODO 자동 생성된 catch 블록
						e.printStackTrace();
					}
				}
				req.setAttribute("rsvList", availableList);
				
			}
			
		}
		// 의사 로그인 필요
		else if(sessionDcode != 0) {
		
			if(action.equals("reservation-doctor-list")) {
				int requestPage = Integer.parseInt(req.getParameter("reqPage"));
				String rsvdate = req.getParameter("rsvdate");
		
				ReservationDao rdao = new ReservationDaoImpl();
				PageDao pdao = new PageDaoImpl();
		
				int dcode = 1; // req.getParameter("pcode");
				List<Map<String, String>> rsvList = null;
				PageManager pm = new PageManager(requestPage);
				PageGroupResult pgr = null;
				if(rsvdate == null) {
					rsvList = rdao.selectReservationByDcodePage(dcode, requestPage);
					int cnt = pdao.getCountDoctor(dcode);
					
					pgr = pm.getPageGroupResult(cnt);
				}
				else {
					rsvList = rdao.selectReservationByDcodeRsvdatePage(dcode, requestPage, rsvdate);
					int cnt = pdao.getCountDoctorRsvdate(dcode, rsvdate);
					
					pgr = pm.getPageGroupResult(cnt);
				}
				req.setAttribute("pageGroupResult", pgr);
				
				req.setAttribute("rsvList", rsvList);
				req.setAttribute("side", "task");
			}
			
		}
		
		// 페이지 처리
		String dispatcherUrl = null;
		// reservation, book, reservation-list, reservation-delete, reservation-update

		if(sessionPcode != 0 && sessionDcode == 0) {
			if(action.equals("reservation")) {
				dispatcherUrl = "jsp/reservation/reservation.jsp";
			}
			else if(action.equals("book")) {
			}
			else if(action.equals("reservation-list")) {
				dispatcherUrl = "jsp/reservation/reservation-list.jsp";
			}

			else if(action.equals("reservation-delete")) {
				res.sendRedirect("reservation-list?reqPage=1");
			}
			else if(action.equals("reservation-update")) {
				dispatcherUrl = "reservation-detail";
			}
			else if(action.equals("subject-doctor")) {
				dispatcherUrl = "ajax/subject-doctor.jsp";
			}

			else if(action.equals("schedule")) {
				dispatcherUrl = "ajax/schedule.jsp";
			}
			else if(action.equals("rsv-time")) {
				dispatcherUrl = "ajax/rsv-time.jsp";
			}
		}
		else{
			dispatcherUrl = "patient_login_input";
		}
		
		if(action.equals("reservation-detail")) {
			dispatcherUrl = "jsp/reservation/reservation-detail.jsp";
		}
		
		if(action.equals("reservation-doctor-list")) {
			if(sessionDcode != 0 && sessionPcode == 0) {
				dispatcherUrl = "jsp/reservation/reservation-doctor-list.jsp";
			}
			else {
				dispatcherUrl = "doctor_login_input";
			}
		}
		
		
		
		
		
		if(dispatcherUrl != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
			dispatcher.forward(req, res);
		}
	}
}

