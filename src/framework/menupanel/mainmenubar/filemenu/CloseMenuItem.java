package framework.menupanel.mainmenubar.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class CloseMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -1224782566680568085L;

	public CloseMenuItem() {
		super("File_Close");
		setMnemonic(KeyEvent.VK_0);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
