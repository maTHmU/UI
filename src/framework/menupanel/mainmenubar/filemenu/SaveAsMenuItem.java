package framework.menupanel.mainmenubar.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class SaveAsMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 238352049900583380L;

	public SaveAsMenuItem() {
		super("File_SaveAs");
		setMnemonic(KeyEvent.VK_A);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK + InputEvent.ALT_MASK));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
