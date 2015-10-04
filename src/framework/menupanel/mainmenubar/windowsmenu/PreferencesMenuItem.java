package framework.menupanel.mainmenubar.windowsmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import framework.mycomponents.MyMenuItem;

public class PreferencesMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -781654984209745382L;

	public PreferencesMenuItem() {
		super("Windows_Preferences");
		setMnemonic(KeyEvent.VK_S);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(toString());
	}

}
