package framework.menupanel.mainmenubar.palletesmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import framework.mycomponents.MyMenuItem;

public class SpecialCharactersMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -2118520807667598985L;

	public SpecialCharactersMenuItem() {
		super("Palletes_SpecialCharacters");
		setMnemonic(KeyEvent.VK_S);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(toString());
	}

}
