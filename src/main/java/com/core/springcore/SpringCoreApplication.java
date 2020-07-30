package com.core.springcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootApplication
@ComponentScan(basePackageClasses = SpringCoreApplication.class) // scan class under package of class
public class SpringCoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		// ConfigurableApplicationContext appx = SpringApplication.run(, args);
		SpringApplication appx = new SpringApplication(SpringCoreApplication.class);

		appx.addListeners(new ApplicationListener<ApplicationStartedEvent>() {
			public void onApplicationEvent(ApplicationStartedEvent event) {
				System.out.println(" Spring beans loaded and ready to run. :) ");
			};
		});

		appx.addListeners(new ApplicationListener<ContextClosedEvent>() {
			public void onApplicationEvent(ContextClosedEvent event) {
				System.out.println(" Spring app context destroyed ");
			};
		});
		appx.setWebApplicationType(WebApplicationType.NONE); // means simple console app
																// In spring boot its set to WebApplicationType.Servlet
																// which create a web-server
																// (AnnotationConfigServletWebServerApplicationContext)
																// base context

		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) appx.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("aaa");
	}
}
