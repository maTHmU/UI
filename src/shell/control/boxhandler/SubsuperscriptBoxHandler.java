package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.SubsuperscriptBox;

public class SubsuperscriptBoxHandler extends ComponentBoxHandler {

	private SubsuperscriptBox subsuperscriptBox;

	public SubsuperscriptBoxHandler(SubsuperscriptBox subsuperscriptBox) {
		this.subsuperscriptBox = subsuperscriptBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public SubsuperscriptBox getSubsuperscriptBox() {
		return subsuperscriptBox;
	}

	public void setSubsuperscriptBox(SubsuperscriptBox subsuperscriptBox) {
		this.subsuperscriptBox = subsuperscriptBox;
	}

}
