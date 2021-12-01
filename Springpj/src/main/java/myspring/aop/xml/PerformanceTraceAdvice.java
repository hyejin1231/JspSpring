package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {

	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		// getSignature 메서드는 Advice되는 메서드의 설명을 반환한다.
		String signatureString = joinPoint.getSignature().toShortString(); 
		// ProceedingJoinpoint의 상위 객체인 JoinPoint의 메서드인 getSignature메서드 사용함!
		System.out.println(signatureString + "시작");
		
		// 타겟의 메서드가 호출되기 전의 시간 
		long start = System.currentTimeMillis();
		
		try {
			// 타겟의 메서드 호출 
			Object result = joinPoint.proceed();
			return result;
		}finally {
			// 타게의 메서드 호출된 후의 시간 
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + "종료");
			System.out.println(signatureString + "실행 시간 : " + (finish - start) +  "ms");
		}
	}
}
