package framework.menupanel.maintoolbar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import common.FilePaths;
import common.SystemOperations;

import framework.mycomponents.MyButton;

public class ClearButton extends MyButton implements ActionListener {

	private static final long serialVersionUID = -8851634216977709845L;

	public ClearButton() {
		super(SystemOperations.getImageIcon(FilePaths.MAINTOOLBAR_ICONS_PATH + "clear.gif"));
		setName("Edit_Clear");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
