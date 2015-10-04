package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.StringBox;

public class StringBoxHandler extends GeneralBoxHandler {

	private StringBox stringBox;

	public StringBoxHandler(StringBox stringBox) {
		this.stringBox = stringBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public StringBox getStringBox() {
		return stringBox;
	}

	public void setStringBox(StringBox stringBox) {
		this.stringBox = stringBox;
	}

}
