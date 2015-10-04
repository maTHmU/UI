package framework.menupanel.mainmenubar.editmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class CopyMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -956553540603781204L;

	public CopyMenuItem() {
		super("Edit_Copy");
		setMnemonic(KeyEvent.VK_C);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
