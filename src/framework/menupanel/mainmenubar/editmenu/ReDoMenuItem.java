package framework.menupanel.mainmenubar.editmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class ReDoMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 3719490506753287311L;

	public ReDoMenuItem() {
		super("Edit_ReDo");
		setMnemonic(KeyEvent.VK_R);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(toString());
	}

}
