package framework.menupanel.maintoolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.FilePaths;
import common.SystemOperations;

import framework.mycomponents.MyButton;

public class NewButton extends MyButton implements ActionListener {

	private static final long serialVersionUID = -6892449169039308651L;

	public NewButton() {
		super(SystemOperations.getImageIcon(FilePaths.MAINTOOLBAR_ICONS_PATH + "new.gif"));
		setName("File_New");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
