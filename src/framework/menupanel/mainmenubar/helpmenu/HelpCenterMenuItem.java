package framework.menupanel.mainmenubar.helpmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class HelpCenterMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 8806843398009881103L;

	public HelpCenterMenuItem() {
		super("Help_HelpCenter");
		setMnemonic(KeyEvent.VK_C);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(toString());
	}

}
