package framework.menupanel.mainmenubar.helpmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class FindSelectedFunctionMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -1464349946037586826L;

	public FindSelectedFunctionMenuItem() {
		super("Help_FindSelectedFunction");
		setMnemonic(KeyEvent.VK_F);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(toString());
	}

}
