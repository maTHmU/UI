package framework.menupanel.mainmenubar.editmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class CutMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 9218013537915275753L;

	public CutMenuItem() {
		super("Edit_Cut");
		setMnemonic(KeyEvent.VK_T);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
