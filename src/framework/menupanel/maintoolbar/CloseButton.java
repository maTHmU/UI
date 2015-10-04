package framework.menupanel.maintoolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.FilePaths;
import common.SystemOperations;

import framework.mycomponents.MyButton;

public class CloseButton extends MyButton implements ActionListener {

	private static final long serialVersionUID = -6663498849156042113L;

	public CloseButton() {
		super(SystemOperations.getImageIcon(FilePaths.MAINTOOLBAR_ICONS_PATH + "close.gif"));
		setName("File_Close");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
	}

}
