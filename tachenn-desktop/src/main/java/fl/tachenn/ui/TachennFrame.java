package fl.tachenn.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class TachennFrame extends JFrame {

	private static final long serialVersionUID = -1073204916547346277L;

	public void init () {
		this.setTitle("Tachenn Dasktop");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200,200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
			
		// create start button
		JPanel buttonPanel = new JPanel();
		JButton openFileButton = new JButton("Open ODS file");
		buttonPanel.add(openFileButton);
		this.add(buttonPanel);
	}
}
