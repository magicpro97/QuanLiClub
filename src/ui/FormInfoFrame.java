package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FormInfoFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StudentInfoPanel inforForm;
	JButton btnChangeAvatar;
	
	public FormInfoFrame() {
		addControls();
		setting();
	}

	private void setting() {
		this.setSize(new Dimension(780, 265));
		this.setResizable(false);
		this.add(inforForm);
		
	}

	
	private void addControls() {
		inforForm = new StudentInfoPanel();
		btnChangeAvatar = new JButton("Change");
		inforForm.avatarPanel.add(btnChangeAvatar, BorderLayout.PAGE_END);
	}

}
