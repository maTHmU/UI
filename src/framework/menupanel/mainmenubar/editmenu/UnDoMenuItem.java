package framework.menupanel.mainmenubar.editmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class UnDoMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 3869394895467773772L;

	public UnDoMenuItem() {
		super("Edit_UnDo");
		setMnemonic(KeyEvent.VK_U);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(toString());
	}

}
