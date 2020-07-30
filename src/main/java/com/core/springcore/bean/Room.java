package com.core.springcore.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("component-bean-object")
public class Room {

	@Override
	public String toString() {
		return "hello from Room instance";
	}
	
	@PostConstruct
	public void postCreate(){
		System.out.println(" Room bean created");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Room bean destroyed");
	}

}
