package framework.menupanel.mainmenubar.insertmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import framework.menupanel.mainmenubar.insertmenu.boxstruct.FractionBoxMenuItem;
import framework.menupanel.mainmenubar.insertmenu.boxstruct.OverscriptBoxMenuItem;
import framework.menupanel.mainmenubar.insertmenu.boxstruct.RadicalBoxMenuItem;
import framework.menupanel.mainmenubar.insertmenu.boxstruct.SqrtBoxMenuItem;
import framework.menupanel.mainmenubar.insertmenu.boxstruct.SubscriptBoxMenuItem;
import framework.menupanel.mainmenubar.insertmenu.boxstruct.SubsuperscriptBoxMenuItem;
import framework.menupanel.mainmenubar.insertmenu.boxstruct.SuperscriptBoxMenuItem;
import framework.menupanel.mainmenubar.insertmenu.boxstruct.UnderoverscriptBoxMenuItem;
import framework.menupanel.mainmenubar.insertmenu.boxstruct.UnderscriptBoxMenuItem;
import framework.mycomponents.MyMenu;

public class BoxStructSubMenu extends MyMenu implements ActionListener {

	private static final long serialVersionUID = 1632905686608324771L;

	public SuperscriptBoxMenuItem superscriptBoxMenuItem;

	public SubscriptBoxMenuItem subscriptBoxMenuItem;

	public SubsuperscriptBoxMenuItem subsuperscriptBoxMenuItem;

	public UnderscriptBoxMenuItem underscriptBoxMenuItem;

	public OverscriptBoxMenuItem overscriptBoxMenuItem;

	public UnderoverscriptBoxMenuItem underoverscriptBoxMenuItem;

	public FractionBoxMenuItem fractionBoxMenuItem;

	public SqrtBoxMenuItem sqrtBoxMenuItem;

	public RadicalBoxMenuItem radicalBoxMenuItem;

	public BoxStructSubMenu() {
		super("Insert_BoxStruct");
		setMnemonic(KeyEvent.VK_B);
		addActionListener(this);
		items = new ArrayList<JMenuItem>();

		superscriptBoxMenuItem = new SuperscriptBoxMenuItem();
		add(superscriptBoxMenuItem);
		items.add(superscriptBoxMenuItem);

		subscriptBoxMenuItem = new SubscriptBoxMenuItem();
		add(subscriptBoxMenuItem);
		items.add(subscriptBoxMenuItem);

		subsuperscriptBoxMenuItem = new SubsuperscriptBoxMenuItem();
		add(subsuperscriptBoxMenuItem);
		items.add(subsuperscriptBoxMenuItem);

		addSeparator();

		underscriptBoxMenuItem = new UnderscriptBoxMenuItem();
		add(underscriptBoxMenuItem);
		items.add(underscriptBoxMenuItem);

		overscriptBoxMenuItem = new OverscriptBoxMenuItem();
		add(overscriptBoxMenuItem);
		items.add(overscriptBoxMenuItem);

		underoverscriptBoxMenuItem = new UnderoverscriptBoxMenuItem();
		add(underoverscriptBoxMenuItem);
		items.add(underoverscriptBoxMenuItem);

		addSeparator();

		fractionBoxMenuItem = new FractionBoxMenuItem();
		add(fractionBoxMenuItem);
		items.add(fractionBoxMenuItem);

		sqrtBoxMenuItem = new SqrtBoxMenuItem();
		add(sqrtBoxMenuItem);
		items.add(sqrtBoxMenuItem);

		radicalBoxMenuItem = new RadicalBoxMenuItem();
		add(radicalBoxMenuItem);
		items.add(radicalBoxMenuItem);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
