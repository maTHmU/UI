package framework.menupanel.mainmenubar.editmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class FindNextMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 9003531940654252590L;

	public FindNextMenuItem() {
		super("Edit_FindNext");
		setMnemonic(KeyEvent.VK_N);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(toString());
	}

}
