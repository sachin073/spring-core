package com.core.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.ContextClosedEvent;

import com.core.springcore.aspect.HotelAspectDemo;
import com.core.springcore.bean.Table;
import com.core.springcore.bean.TableCover;
import com.core.springcore.demo.BeanDemo;

@SpringBootApplication
@EnableAspectJAutoProxy
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
				System.out.println("\nSpring app context destroyed ");
			};
		});
		appx.setWebApplicationType(WebApplicationType.NONE); // means simple console app
																// In spring boot its set to WebApplicationType.Servlet
																// which create a web-server
																// (AnnotationConfigServletWebServerApplicationContext)
																// base context

		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) appx.run(args);
	}

	@Autowired
	BeanDemo beandemo;

	@Autowired
	@Qualifier("table-bean")
	Table tableBean;

	@Autowired
	TableCover mainCover;

	@Autowired
	HotelAspectDemo aspectDemo;

	/**
	 *
	 */
	@Override
	public void run(String... args) throws Exception {

//		System.out.println("-- check beans in context --");
//		beandemo.autoWiringDemo();
//		
//		System.out.println("\n--Singleton scope bean demo--\n");
//		System.out.println("fill table no-1 bean from beanDemo class reference");
//
//		beandemo.updateValue();
//		
//		System.out.println("tableBean property when read from different reference: "+tableBean.getName());
//
//		System.out.println("\n-- Prototype scope bean demo--\n");
//		System.out.println("table Cover bean in BeanDemo class : "+beandemo.getCover());
//
//		System.out.println("table conver bean here : "+mainCover);
//		System.out.println("if mainCover and cover in demoBean equal? "+ mainCover.equals(beandemo.getCover()));

		System.out.println("******************** Aspect Demo: Simulate romm booking **************");
		aspectDemo.sitmulateRoomBooking();

		System.out.println("\n\n******************** Error catching advice: simulate room selling **************");

		try {
			aspectDemo.sitmulateRoomSelling();
		} catch (Exception e) {
			// supress for clean output
		}
	}
}
