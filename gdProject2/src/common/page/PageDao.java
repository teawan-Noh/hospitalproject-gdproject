package common.page;

public interface PageDao {
	int getCountPatient(int pcode);
	int getCountDoctor(int dcode);
	int getCountDoctorRsvdate(int dcode, String rsvdate);
	
	int getCountNotice(String sql);
	int getCountNoticeSearch(String name);

	int getCountQnaAll(String sql);
	int getCountQnaSearchNickname(String searchValue);
	

}
