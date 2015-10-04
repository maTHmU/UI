package framework.menupanel.mainmenubar;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import framework.menupanel.mainmenubar.palletesmenu.InstallPalleteMenuItem;
import framework.menupanel.mainmenubar.palletesmenu.SpecialCharactersMenuItem;
import framework.mycomponents.MyMenu;

public class PalletesMenu extends MyMenu {

	private static final long serialVersionUID = -46338002579665248L;

	public SpecialCharactersMenuItem specialCharactersMenuItem;

	public InstallPalleteMenuItem installPalleteMenuItem;

	public PalletesMenu() {
		super("Palletes");
		setMnemonic(KeyEvent.VK_P);
		items = new ArrayList<JMenuItem>();

		specialCharactersMenuItem = new SpecialCharactersMenuItem();
		add(specialCharactersMenuItem);
		items.add(specialCharactersMenuItem);

		addSeparator();

		installPalleteMenuItem = new InstallPalleteMenuItem();
		add(installPalleteMenuItem);
		items.add(installPalleteMenuItem);
	}

}
