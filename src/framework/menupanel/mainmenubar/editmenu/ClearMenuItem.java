package framework.menupanel.mainmenubar.editmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import framework.mycomponents.MyMenuItem;

public class ClearMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = -4044259787936061306L;

	public ClearMenuItem() {
		super("Edit_Clear");
		setMnemonic(KeyEvent.VK_R);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
