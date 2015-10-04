package framework.menupanel.mainmenubar.insertmenu.boxstruct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import framework.mycomponents.MyMenuItem;

public class FractionBoxMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 2281652154198038734L;

	public FractionBoxMenuItem() {
		super("Insert_BoxStruct_FractionBox");
		setMnemonic(KeyEvent.VK_F);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, InputEvent.CTRL_MASK));
		setActionCommand("Fraction");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
