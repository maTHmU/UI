package framework.menupanel.maintoolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.FilePaths;
import common.SystemOperations;

import framework.mycomponents.MyButton;

public class SaveButton extends MyButton implements ActionListener {

	private static final long serialVersionUID = -4797545102323031502L;

	public SaveButton() {
		super(SystemOperations.getImageIcon(FilePaths.MAINTOOLBAR_ICONS_PATH + "save.gif"));
		setName("File_Save");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
	}

}
