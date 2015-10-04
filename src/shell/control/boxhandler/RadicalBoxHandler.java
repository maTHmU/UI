package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.RadicalBox;

public class RadicalBoxHandler extends ComponentBoxHandler {

	private RadicalBox radicalBox;

	public RadicalBoxHandler(RadicalBox radicalBox) {
		this.radicalBox = radicalBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public RadicalBox getRadicalBox() {
		return radicalBox;
	}

	public void setRadicalBox(RadicalBox radicalBox) {
		this.radicalBox = radicalBox;
	}

}
