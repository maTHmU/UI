package framework.menupanel.maintoolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.FilePaths;
import common.SystemOperations;

import framework.mycomponents.MyButton;

public class ExitButton extends MyButton implements ActionListener {

	private static final long serialVersionUID = 940804692475175437L;

	public ExitButton() {
		super(SystemOperations.getImageIcon(FilePaths.MAINTOOLBAR_ICONS_PATH + "exit.gif"));
		setName("File_Exit");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
