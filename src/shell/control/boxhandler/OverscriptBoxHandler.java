package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.OverscriptBox;

public class OverscriptBoxHandler extends ComponentBoxHandler {

	private OverscriptBox overscriptBox;

	public OverscriptBoxHandler(OverscriptBox overscriptBox) {
		this.overscriptBox = overscriptBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public OverscriptBox getOverscriptBox() {
		return overscriptBox;
	}

	public void setOverscriptBox(OverscriptBox overscriptBox) {
		this.overscriptBox = overscriptBox;
	}

}
