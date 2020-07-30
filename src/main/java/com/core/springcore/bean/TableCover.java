package com.core.springcore.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TableCover {

	@Override
	public String toString() {
		return "hello from Room instance";
	}

	@PostConstruct
	public void postCreate() {
		System.out.println("Here is your new table cover");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("table cover destroyed");
	}

}
