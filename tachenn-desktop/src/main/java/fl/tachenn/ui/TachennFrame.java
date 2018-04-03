package fl.tachenn.ui;

import javax.swing.JFrame;

public class TachennFrame extends JFrame {

	private static final long serialVersionUID = -1073204916547346277L;

	public void init() {		
		
		this.setTitle("Tachenn Desktop");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200,200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void clearFrame() {
		this.removeAll();
	}
}
