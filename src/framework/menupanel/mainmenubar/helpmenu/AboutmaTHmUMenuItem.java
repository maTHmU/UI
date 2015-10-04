package framework.menupanel.mainmenubar.helpmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import framework.mycomponents.MyMenuItem;

public class AboutmaTHmUMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 6730123897734358720L;

	public AboutmaTHmUMenuItem() {
		super("Help_AboutmaTHmU");
		setMnemonic(KeyEvent.VK_A);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(toString());
	}

}
