package fl.tachenn.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import fl.tachenn.controller.TachennController;
import fl.tachenn.ui.TachennFrame;

@ComponentScan(basePackages = "fl.tachenn")
public class Main {

	private static ApplicationContext context;

	public static void main(String[] args) {
		
		// load context
		context = new AnnotationConfigApplicationContext(Main.class);
		
		// init frame
		//TODO use spring TachennFrame frame = context.getBean(TachennFrame.class);
		TachennFrame frame = new TachennFrame();
		TachennController tachennController = new TachennController(frame);
		tachennController.openStartMenuPerspective();
	}
	
}
