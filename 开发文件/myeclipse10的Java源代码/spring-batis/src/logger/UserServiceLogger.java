package logger;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class UserServiceLogger {

	private static Logger log=Logger.getLogger(UserServiceLogger.class);

	/**
	 * ǰ����ǿ
	 * @param jp
	 */
	public void before(JoinPoint jp) {
        log.info("���� " + jp.getTarget() + " �� " + jp.getSignature().
            getName() + " ������������Σ�" + Arrays.toString(jp.getArgs()));
    }
	
	/**
	 * ������ǿ
	 * @param jp
	 * @param result
	 */
    public void afterReturning(JoinPoint jp, Object result) {
        log.info("���� " + jp.getTarget() + " �� " + jp.getSignature().
            getName() + " ��������������ֵ��" + result);
    }
    
    public void  afterThrowing(JoinPoint jp,Exception e){
    	System.err.println(e.getMessage());
    }
    
    /**
	 * ������ǿ
	 * @param jp
	 * @param result
	 */
    public void after(JoinPoint jp) {
        log.info("���� " + jp.getTarget() + " �� " + jp.getSignature().
            getName() );
    }
    
    
}
