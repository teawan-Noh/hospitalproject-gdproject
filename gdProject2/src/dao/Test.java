package dao;

import java.util.HashMap;
import java.util.List;

import model.Subject;

public class Test {

	public static void main(String[] args) {
		ReservationDao rdao = new ReservationDaoImpl();
		List<Subject> subjectList = rdao.selectSubjectAll();
		
		for(Subject s : subjectList) {
			System.out.println(s.getName());
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
		List<HashMap> list = dao.selectByNickname("È¯ÀÚ3");
		for (HashMap hashMap : list) {
			System.out.println(hashMap.get("qno"));
		}
		
//		Qna selectByQno(int qno);
//		Qna qna3 = dao.Qna selectByQno(int qno);	
	}

}
