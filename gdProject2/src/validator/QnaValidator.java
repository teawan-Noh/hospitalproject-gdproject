package validator;

import java.util.ArrayList;
import java.util.List;

import formError.QnaError;
import model.Qna;
	
public class QnaValidator {
   
   public QnaError validate(Qna qna) {
	   QnaError qnaError = new QnaError();
	   
	   String title = qna.getTitle();
	   
	   if(title == null || title.trim().isEmpty()) {
		   qnaError.setTitleErr("제목을 입력해주세요!");
		   qnaError.setResult(true);
	   }
	      
	   String content = qna.getContent();
	      
	   if(content == null || content.trim().isEmpty()) {
		   qnaError.setContentErr("내용을 입력해주세요!");
		   qnaError.setResult(true);
	   } 
	   
	   return qnaError;
   }
}