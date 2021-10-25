package formError;
//유효성 검사 2탄
public class QnaError {
	
	private String titleErr;
	private String contentErr;
	private boolean result;
	
	public String getTitleErr() {
		return titleErr;
	}
	
	public void setTitleErr(String titleErr) {
		this.titleErr = titleErr;
	}
	
	public String getContentErr() {
		return contentErr;
	}
	
	public void setContentErr(String contentErr) {
		this.contentErr = contentErr;
	}
	
	public boolean isResult() {
		return result;
	}
	
	public void setResult(boolean result) {
		this.result = result;
	}
	
	
}
