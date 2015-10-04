package framework.menupanel.mainmenubar;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import framework.menupanel.mainmenubar.helpmenu.AboutmaTHmUMenuItem;
import framework.menupanel.mainmenubar.helpmenu.FindSelectedFunctionMenuItem;
import framework.menupanel.mainmenubar.helpmenu.HelpCenterMenuItem;
import framework.mycomponents.MyMenu;

public class HelpMenu extends MyMenu {

	private static final long serialVersionUID = 5999737947485361358L;

	public HelpCenterMenuItem helpCenterMenuItem;

	public FindSelectedFunctionMenuItem findSelectedFunctionMenuItem;

	public AboutmaTHmUMenuItem aboutmaTHmUMenuItem;

	public HelpMenu() {
		super("Help");
		setMnemonic(KeyEvent.VK_H);
		items = new ArrayList<JMenuItem>();

		helpCenterMenuItem = new HelpCenterMenuItem();
		add(helpCenterMenuItem);
		items.add(helpCenterMenuItem);

		findSelectedFunctionMenuItem = new FindSelectedFunctionMenuItem();
		add(findSelectedFunctionMenuItem);
		items.add(findSelectedFunctionMenuItem);

		addSeparator();

		aboutmaTHmUMenuItem = new AboutmaTHmUMenuItem();
		add(aboutmaTHmUMenuItem);
		items.add(aboutmaTHmUMenuItem);
	}

}
