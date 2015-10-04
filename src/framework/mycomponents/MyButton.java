package framework.mycomponents;

import javax.swing.Icon;
import javax.swing.JButton;

public class MyButton extends JButton {

	private static final long serialVersionUID = 8244526379787000637L;

	private String name;

	public MyButton() {
		super();
	}

	public MyButton(String text) {
		super(text);
	}

	public MyButton(Icon icon) {
		super(icon);
	}

	public MyButton(String text, Icon icon) {
		super(text, icon);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
