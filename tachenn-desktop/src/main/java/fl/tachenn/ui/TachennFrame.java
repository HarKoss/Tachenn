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
		this.setSize(400,400);
		this.setBackground(Color.red);
		this.setLocationRelativeTo(null);
	}
	public void showStartMenu() {
		this.switchPanel(menuPanel);
		this.setVisible(true);
	}

	public void showConsultPanel() {
		this.switchPanel(consultPanel);
		this.setVisible(true);
	}
	
	public void switchPanel(JPanel newPanel) {
		if (currentPanel != null) {
			currentPanel.setVisible(false);
			this.remove(consultPanel);
		}
		currentPanel = newPanel;
		currentPanel.setVisible(true);
		this.add(newPanel);
	}
}
