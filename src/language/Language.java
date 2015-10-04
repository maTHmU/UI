package language;

import console.Main;

public class Language {

	protected String languageName;

	public MainMenuLanguage mainMenu;

	public MainToolBarLanguage mainToolBar;

	public InputTabbedPaneLanguage inputTabbedPane;

	public Language(String languageName) {
		this.languageName = languageName;

		String filePath = LanguageManager.FILE_PATH + languageName + "/";
		mainMenu = new MainMenuLanguage(filePath);
		mainToolBar = new MainToolBarLanguage(filePath);
		inputTabbedPane = new InputTabbedPaneLanguage(filePath);
	}

	protected void setLanguage() {
		Main.getMainFrame().getMenuPanel().getMainMenuBar().setLanguage(this);
		Main.getMainFrame().getMenuPanel().getMainToolBar().setLanguage(this);
		Main.getMainFrame().getInputTabbedPane().setLanguage(this);
	}

}
