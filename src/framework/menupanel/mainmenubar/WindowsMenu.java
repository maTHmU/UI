package framework.menupanel.mainmenubar;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import framework.menupanel.mainmenubar.windowsmenu.LanguageMenuItem;
import framework.menupanel.mainmenubar.windowsmenu.LookAndFeelSubMenu;
import framework.menupanel.mainmenubar.windowsmenu.PreferencesMenuItem;
import framework.mycomponents.MyMenu;

public class WindowsMenu extends MyMenu {

	private static final long serialVersionUID = 6398583947535211622L;

	public LookAndFeelSubMenu lookAndFeelMenuItem;

	public LanguageMenuItem languageMenuItem;

	public PreferencesMenuItem preferencesMenuItem;

	public WindowsMenu() {
		super("Windows");
		setMnemonic(KeyEvent.VK_W);
		items = new ArrayList<JMenuItem>();

		lookAndFeelMenuItem = new LookAndFeelSubMenu();
		add(lookAndFeelMenuItem);
		items.add(lookAndFeelMenuItem);

		addSeparator();

		languageMenuItem = new LanguageMenuItem();
		add(languageMenuItem);
		items.add(languageMenuItem);

		addSeparator();

		preferencesMenuItem = new PreferencesMenuItem();
		add(preferencesMenuItem);
		items.add(preferencesMenuItem);
	}

}
