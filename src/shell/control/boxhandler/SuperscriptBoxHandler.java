package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.SuperscriptBox;

public class SuperscriptBoxHandler extends ComponentBoxHandler {

	private SuperscriptBox superscriptBox;

	public SuperscriptBoxHandler(SuperscriptBox superscriptBox) {
		this.superscriptBox = superscriptBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public SuperscriptBox getSuperscriptBox() {
		return superscriptBox;
	}

	public void setSuperscriptBox(SuperscriptBox superscriptBox) {
		this.superscriptBox = superscriptBox;
	}

}
