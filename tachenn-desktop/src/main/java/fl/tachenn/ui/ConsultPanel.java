package fl.tachenn.ui;

import java.awt.Color;

import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class ConsultPanel extends JPanel {

	private static final long serialVersionUID = 2644312129917630605L;

	public void init() {
		this.setBackground(Color.blue);
	}

}
