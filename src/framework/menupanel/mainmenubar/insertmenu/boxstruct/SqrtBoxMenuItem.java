package framework.menupanel.mainmenubar.insertmenu.boxstruct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class SqrtBoxMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -3017605815777826631L;

	public SqrtBoxMenuItem() {
		super("Insert_BoxStruct_SqrtBox");
		setMnemonic(KeyEvent.VK_S);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
		setActionCommand("Sqrt");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
