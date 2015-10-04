package framework.menupanel.mainmenubar;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import framework.mycomponents.MyMenu;
import framework.mycomponents.MyMenuItem;

import language.Language;

public class MainMenuBar extends JMenuBar {

	private static final long serialVersionUID = 5442194283263347557L;

	private ArrayList<JMenuItem> items;

	public FileMenu fileMenu;

	public EditMenu editMenu;

	public InsertMenu insertMenu;

	public PalletesMenu palletesMenu;

	public WindowsMenu windowsMenu;

	public HelpMenu helpMenu;

	public MainMenuBar() {
		super();
		items = new ArrayList<JMenuItem>();

		fileMenu = new FileMenu();
		add(fileMenu);
		items.add(fileMenu);

		editMenu = new EditMenu();
		add(editMenu);
		items.add(editMenu);

		insertMenu = new InsertMenu();
		add(insertMenu);
		items.add(insertMenu);

		palletesMenu = new PalletesMenu();
		add(palletesMenu);
		items.add(palletesMenu);

		windowsMenu = new WindowsMenu();
		add(windowsMenu);
		items.add(windowsMenu);

		helpMenu = new HelpMenu();
		add(helpMenu);
		items.add(helpMenu);
	}

	public void setLanguage(Language lang) {
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
