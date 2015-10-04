package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.FractionBox;

public class FractionBoxHandler extends ComponentBoxHandler {

	private FractionBox fractionBox;

	public FractionBoxHandler(FractionBox fractionBox) {
		this.fractionBox = fractionBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public FractionBox getFractionBox() {
		return fractionBox;
	}

	public void setFractionBox(FractionBox fractionBox) {
		this.fractionBox = fractionBox;
	}

}
