package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.UnderoverscriptBox;

public class UnderoverscriptBoxHandler extends ComponentBoxHandler {

	private UnderoverscriptBox underoverscriptBox;

	public UnderoverscriptBoxHandler(UnderoverscriptBox underoverscriptBox) {
		this.underoverscriptBox = underoverscriptBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public UnderoverscriptBox getUnderoverscriptBox() {
		return underoverscriptBox;
	}

	public void setUnderoverscriptBox(UnderoverscriptBox underoverscriptBox) {
		this.underoverscriptBox = underoverscriptBox;
	}

}
