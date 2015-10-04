package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.CharBox;

public class CharBoxHandler extends ComponentBoxHandler {

	private CharBox charBox;

	public CharBoxHandler(CharBox charBox) {
		this.charBox = charBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public CharBox getCharBox() {
		return charBox;
	}

	public void setCharBox(CharBox charBox) {
		this.charBox = charBox;
	}

}
