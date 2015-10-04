package framework.menupanel.mainmenubar.insertmenu.boxstruct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class UnderscriptBoxMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 7448579289065647866L;

	public UnderscriptBoxMenuItem() {
		super("Insert_BoxStruct_UnderscriptBox");
		setMnemonic(KeyEvent.VK_D);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK));
		setActionCommand("Underscript");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
