package com.core.springcore.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.core.springcore.bean.Room;

@Component
public class HotelAspectDemo {

	@Autowired
	Hotel hotel;

	@Autowired
	Room room;

	public void sitmulateRoomBooking() {
		System.out.println("\n selecting room ");
		hotel.printRoomName(room);
		System.out.println("\n booking room ");
		hotel.rentRoom(room);
		System.out.println("\n colecting payment for room ");
		hotel.collectPayment(room, 1, 100);
	}

	public void sitmulateRoomSelling() {
		System.out.println("\n selling room");
		hotel.sellRoom(room);
	}
}
