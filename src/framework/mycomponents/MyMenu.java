package framework.mycomponents;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import language.Language;

public class MyMenu extends JMenu {

	private static final long serialVersionUID = 3629350631155200092L;

	protected ArrayList<JMenuItem> items;

	protected String name;

	public MyMenu() {
		super();
	}

	public MyMenu(String name) {
		super();
		this.name = name;
	}

	public void setLanguage(Language lang) {
		lang.mainMenu.changeMenuItemLanguage(this, name);
		Iterator<JMenuItem> it = items.listIterator();
		while (it.hasNext()) {
			JMenuItem mi = it.next();
			if (mi instanceof MyMenuItem) {
				((MyMenuItem)mi).setLanguage(lang);
			} else if (mi instanceof MyMenu) {
				((MyMenu)mi).setLanguage(lang);
			}
		}
	}

}
