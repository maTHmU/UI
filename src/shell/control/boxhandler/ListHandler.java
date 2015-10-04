package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.List;

public class ListHandler extends GeneralBoxHandler {

	private List list;

	public ListHandler(List list) {
		this.list = list;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
