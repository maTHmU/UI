package framework.inputtabbedpane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import framework.mycomponents.MyButton;
import framework.mycomponents.MyToolBar;

import javax.swing.SwingConstants;

import common.FilePaths;
import common.SystemOperations;

public class MathToolBar extends MyToolBar implements ActionListener {

	private static final long serialVersionUID = 1423377887102952723L;

	public MathToolBar() {
		super(SwingConstants.HORIZONTAL);
		setName("Math");

		addButton("Power");
		addButton("Fraction");
		addButton("Sqrt");
		addButton("Root");
		addButton("Intt");
		addButton("Diff");
		addButton("DIntt");
		addButton("DDiff");
		addButton("Sum");
		addButton("Prod");
		addButton("Matrix");
		addButton("Part");
	}

	private void addButton(String buttonName) {
		MyButton newButton = new MyButton(
				SystemOperations.getImageIcon(FilePaths.INPUTTOOLBAR_MATH_ICONS_PATH + buttonName + ".png"));
		newButton.setName(buttonName);
		newButton.setActionCommand(buttonName);
		newButton.addActionListener(this);
		add(newButton);
		buttons.add(newButton);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}
