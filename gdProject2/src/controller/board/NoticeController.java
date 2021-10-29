package controller.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import common.Sql;
import common.page.PageDao;
import common.page.PageDaoImpl;
import common.page.PageGroupResult;
import common.page.PageManager;
import dao.board.FileDao;
import dao.board.FileDaoImpl;
import dao.board.NoticeDao;
import dao.board.NoticeDaoImpl;
import model.board.Files;
import model.board.Notice;

@MultipartConfig
@WebServlet(name="NoticeController", urlPatterns= {"/notice_list","/notice_input","/notice_save","/notice_detail","/notice_update_input","/notice_update","/notice_delete","/notice_search"})
public class NoticeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		process(req,resp);

	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		String UPLOAD_DIR = "upload";
		
		//로직
		if(action.equals("notice_list")) {
			int requestPage = Integer.parseInt(req.getParameter("reqPage"));
			System.out.println(requestPage);
			
			NoticeDao dao = new NoticeDaoImpl();
			List<HashMap<String,Object>> list = dao.selectAll(requestPage);
			
			//총 줄수 가져오기
			PageDao pdao = new PageDaoImpl();
			int line = pdao.getCountNotice(Sql.NOTICE_COUNT_SQL);
			
			//getPageGroupResult() 불러오기
			PageManager manager = new PageManager(requestPage);
			PageGroupResult pgr =  manager.getPageGroupResult(line);
			
			req.setAttribute("noticeList", list);
			req.setAttribute("pageGroupResult", pgr);
			
		}else if(action.equals("notice_input")) {
			
			
			
		}else if(action.equals("notice_detail")) {
			int ncode = Integer.parseInt(req.getParameter("ncode"));
			NoticeDao dao = new NoticeDaoImpl();
			List<HashMap<String,Object>> detail = dao.selectByNcode(ncode);
			req.setAttribute("detail", detail);
			req.setAttribute("ncode", ncode);
			
			
			/*
			//파일 다운로드
			String fileName = req.getParameter("fileName");
			
			// 서버에 올라간 경로를 가져옴
			ServletContext context = getServletContext();
			String uploadFilePath = context.getRealPath(UPLOAD_DIR);
			String filePath = uploadFilePath + File.separator + fileName;
			
			resp.setContentType("image/jpeg/txt");
			byte[] image = IOUtils.toByteArray(new FileInputStream(new File(filePath)));
			resp.getOutputStream().write(image);
			*/
			
		}else if(action.equals("notice_save")) {
			//파일
			
			
			// 서버의 실제 경로
			String applicationPath = req.getServletContext().getRealPath("");
			String uploadFilePath = applicationPath + UPLOAD_DIR;
			
			System.out.println(" LOG :: [서버 루트 경로] :: " + applicationPath);
			System.out.println(" LOG :: [파일 저장 경로] :: " + uploadFilePath);
			
			File fileSaveDir = new File(uploadFilePath);
			
			//파일 경로가 없으면 새로 생성한다
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdirs();
			}
			
			String fileName=null;
			
			
			Part part = req.getPart("filename");
		    fileName = getFileName(part);
		    System.out.println( "LOG :: [업로드 파일 경로] :: " + uploadFilePath + File.separator + fileName);
		    
		    int uriLastIndex = fileName.lastIndexOf(".");
		    String uriAction = fileName.substring(uriLastIndex+1);
		    FileDao fdao = new FileDaoImpl();
		    String newFileName = fdao.returnSeq()+"."+uriAction;
		    
		    System.out.println("fcode로만든이름: "+newFileName);
		    System.out.println(uploadFilePath + File.separator + newFileName);
		    part.write(uploadFilePath + File.separator + newFileName);
		    
		    long fileSize = part.getSize();
		    
		    Files files = new Files(newFileName,fileName,fileSize);
		    fdao.insert(files);
		    
		    
			
		    //게시글
			HttpSession session = req.getSession(false);
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			int mcode = (int) session.getAttribute("mcode");
			
			Notice notice = new Notice(mcode,title,content);
			
			NoticeDao dao = new NoticeDaoImpl();
			dao.insert(notice);
			
			
			

		}else if(action.equals("notice_update_input")) {
			int ncode = Integer.parseInt(req.getParameter("ncode"));
			NoticeDao dao = new NoticeDaoImpl();
			List<HashMap<String,Object>> detail = dao.selectByNcode(ncode);
			req.setAttribute("detail", detail);
			req.setAttribute("ncode", ncode);
			
		}else if(action.equals("notice_update")) {
			
			int ncode = Integer.parseInt(req.getParameter("ncode"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			Notice notice = new Notice(title,ncode,content);
			NoticeDao dao = new NoticeDaoImpl();
			dao.update(notice);
			
		}else if(action.equals("notice_delete")) {
			int ncode = Integer.parseInt(req.getParameter("ncode"));
			NoticeDao dao = new NoticeDaoImpl();
			dao.delete(ncode);
			
		}else if(action.equals("notice_search")) {
			//검색
			NoticeDao dao = new NoticeDaoImpl();
			String name=req.getParameter("search");
			List<HashMap<String,Object>> searchList = dao.selectByTitleContent(name);
			
			req.setAttribute("searchList", searchList);
			
		}
		
		//페이지
		String dispatcherUrl = null;
		if(action.equals("notice_list")) {
			dispatcherUrl="/jsp/board/noticeList.jsp";
			
		}else if(action.equals("notice_input")) {
			dispatcherUrl="/jsp/board/newNotice.jsp";
			
		}else if(action.equals("notice_detail")) {
			dispatcherUrl="/jsp/board/noticeDetail.jsp";
			
		}else if(action.equals("notice_save")) {
			dispatcherUrl="notice_list?reqPage=1";
		}else if(action.equals("notice_update_input")) {
			dispatcherUrl="/jsp/board/updateNotice.jsp";
			
		}else if(action.equals("notice_update")) {
			dispatcherUrl="notice_list?reqPage=1";
		}else if(action.equals("notice_delete")) {
			dispatcherUrl="notice_list?reqPage=1";
		}else if(action.equals("notice_search")) {
			dispatcherUrl="/jsp/board/noticeSearch.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
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
