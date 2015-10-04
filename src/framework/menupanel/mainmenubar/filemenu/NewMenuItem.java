package framework.menupanel.mainmenubar.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import framework.mycomponents.MyMenuItem;

public class NewMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 6497280762330750077L;

	public NewMenuItem() {
		super("File_New");
		setMnemonic(KeyEvent.VK_N);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
