package framework.menupanel.maintoolbar;

import javax.swing.SwingConstants;

import framework.mycomponents.MyToolBar;

public class MainToolBar extends MyToolBar {

	private static final long serialVersionUID = 1423377887102952723L;

	public MainToolBar() {
		super(SwingConstants.HORIZONTAL);

		NewButton newButton = new NewButton();
		add(newButton);
		buttons.add(newButton);

		OpenButton openButton = new OpenButton();
		add(openButton);
		buttons.add(openButton);

		SaveButton saveButton = new SaveButton();
		add(saveButton);
		buttons.add(saveButton);

		SaveAsButton saveAsButton = new SaveAsButton();
		add(saveAsButton);
		buttons.add(saveAsButton);

		CloseButton closeButton = new CloseButton();
		add(closeButton);
		buttons.add(closeButton);

		ExitButton exitButton = new ExitButton();
		add(exitButton);
		buttons.add(exitButton);

		addSeparator();

		UnDoButton unDoButton = new UnDoButton();
		add(unDoButton);
		buttons.add(unDoButton);

		ReDoButton reDoButton = new ReDoButton();
		add(reDoButton);
		buttons.add(reDoButton);

		FindButton findButton = new FindButton();
		add(findButton);
		buttons.add(findButton);

		addSeparator();

		CutButton cutButton = new CutButton();
		add(cutButton);
		buttons.add(cutButton);

		CopyButton copyButton = new CopyButton();
		add(copyButton);
		buttons.add(copyButton);

		PasteButton pasteButton = new PasteButton();
		add(pasteButton);
		buttons.add(pasteButton);

		ClearButton clearButton = new ClearButton();
		add(clearButton);
		buttons.add(clearButton);

		addSeparator();

		PreferencesButton preferencesButton = new PreferencesButton();
		add(preferencesButton);
		buttons.add(preferencesButton);

		HelpButton helpButton = new HelpButton();
		add(helpButton);
		buttons.add(helpButton);
	}

}
