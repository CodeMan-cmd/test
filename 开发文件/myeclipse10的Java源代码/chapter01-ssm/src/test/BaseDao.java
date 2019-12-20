package test;

public class BaseDao {

	public static BaseDao bd=new BaseDao();
	
	/**
	 * 私有构造方法
	 */
	private BaseDao(){
		
	}
	
	
	/*public synchronized static BaseDao getbd(){
		bd=new BaseDao();
		return bd;
	}*/
	
}
