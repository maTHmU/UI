package framework.menupanel.mainmenubar;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import framework.menupanel.mainmenubar.filemenu.CloseAllMenuItem;
import framework.menupanel.mainmenubar.filemenu.CloseMenuItem;
import framework.menupanel.mainmenubar.filemenu.ExitMenuItem;
import framework.menupanel.mainmenubar.filemenu.NewMenuItem;
import framework.menupanel.mainmenubar.filemenu.OpenMenuItem;
import framework.menupanel.mainmenubar.filemenu.SaveAsMenuItem;
import framework.menupanel.mainmenubar.filemenu.SaveMenuItem;
import framework.mycomponents.MyMenu;

public class FileMenu extends MyMenu {

	private static final long serialVersionUID = -9129696534717122494L;

	public NewMenuItem newMenuItem;

	public OpenMenuItem openMenuItem;

	public CloseMenuItem closeMenuItem;

	public CloseAllMenuItem closeAllMenuItem;

	public SaveMenuItem saveMenuItem;

	public SaveAsMenuItem saveAsMenuItem;

	public ExitMenuItem exitMenuItem;

	public FileMenu() {
		super("File");
		setMnemonic(KeyEvent.VK_F);
		items = new ArrayList<JMenuItem>();

		newMenuItem = new NewMenuItem();
		add(newMenuItem);
		items.add(newMenuItem);

		addSeparator();

		openMenuItem = new OpenMenuItem();
		add(openMenuItem);
		items.add(openMenuItem);

		closeMenuItem = new CloseMenuItem();
		add(closeMenuItem);
		items.add(closeMenuItem);

		closeAllMenuItem = new CloseAllMenuItem();
		add(closeAllMenuItem);
		items.add(closeAllMenuItem);

		saveMenuItem = new SaveMenuItem();
		add(saveMenuItem);
		items.add(saveMenuItem);

		saveAsMenuItem = new SaveAsMenuItem();
		add(saveAsMenuItem);
		items.add(saveAsMenuItem);

		addSeparator();

		exitMenuItem = new ExitMenuItem();
		add(exitMenuItem);
		items.add(exitMenuItem);
	}

}
