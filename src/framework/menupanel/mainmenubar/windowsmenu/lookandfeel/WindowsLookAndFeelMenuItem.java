package framework.menupanel.mainmenubar.windowsmenu.lookandfeel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import console.Main;
import framework.mycomponents.MyMenuItem;

public class WindowsLookAndFeelMenuItem extends MyMenuItem implements ActionListener {

	private static final long serialVersionUID = 8493153549664894717L;

	public WindowsLookAndFeelMenuItem() {
		super("Windows_LookAndFeel_Windows");
		setMnemonic(KeyEvent.VK_W);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String lookAndFeelName = new String("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		Main.changeLookAndFeel(lookAndFeelName);
	}

}
