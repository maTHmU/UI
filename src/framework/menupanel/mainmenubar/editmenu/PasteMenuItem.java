package framework.menupanel.mainmenubar.editmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class PasteMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 2267908724606009560L;

	public PasteMenuItem() {
		super("Edit_Paste");
		setMnemonic(KeyEvent.VK_P);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
