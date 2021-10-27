package common.page;

public interface PageDao {
	int getCount(int pcode);
	
	int getCountNotice(String sql);
}
