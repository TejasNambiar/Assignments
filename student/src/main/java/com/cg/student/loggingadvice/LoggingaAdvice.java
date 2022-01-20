package com.cg.student.loggingadvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingaAdvice {
	
	Logger logger = LoggerFactory.getLogger(LoggingaAdvice.class);
	
	/**
	 * Tells Spring AOP where to look for 
	 * customized logging statements GLOBALLY
	 */
	@Pointcut(value = "execution(* com.cg.student.*.*.*(..))")
	public void myPointCut() {
		
	}
	
	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().toString();
		Object[] array = joinPoint.getArgs(); 
		
		/**
		 * Before method invocation, calling logger 
		 * to check basic parameters 
		 */
		logger.info("\nMethod invoked:: "+className +" : "
		   			    +methodName+"()" 
						+ "\narguments:: "+mapper.writeValueAsString(array));
		
		Object object = joinPoint.proceed();
		
		/**
		 * Post method invocation, calling logger 
		 * to check result returned 
		 */
		logger.info("\n"+className +" : "
   			    +methodName+"()" 
				+ "\nResponse:: "+mapper.writeValueAsString(array));
		
		return object;
	}
}
