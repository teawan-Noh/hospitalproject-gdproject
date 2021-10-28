package controller.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.rest.RestDao;
import dao.rest.RestDaoImpl;
import model.ask.Rest;

@WebServlet(name = "RestController", urlPatterns={"/rest","/rest_input", "/schedule_check"})
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
			List<Rest> waitList = dao.selectRestBydcode("���", dcode);
			req.setAttribute("waitList", waitList);
			List<Rest> restList = dao.selectRestBydcode("����", dcode);
			req.setAttribute("restList", restList);
		} else if(action.equals("rest_input")) {
			String date = req.getParameter("date");
			System.out.println(date);
			String reason = req.getParameter("reason");
			System.out.println(reason);
			HttpSession session = req.getSession();
			int dcode = (int)session.getAttribute("dcode");
			String day = req.getParameter("day");
			Rest rest = new Rest(dcode, reason, date, day);
			RestDao dao = new RestDaoImpl();
			dao.insert(rest);
		} else if(action.equals("schedule_check")) {
			HttpSession session = req.getSession();
			int dcode = (int)session.getAttribute("dcode");
			RestDao dao = new RestDaoImpl();
			List<Rest> waitList = dao.selectRestBydcode("���", dcode);
			req.setAttribute("waitList", waitList);
			List<Rest> restList = dao.selectRestBydcode("����", dcode);
			req.setAttribute("restList", restList);
		}
		
		String dispatcherUrl = null;
		if(action.equals("rest")) {
			dispatcherUrl = "jsp/doctor/doctorRest.jsp";
		} else if(action.equals("rest_input")) {
			dispatcherUrl = "rest";
		} else if(action.equals("schedule_check")) {
			dispatcherUrl = "jsp/doctor/doctorSchedule.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
