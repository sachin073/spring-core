package com.core.springcore.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("room-bean-object")
public class Room {

	private String name="room-no-101";
	
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

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
