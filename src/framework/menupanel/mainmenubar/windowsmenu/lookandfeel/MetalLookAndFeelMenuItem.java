package framework.menupanel.mainmenubar.windowsmenu.lookandfeel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import console.Main;
import framework.mycomponents.MyMenuItem;

public class MetalLookAndFeelMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 3176987617130780084L;

	public MetalLookAndFeelMenuItem() {
		super("Windows_LookAndFeel_Metal");
		setMnemonic(KeyEvent.VK_M);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String lookAndFeelName = new String("javax.swing.plaf.metal.MetalLookAndFeel");
		Main.changeLookAndFeel(lookAndFeelName);
	}

}
