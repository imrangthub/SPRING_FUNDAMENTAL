package com.imranmadbar.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SpringAspect {

	// What kind of method calls I would intercept
	// execution(* PACKAGE.*.*(..))
	// Weaving & Weaver

//	@Before("execution(* com.imranmadbar.*.*(..))")
//	public void before(JoinPoint joinPoint) {
//		System.out.println("Before AspectJoinPoing:" + joinPoint);
//		System.out.println("Before Aspect #######################");
//
//	}

//	@After("execution(* com.imranmadbar.admin.*.*(..))")
//	public void afterAdvice(JoinPoint joinPoint) {
//		System.out.println("After Aspect #######################");
//	}


	@Around("execution(* com.imranmadbar.admin.*.*(..))")
	public void testAroundAdvice(ProceedingJoinPoint procjoinpoin) throws Throwable {
		System.out.println("Executing Before part of business method #############");
		procjoinpoin.proceed(); // this code will call business method
		System.out.println("Executing After part of business method ##############");
	}

}
