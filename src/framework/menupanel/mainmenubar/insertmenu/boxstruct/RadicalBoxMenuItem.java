package framework.menupanel.mainmenubar.insertmenu.boxstruct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class RadicalBoxMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 9210401915963944738L;

	public RadicalBoxMenuItem() {
		super("Insert_BoxStruct_RadicalBox");
		setMnemonic(KeyEvent.VK_R);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
		setActionCommand("Root");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
