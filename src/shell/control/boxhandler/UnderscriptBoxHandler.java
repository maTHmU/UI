package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.UnderscriptBox;

public class UnderscriptBoxHandler extends ComponentBoxHandler {

	private UnderscriptBox underscriptBox;

	public UnderscriptBoxHandler(UnderscriptBox underscriptBox) {
		this.underscriptBox = underscriptBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public UnderscriptBox getUnderscriptBox() {
		return underscriptBox;
	}

	public void setUnderscriptBox(UnderscriptBox underscriptBox) {
		this.underscriptBox = underscriptBox;
	}

}
