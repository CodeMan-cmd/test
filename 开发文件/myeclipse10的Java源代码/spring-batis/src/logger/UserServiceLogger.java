package logger;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class UserServiceLogger {

	private static Logger log=Logger.getLogger(UserServiceLogger.class);

	/**
	 * 前置增强
	 * @param jp
	 */
	public void before(JoinPoint jp) {
        log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().
            getName() + " 方法。方法入参：" + Arrays.toString(jp.getArgs()));
    }
	
	/**
	 * 后置增强
	 * @param jp
	 * @param result
	 */
    public void afterReturning(JoinPoint jp, Object result) {
        log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().
            getName() + " 方法。方法返回值：" + result);
    }
    
    public void  afterThrowing(JoinPoint jp,Exception e){
    	System.err.println(e.getMessage());
    }
    
    /**
	 * 最终增强
	 * @param jp
	 * @param result
	 */
    public void after(JoinPoint jp) {
        log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().
            getName() );
    }
    
    
}
