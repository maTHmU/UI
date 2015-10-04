package framework.menupanel;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import framework.menupanel.mainmenubar.MainMenuBar;
import framework.menupanel.maintoolbar.MainToolBar;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 6028578890105403828L;

	private MainMenuBar mainMenuBar;

	private MainToolBar mainToolBar;

	public MenuPanel() {
		super();
		setLayout(new BorderLayout());

		mainMenuBar = new MainMenuBar();
		add(mainMenuBar, BorderLayout.NORTH);

		mainToolBar = new MainToolBar();
		add(mainToolBar, BorderLayout.SOUTH);
	}

	public MainMenuBar getMainMenuBar() {
		return mainMenuBar;
	}

	public MainToolBar getMainToolBar() {
		return mainToolBar;
	}

}
