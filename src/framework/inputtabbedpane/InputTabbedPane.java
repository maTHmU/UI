package framework.inputtabbedpane;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTabbedPane;

import framework.mycomponents.MyToolBar;

import language.Language;

public class InputTabbedPane extends JTabbedPane {

	private static final long serialVersionUID = -8174159045681571621L;

	protected ArrayList<MyToolBar> toolBars;

	public InputTabbedPane() {
		super();

		toolBars = new ArrayList<MyToolBar>();
		addNewTab("", new MathToolBar());
		addNewTab("", new GreekToolBar());
	}

	private void addNewTab(String name, MyToolBar newToolBar) {
		addTab(name, newToolBar);
		toolBars.add(newToolBar);
	}

	public void setLanguage(Language lang) {
		if (toolBars != null) {
			Iterator<MyToolBar> it = toolBars.listIterator();
			int no = 0;
			while (it.hasNext()) {
				MyToolBar toolBar = it.next();
				lang.inputTabbedPane.changeTabbedPaneLanguage(this, no, toolBar.getName());
				no ++;
			}
		}
	}

}
