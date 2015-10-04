package framework.menupanel.mainmenubar.insertmenu.boxstruct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class SubscriptBoxMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -687840157139215756L;

	public SubscriptBoxMenuItem() {
		super("Insert_BoxStruct_SubscriptBox");
		setMnemonic(KeyEvent.VK_B);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, InputEvent.CTRL_MASK));
		setActionCommand("Subscript");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
