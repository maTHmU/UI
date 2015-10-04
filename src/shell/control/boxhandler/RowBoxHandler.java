package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.RowBox;

public class RowBoxHandler extends GeneralBoxHandler {

	private RowBox rowBox;

	public RowBoxHandler(RowBox rowBox) {
		
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public RowBox getRowBox() {
		return rowBox;
	}

	public void setRowBox(RowBox rowBox) {
		this.rowBox = rowBox;
	}

}
