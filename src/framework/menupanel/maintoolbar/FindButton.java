package framework.menupanel.maintoolbar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import common.FilePaths;
import common.SystemOperations;

import framework.mycomponents.MyButton;

public class FindButton extends MyButton implements ActionListener {

	private static final long serialVersionUID = -4121372963212955117L;

	public FindButton() {
		super(SystemOperations.getImageIcon(FilePaths.MAINTOOLBAR_ICONS_PATH + "find.gif"));
		setName("Edit_Find");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
