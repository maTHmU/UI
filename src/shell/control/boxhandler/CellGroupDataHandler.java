package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.CellGroupData;

public class CellGroupDataHandler extends DataBoxHandler {

	private CellGroupData cellGroupData;

	public CellGroupDataHandler(CellGroupData cellGroupData) {
		this.cellGroupData = cellGroupData;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public CellGroupData getCellGroupData() {
		return cellGroupData;
	}

	public void setCellGroupData(CellGroupData cellGroupData) {
		this.cellGroupData = cellGroupData;
	}

}
