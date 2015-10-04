package framework.menupanel.mainmenubar;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import framework.menupanel.mainmenubar.insertmenu.BoxStructSubMenu;
import framework.mycomponents.MyMenu;

public class InsertMenu extends MyMenu {

	private static final long serialVersionUID = -8548967793631177827L;

	public BoxStructSubMenu boxStructMenuItem;

	public InsertMenu() {
		super("Insert");
		setMnemonic(KeyEvent.VK_I);
		items = new ArrayList<JMenuItem>();

		boxStructMenuItem = new BoxStructSubMenu();
		add(boxStructMenuItem);
		items.add(boxStructMenuItem);
	}

}
