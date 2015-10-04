package framework.menupanel.mainmenubar.windowsmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import framework.mycomponents.MyMenuItem;

public class LanguageMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 3176987617130780084L;

	public LanguageMenuItem() {
		super("Windows_Language");
		setMnemonic(KeyEvent.VK_A);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		
	}

}
