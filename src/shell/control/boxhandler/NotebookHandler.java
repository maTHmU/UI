package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.Notebook;

public class NotebookHandler extends GeneralBoxHandler {

	private Notebook notebook;

	public NotebookHandler(Notebook notebook) {
		this.notebook = notebook;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

}
