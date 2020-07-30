package com.core.springcore.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreRoom {

	@Bean("table-bean")
	public Table createTable() {
		return new Table("table-no-1");
	}

	@Bean("table-bean-2")
	public Table createTable2() {
		return new Table("table-no-2");
	}
}