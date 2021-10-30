package validator;

import java.util.ArrayList;
import java.util.List;

import model.board.Qna;
	
public class QnaValidator {
   
   public QnaError validate(Qna qnaForm) {
	   QnaError qnaError = new QnaError();
	   
	   String title = qnaForm.getTitle();
	   
	   if(title == null || title.trim().isEmpty()) {
		   qnaError.setTitleErr("제목을 입력해주세요!");
		   qnaError.setResult(true);
	   }
	      
	   String content = qnaForm.getContent();
	      
	   if(content == null || content.trim().isEmpty()) {
		   qnaError.setContentErr("내용을 입력해주세요!");
		   qnaError.setResult(true);
	   } 
	   
	   return qnaError;
   }
}