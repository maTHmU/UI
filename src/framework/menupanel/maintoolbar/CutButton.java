package framework.menupanel.maintoolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.FilePaths;
import common.SystemOperations;

import framework.mycomponents.MyButton;

public class CutButton extends MyButton implements ActionListener {

	private static final long serialVersionUID = 727475150479081525L;

	public CutButton() {
		super(SystemOperations.getImageIcon(FilePaths.MAINTOOLBAR_ICONS_PATH + "cut.gif"));
		setName("Edit_Cut");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
