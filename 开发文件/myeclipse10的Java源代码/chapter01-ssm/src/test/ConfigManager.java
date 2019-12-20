package test;

public class ConfigManager {

	private static ConfigManager cm;
	
	/**
	 * 初始化操作,主要负责读取 database.properties文件属性  连接数据库
	 */
	private ConfigManager(){
		
	}
	
	/**
	 * 声明静态内部类
	 * @author huohongyan
	 *
	 */
	public static class getcm{
		//创建一个静态最终常量    
		public static final ConfigManager cm1=new ConfigManager();
	}
	
	public static ConfigManager getcm(){
		cm=getcm.cm1;
		return cm;
	}
	
}
