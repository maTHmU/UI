package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.SqrtBox;

public class SqrtBoxHandler extends ComponentBoxHandler {

	private SqrtBox sqrtBox;

	public SqrtBoxHandler(SqrtBox sqrtBox) {
		this.sqrtBox = sqrtBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public SqrtBox getSqrtBox() {
		return sqrtBox;
	}

	public void setSqrtBox(SqrtBox sqrtBox) {
		this.sqrtBox = sqrtBox;
	}

}
