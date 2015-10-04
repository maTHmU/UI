package framework.menupanel.mainmenubar;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import framework.menupanel.mainmenubar.editmenu.ClearMenuItem;
import framework.menupanel.mainmenubar.editmenu.CopyMenuItem;
import framework.menupanel.mainmenubar.editmenu.CutMenuItem;
import framework.menupanel.mainmenubar.editmenu.FindMenuItem;
import framework.menupanel.mainmenubar.editmenu.FindNextMenuItem;
import framework.menupanel.mainmenubar.editmenu.FindPreviousMenuItem;
import framework.menupanel.mainmenubar.editmenu.PasteMenuItem;
import framework.menupanel.mainmenubar.editmenu.ReDoMenuItem;
import framework.menupanel.mainmenubar.editmenu.UnDoMenuItem;
import framework.mycomponents.MyMenu;

public class EditMenu extends MyMenu {

	private static final long serialVersionUID = 5000154259360047803L;

	public UnDoMenuItem unDoMenuItem;

	public ReDoMenuItem reDoMenuItem;

	public CutMenuItem cutMenuItem;

	public CopyMenuItem copyMenuItem;

	public PasteMenuItem pasteMenuItem;

	public ClearMenuItem clearMenuItem;

	public FindMenuItem findMenuItem;

	public FindNextMenuItem findNextMenuItem;

	public FindPreviousMenuItem findPreviousMenuItem;

	public EditMenu() {
		super("Edit");
		setMnemonic(KeyEvent.VK_E);
		items = new ArrayList<JMenuItem>();

		unDoMenuItem = new UnDoMenuItem();
		add(unDoMenuItem);
		items.add(unDoMenuItem);

		reDoMenuItem = new ReDoMenuItem();
		add(reDoMenuItem);
		items.add(reDoMenuItem);

		addSeparator();

		cutMenuItem = new CutMenuItem();
		add(cutMenuItem);
		items.add(cutMenuItem);

		copyMenuItem = new CopyMenuItem();
		add(copyMenuItem);
		items.add(copyMenuItem);

		pasteMenuItem = new PasteMenuItem();
		add(pasteMenuItem);
		items.add(pasteMenuItem);

		clearMenuItem = new ClearMenuItem();
		add(clearMenuItem);
		items.add(clearMenuItem);

		addSeparator();

		findMenuItem = new FindMenuItem();
		add(findMenuItem);
		items.add(findMenuItem);

		findNextMenuItem = new FindNextMenuItem();
		add(findNextMenuItem);
		items.add(findNextMenuItem);

		findPreviousMenuItem = new FindPreviousMenuItem();
		add(findPreviousMenuItem);
		items.add(findPreviousMenuItem);
	}

}
