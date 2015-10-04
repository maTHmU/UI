package framework.mycomponents;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JMenuItem;

import language.Language;

public class MyMenuItem extends JMenuItem {

	private static final long serialVersionUID = 3629350631155200092L;

	protected ArrayList<JMenuItem> items;

	protected String name;

	public MyMenuItem() {
		super();
	}

	public MyMenuItem(String name) {
		super();
		this.name = name;
	}

	public void setLanguage(Language lang) {
		lang.mainMenu.changeMenuItemLanguage(this, name);
		if (items != null) {
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

	@Override
	public String getName() {
		return name;
	}

}
