package fl.tachenn.ui;

import java.awt.Color;

import javax.annotation.Resource;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class TachennFrame extends JFrame {
	
	@Resource(name="startMenuPanel")
	private StartMenuPanel menuPanel;
	
	@Resource(name="consultPanel")
	private ConsultPanel consultPanel;
	
	private JPanel currentPanel;

	private static final long serialVersionUID = -1073204916547346277L;

	public void init() {		
		this.setTitle("Tachenn Desktop");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200,200);
		this.setBackground(Color.red);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void showStartMenu() {
		this.switchPanel(menuPanel);
	}

	public void showConsultPanel() {
		this.switchPanel(consultPanel);
	}
	
	public void switchPanel(JPanel newPanel) {
		if (currentPanel != null) {
			this.remove(consultPanel);
		}
		currentPanel = newPanel;
		this.add(newPanel);
        //TODO fix: can't display the second panel
	}
}
