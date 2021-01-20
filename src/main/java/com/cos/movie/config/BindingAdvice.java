package com.cos.movie.config;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;


import com.cos.movie.domain.CommonDto;

@Aspect
@Component
public class BindingAdvice {

	@Around("execution(* com.cos.movie.web..*Controller.*(..))")
	public Object validCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		Object[] args = proceedingJoinPoint.getArgs();

		for (Object arg : args) {
			System.out.println("arg : " + arg);
			if (arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;
				if (bindingResult.hasErrors()) {
					return new CommonDto(HttpStatus.BAD_REQUEST.value(), "fail");
				}
			}
		}

		return proceedingJoinPoint.proceed();
	}
}
