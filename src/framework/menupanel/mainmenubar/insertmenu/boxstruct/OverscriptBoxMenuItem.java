package framework.menupanel.mainmenubar.insertmenu.boxstruct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class OverscriptBoxMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 7947241610041403015L;

	public OverscriptBoxMenuItem() {
		super("Insert_BoxStruct_OverscriptBox");
		setMnemonic(KeyEvent.VK_O);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_MASK));
		setActionCommand("Overscript");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
