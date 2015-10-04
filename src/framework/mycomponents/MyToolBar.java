package framework.mycomponents;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JToolBar;

import language.Language;

public class MyToolBar extends JToolBar {

	private static final long serialVersionUID = -968981738240881654L;

	protected ArrayList<MyButton> buttons;

	protected MyToolBar(int orientation) {
		super(orientation);
		setFloatable(false);
		buttons = new ArrayList<MyButton>();
	}

	public void setLanguage(Language lang) {
		if (buttons != null) {
			Iterator<MyButton> it = buttons.listIterator();
			while (it.hasNext()) {
				MyButton button = it.next();
				lang.mainToolBar.changeToolBarLanguage(button);
			}
		}
	}

}
