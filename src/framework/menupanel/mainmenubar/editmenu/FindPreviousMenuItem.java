package framework.menupanel.mainmenubar.editmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class FindPreviousMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -8156019525242032652L;

	public FindPreviousMenuItem() {
		super("Edit_FindPrevious");
		setMnemonic(KeyEvent.VK_V);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.SHIFT_MASK));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(toString());
	}

}
