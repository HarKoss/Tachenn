package fl.tachenn.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import fl.tachenn.controller.TachennController;

@ComponentScan(basePackages = "fl.tachenn")
public class Main {

	private static ApplicationContext context;

	public static void main(String[] args) {
		
		// load context
		context = new AnnotationConfigApplicationContext(Main.class);
		
		// init frame
		TachennController tachennController = context.getBean(TachennController.class);
		tachennController.init();
	}
	
}
