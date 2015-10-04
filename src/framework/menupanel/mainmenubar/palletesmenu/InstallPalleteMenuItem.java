package framework.menupanel.mainmenubar.palletesmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import framework.mycomponents.MyMenuItem;

public class InstallPalleteMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -640941462851666582L;

	public InstallPalleteMenuItem() {
		super("Palletes_InstallPallete");
		setMnemonic(KeyEvent.VK_I);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(toString());
	}

}
