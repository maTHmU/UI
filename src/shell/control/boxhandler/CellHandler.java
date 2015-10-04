package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.Cell;

public class CellHandler extends StructBoxHandler {

	private Cell cell;

	public CellHandler(Cell cell) {
		this.cell = cell;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

}
