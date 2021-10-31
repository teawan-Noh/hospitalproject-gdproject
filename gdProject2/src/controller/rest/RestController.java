package controller.rest;

import java.io.IOException;
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
import dao.rest.RestDao;
import dao.rest.RestDaoImpl;
import model.ask.Rest;

@WebServlet(name = "RestController", urlPatterns={"/rest","/rest_input", "/schedule_check", "/dschedule", "/chkrsv"})
public class RestController  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 247398011074809924L;

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
	
		
		if(action.equals("rest")) {
			HttpSession session = req.getSession();
			int dcode = (int)session.getAttribute("dcode");
			RestDao dao = new RestDaoImpl();
			
			req.setAttribute("side", "task");
			req.setAttribute("dcode", dcode);
		} else if(action.equals("rest_input")) {
			String date = req.getParameter("date");
			System.out.println(date);
			String reason = req.getParameter("reason");
			//System.out.println(reason);
			HttpSession session = req.getSession();
			int dcode = (int)session.getAttribute("dcode");
			Rest rest = new Rest(dcode, reason, date);
			RestDao dao = new RestDaoImpl();
			dao.insert(rest);
			req.setAttribute("side", "task");
		} else if(action.equals("schedule_check")) {
			HttpSession session = req.getSession();
			int dcode = (int)session.getAttribute("dcode");
			RestDao dao = new RestDaoImpl();
			List<Rest> waitList = dao.selectRestBydcode("대기", dcode);
			req.setAttribute("waitList", waitList);
			List<Rest> restList = dao.selectRestBydcode("승인", dcode);
			req.setAttribute("restList", restList);
			List<Rest> denList = dao.selectRestBydcode("거절", dcode);
			req.setAttribute("denList", denList);
			req.setAttribute("side", "task");
		} else if(action.equals("dschedule")) {
			ReservationDao rdao = new ReservationDaoImpl();
			RestDao dao = new RestDaoImpl();
			HttpSession session = req.getSession();
			int dcode = (int)session.getAttribute("dcode");
			List<Map<String, String>> scheduleList = rdao.selectScheduleByDcode(dcode);
			List<Rest> waitList = dao.selectRestBydcode("대기", dcode);
			req.setAttribute("waitList", waitList);
			List<Rest> denList = dao.selectRestBydcode("거절", dcode);
			req.setAttribute("denList", denList);
			
			req.setAttribute("scheduleList", scheduleList);	
		} 
		
		String dispatcherUrl = null;
		if(action.equals("rest")) {
			dispatcherUrl = "jsp/doctor/doctorRest.jsp";
		} else if(action.equals("rest_input")) {
			dispatcherUrl = "rest";
		} else if(action.equals("schedule_check")) {
			dispatcherUrl = "jsp/doctor/doctorSchedule.jsp";
		} else if(action.equals("dschedule")) {
			dispatcherUrl = "ajax/restapproval.jsp";
		} 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
