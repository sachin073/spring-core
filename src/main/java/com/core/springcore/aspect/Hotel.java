package com.core.springcore.aspect;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.core.springcore.bean.Room;

@Component
public class Hotel {

	@PostConstruct
	public void init() {
		System.out.println("Hotel open!!");
	}

	public void printRoomName(Room room) {
		System.out.println("Room details : " + room.getName());
	}

	public void sellRoom(Room room) {
		throw new UnsupportedOperationException(" Selling is not allowed, only renting");
	}

	public void rentRoom(Room room) {
		System.out.println("Room sold : " + room.getName());
	}
	
	public int collectPayment(Room room, int suitType, int baseCharges) {
	
		System.out.println("total payment collected for "+room.getName()+" : " + baseCharges);

		return baseCharges;
	}

}
