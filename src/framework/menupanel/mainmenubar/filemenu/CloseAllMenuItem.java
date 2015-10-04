package framework.menupanel.mainmenubar.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class CloseAllMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 5564175252150333106L;

	public CloseAllMenuItem() {
		super("File_CloseAll");
		setMnemonic(KeyEvent.VK_E);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
