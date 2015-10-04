package framework.menupanel.maintoolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.FilePaths;
import common.SystemOperations;

import framework.mycomponents.MyButton;

public class PasteButton extends MyButton implements ActionListener {

	private static final long serialVersionUID = -7738819625826244471L;

	public PasteButton() {
		super(SystemOperations.getImageIcon(FilePaths.MAINTOOLBAR_ICONS_PATH + "paste.gif"));
		setName("Edit_Paste");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
