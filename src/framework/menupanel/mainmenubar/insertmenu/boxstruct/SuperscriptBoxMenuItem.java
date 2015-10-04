package framework.menupanel.mainmenubar.insertmenu.boxstruct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class SuperscriptBoxMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -5718068896190193873L;

	public SuperscriptBoxMenuItem() {
		super("Insert_BoxStruct_SuperscriptBox");
		setMnemonic(KeyEvent.VK_P);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.CTRL_MASK));
		setActionCommand("Superscript");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
