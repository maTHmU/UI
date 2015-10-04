package framework.menupanel.mainmenubar.insertmenu.boxstruct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class SubsuperscriptBoxMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -4238840244065546674L;

	public SubsuperscriptBoxMenuItem() {
		super("Insert_BoxStruct_SubsuperscriptBox");
		setMnemonic(KeyEvent.VK_E);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8, InputEvent.CTRL_MASK));
		setActionCommand("Subsuperscript");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
