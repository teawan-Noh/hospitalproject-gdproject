package common;

import java.util.HashMap;
import java.util.List;

import dao.ask.ReservationDao;
import dao.ask.ReservationDaoImpl;
import dao.board.QnaDao;
import dao.board.QnaDaoImpl;
import dao.rest.RestDao;
import dao.rest.RestDaoImpl;
import model.ask.Rest;
import model.user.Subject;

public class Test {

	public static void main(String[] args) {
		ReservationDao rdao = new ReservationDaoImpl();
		List<Subject> subjectList = rdao.selectSubjectAll();
		
		for(Subject s : subjectList) {
			//System.out.println(s.getName());
		}
		QnaDao dao = new QnaDaoImpl();
		
		
//		void insert(Qna qna);
//		Qna qna = new Qna();
//		qna.setName("memo4");
//		qna.setAge(20);
		
//		dao.insert(qna);
		
//		void update(Qna qna);
//		dao.update(memo);
		
//		void delete(int qno);
//		dao.delete(2);
//		
//		List<Qna> selectAll();
//		List<HashMap> list = dao.selectAll();
		List<HashMap> list = dao.selectByNickname("환자3");
		for (HashMap hashMap : list) {
			//System.out.println(hashMap.get("qno"));
		}
		
//		Qna selectByQno(int qno);
//		Qna qna3 = dao.Qna selectByQno(int qno);
		
		RestDao rsdao = new RestDaoImpl();
		int dcode = 10;
		String reason = "휴가";
		String restdate = "2021-11-03";
		String day = null;
		//Rest rest = new Rest(dcode, reason, restdate, day);
		//rsdao.insert(rest);
		
		List<Rest> restList = rsdao.selectRestBydcode("대기", 3);
		
		for (Rest rest2 : restList) {
			System.out.println(rest2.toString());
		}
	}

}
