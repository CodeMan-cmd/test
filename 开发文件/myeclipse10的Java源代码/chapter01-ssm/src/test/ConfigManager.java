package test;

public class ConfigManager {

	private static ConfigManager cm;
	
	/**
	 * ��ʼ������,��Ҫ�����ȡ database.properties�ļ�����  �������ݿ�
	 */
	private ConfigManager(){
		
	}
	
	/**
	 * ������̬�ڲ���
	 * @author huohongyan
	 *
	 */
	public static class getcm{
		//����һ����̬���ճ���    
		public static final ConfigManager cm1=new ConfigManager();
	}
	
	public static ConfigManager getcm(){
		cm=getcm.cm1;
		return cm;
	}
	
}
