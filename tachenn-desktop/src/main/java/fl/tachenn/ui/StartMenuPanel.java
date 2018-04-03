package fl.tachenn.ui;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class StartMenuPanel extends JPanel {

	private static final long serialVersionUID = 7610338910634358447L;

	private JButton openFileButton;
	
	public void init() {
		// create consult document button
		openFileButton = new JButton("Open ODS file");
		this.add(openFileButton);
	}

	public JButton getOpenFileButton() {
		return openFileButton;
	}

	public void setOpenFileButton(JButton openFileButton) {
		this.openFileButton = openFileButton;
	}

}
