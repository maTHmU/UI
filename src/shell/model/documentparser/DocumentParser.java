package shell.model.documentparser;

import java.io.Reader;

import shell.model.document.Document;

public abstract class DocumentParser {

	protected ParserManager parserManager;

	protected int priority;

	public abstract Document parseFile(String filePath);

	public abstract Document parseFile(Reader reader);

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

}
