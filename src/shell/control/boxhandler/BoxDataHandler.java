package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.BoxData;

public class BoxDataHandler extends DataBoxHandler {

	private BoxData boxData;

	public BoxDataHandler(BoxData boxData) {
		this.boxData = boxData;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public BoxData getBoxData() {
		return boxData;
	}

	public void setBoxData(BoxData boxData) {
		this.boxData = boxData;
	}

}
