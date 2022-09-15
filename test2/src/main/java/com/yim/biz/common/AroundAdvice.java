package com.yim.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

// around로 사용할 advice는 반드시 pjp를 input으로 가져야 한다.
// around는 필터 서블릿클래스 처럼 작용된다.
public class AroundAdvice {
	public Object printLogAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE]");
		Object returnObj = pjp.proceed(); // 수행해야할 포인트 컷
		System.out.println("[AFTER]");
		return returnObj;
	}
}
