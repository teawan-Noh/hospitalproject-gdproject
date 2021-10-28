package controller.reservation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.page.PageDao;
import common.page.PageDaoImpl;
import common.page.PageGroupResult;
import common.page.PageManager;
import dao.ask.ReservationDao;
import dao.ask.ReservationDaoImpl;
import model.ask.Reservation;

import model.user.Doctor;
import model.user.Subject;


@WebServlet(name="TestController", 
urlPatterns= {"/test", "/upload", "/download"})
@MultipartConfig
public class TestController extends HttpServlet{
	
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

		String UPLOAD_DIR = "upload";

		
		if(action.equals("test")) {
			System.out.println(req.getContextPath());
		}
		else if(action.equals("upload")) {
			// 서버의 실제 경로
			String applicationPath = req.getServletContext().getRealPath("");
			String uploadFilePath = applicationPath + UPLOAD_DIR;
			
			System.out.println(" LOG :: [서버 루트 경로] :: " + applicationPath);
			System.out.println(" LOG :: [파일 저장 경로] :: " + uploadFilePath);
			
			// creates the save directory if it does not exists
			File fileSaveDir = new File(uploadFilePath);
			
			// 파일 경로 없으면 생성
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdirs();
			}

	        String fileName = null;
	        //Get all the parts from request and write it to the file on server
	        for (Part part : req.getParts()) {
	        	getPartConfig(part);
	            fileName = getFileName(part);
	            System.out.println(" LOG :: [ 업로드 파일 경로 ] :: " + uploadFilePath + File.separator + fileName);
	            part.write(uploadFilePath + File.separator + fileName);
	        }
	        req.setAttribute("fileName", fileName);
			//1. 유일한 파일이름을 만든다.
			//2. db에 정보를 저장한다.
			//3. 유일한 이름으로 파일서버에 파일을 저장한다.
			//db : 작성자, 작성시간, 오리지널 파일이름, 유일한 파일이름(timestamp), 파일사이즈(part.getSize()) 등 저장
		}
		else if(action.equals("download")) {
			String fileName = req.getParameter("fileName");
			
			// 서버에 올라간 경로를 가져옴
			ServletContext context = getServletContext();
			String uploadFilePath = context.getRealPath(UPLOAD_DIR);
			String filePath = uploadFilePath + File.separator + fileName;
			
			res.setContentType("image/jpeg");
			byte[] image = IOUtils.toByteArray(new FileInputStream(new File(filePath)));
			res.getOutputStream().write(image);
		}
		
		
		
		
		
		// 페이지 처리
		String dispatcherUrl = null;
		// reservation, book, reservation-list, reservation-delete, reservation-update

		
		if(action.equals("test")){
			dispatcherUrl = "jsp/test/test.jsp";
		}	
		else if(action.equals("download")) {
			
		}
		
		
		
		
		if(dispatcherUrl != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
			dispatcher.forward(req, res);
		}
		
	}
	
	
	
	
	
	private void getPartConfig(Part part) {
		System.out.println("------------------------------------------------------------");
		System.out.println(" LOG :: [HTML태그의 폼태그 이름] :: " + part.getName());
		System.out.println(" LOG :: [ 파일 사이즈 ] :: " + part.getSize());
		for(String name : part.getHeaderNames()) {
			System.out.println(" LOG :: HeaderName :: " + name + ", HeaderValue :: " + part.getHeader(name) + "\n");
		}
		System.out.println("------------------------------------------------------------");
	}
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println(" LOG :: content-disposition 헤더 :: = "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
            	System.out.println(" LOG :: 파일 이름 :: " + token);
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}

