package com.core.springcore.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.core.springcore.bean.Room;

@Component
@Aspect
public class HotelAdviceAspect {

	@After("execution(* Hotel.printRoomName(..))")
	private void afterHotelOpens(JoinPoint point) {
		Room room = (Room) point.getArgs()[0];
		System.out.println(room.getName() + " has base charge of Rs 100" + " <<@After advice on room selection");
	}

	@Before("execution(* Hotel.rentRoom(..))")
	private void beforeRoomSold() {
		System.out.println("Registering customer before hading over room" + " <<@Before advice on room booking ");
	}

	@AfterThrowing(pointcut = "execution(* Hotel.sellRoom(..))", throwing = "ex")
	private void afterExceptionThrown(Exception ex) {
		System.out.println("lets logs the info " + ex.getMessage() + " <<@AfterThrowing advice ");
	}

	@Around("execution(* Hotel.collectPayment(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {

		// before payment : lets add extra Taxes in base
		System.out
				.println("adding 200 as Tax in base charge " + pjp.getArgs()[2] + "<< @Around advice before execution");
		int baseChange = (Integer) pjp.getArgs()[2] + 200;

		Object retVal = pjp.proceed(); // if remove this line, then the actual method call will be skipped!!

		// after payment : lets log payment in transaction history
		System.out.println(" payment success for Rs" + retVal + " << @Around advice after execution");
		return retVal;
	}

}
