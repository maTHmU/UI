package framework.menupanel.mainmenubar.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import framework.mycomponents.MyMenuItem;

public class ExitMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 8434469102303152886L;

	public ExitMenuItem() {
		super("File_Exit");
		setMnemonic(KeyEvent.VK_X);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
