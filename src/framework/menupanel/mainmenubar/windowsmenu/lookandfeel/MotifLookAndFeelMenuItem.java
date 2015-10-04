package framework.menupanel.mainmenubar.windowsmenu.lookandfeel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import console.Main;

import framework.mycomponents.MyMenuItem;

public class MotifLookAndFeelMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 3176987617130780084L;

	public MotifLookAndFeelMenuItem() {
		super("Windows_LookAndFeel_Motif");
		setMnemonic(KeyEvent.VK_O);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String lookAndFeelName = new String("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		Main.changeLookAndFeel(lookAndFeelName);
	}

}
