package com.core.springcore.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.core.springcore.bean.Room;
import com.core.springcore.bean.Table;

public class BeanDemo {

	@Autowired
	Room room;

	@Autowired
	@Qualifier("table-bean")
	Table tableBean;

	@Autowired
	@Qualifier("table-bean-2")
	Table tableBean2;

	public void autoWiringDemo() {

		System.out.println(room);

		System.out.println(tableBean);

		System.out.println(tableBean2);

	}

	public void updateValue() {
		tableBean.setName("table-no-1-filled");
	}

	public void readValue() {
		System.out.println(tableBean);
	}

	
	
	
}
