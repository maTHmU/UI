package framework.menupanel.mainmenubar.insertmenu.boxstruct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class UnderoverscriptBoxMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -2759020110432401255L;

	public UnderoverscriptBoxMenuItem() {
		super("Insert_BoxStruct_UnderoverscriptBox");
		setMnemonic(KeyEvent.VK_U);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.CTRL_MASK));
		setActionCommand("Underoverscript");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
