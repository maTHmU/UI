package framework.menupanel.mainmenubar.windowsmenu;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import framework.menupanel.mainmenubar.windowsmenu.lookandfeel.MetalLookAndFeelMenuItem;
import framework.menupanel.mainmenubar.windowsmenu.lookandfeel.MotifLookAndFeelMenuItem;
import framework.menupanel.mainmenubar.windowsmenu.lookandfeel.WindowsLookAndFeelMenuItem;
import framework.mycomponents.MyMenu;

public class LookAndFeelSubMenu extends MyMenu {

	private static final long serialVersionUID = -4005440069896024744L;

	public WindowsLookAndFeelMenuItem windowsLookAndFeelMenuItem;

	public MetalLookAndFeelMenuItem metalLookAndFeelMenuItem;

	public MotifLookAndFeelMenuItem motifLookAndFeelMenuItem;

	public LookAndFeelSubMenu() {
		super("Windows_LookAndFeel");
		setMnemonic(KeyEvent.VK_L);
		items = new ArrayList<JMenuItem>();

		windowsLookAndFeelMenuItem = new WindowsLookAndFeelMenuItem();
		add(windowsLookAndFeelMenuItem);
		items.add(windowsLookAndFeelMenuItem);

		metalLookAndFeelMenuItem = new MetalLookAndFeelMenuItem();
		add(metalLookAndFeelMenuItem);
		items.add(metalLookAndFeelMenuItem);

		motifLookAndFeelMenuItem = new MotifLookAndFeelMenuItem();
		add(motifLookAndFeelMenuItem);
		items.add(motifLookAndFeelMenuItem);
	}

}
