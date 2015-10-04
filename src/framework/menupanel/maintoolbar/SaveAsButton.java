package framework.menupanel.maintoolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.FilePaths;
import common.SystemOperations;

import framework.mycomponents.MyButton;

public class SaveAsButton extends MyButton implements ActionListener {

	private static final long serialVersionUID = -8575683864934768547L;

	public SaveAsButton() {
		super(SystemOperations.getImageIcon(FilePaths.MAINTOOLBAR_ICONS_PATH + "saveas.gif"));
		setName("File_SaveAs");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
	}

}
