package fl.tachenn.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@Component
public class StartMenuPanel extends JPanel {

	private static final long serialVersionUID = 7610338910634358447L;

	private JLabel menuTitle; 
	private JPanel buttons;
	private JButton openFileButton;
	private JButton otherButton;
	
	public void init() {
		
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        
        // menu title constraint
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.NORTH;
        
		menuTitle = new JLabel("<html><h1><strong><i>Tachen Menu</i></strong></h1><hr></html>"); 
		this.add(menuTitle, constraints);
		
		// button constraint
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		// fill buttons panel
		buttons = new JPanel(new GridBagLayout());
		
		openFileButton = new JButton("Open ODS file");
		buttons.add(openFileButton, constraints);
		
		otherButton = new JButton("Other thing...");
		buttons.add(otherButton, constraints);
		
		constraints.weighty = 1;
        add(buttons, constraints);
	}
	
	public void initTest() {
		

        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        
        // menu title constraint
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.NORTH;
        
		menuTitle = new JLabel("<html><h1><strong><i>Tachen Menu</i></strong></h1><hr></html>"); 
		this.add(menuTitle, constraints);
		
		// button constraint
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		// fill buttons panel
		buttons = new JPanel(new GridBagLayout());
		
		openFileButton = new JButton("Open ODS file");
		buttons.add(openFileButton, constraints);
		
		otherButton = new JButton("Other thing...");
		buttons.add(otherButton, constraints);
		
		constraints.weighty = 1;
        add(buttons, constraints);
	}

	public JButton getOpenFileButton() {
		return openFileButton;
	}

	public void setOpenFileButton(JButton openFileButton) {
		this.openFileButton = openFileButton;
	}

	public JButton getOtherButton() {
		return otherButton;
	}

	public void setOtherButton(JButton otherButton) {
		this.otherButton = otherButton;
	}
}
