package shell.model.documentparser;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import common.FileOperations;

import shell.ShellFile;
import shell.model.document.Document;
import shell.model.documentparser.mu.MuParser;

public class ParserManager {

	private ShellFile shellFile;

	private ArrayList<DocumentParser> parsers;

	public ParserManager(ShellFile shellFile) {
		this.shellFile = shellFile;

		parsers = new ArrayList<DocumentParser>();
		parsers.add(new MuParser(this));
	}

	public boolean fileExisted(String filePath) {
		try {
			File file = new File(filePath);
			return file.exists();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Document parse(String filePath) {
		if (FileOperations.isFileExisting(filePath)) {
			Iterator<DocumentParser> it = parsers.listIterator();
			int maxPriority = -1;
			Document result = new Document(shellFile);
			while (it.hasNext()) {
				DocumentParser parser = it.next();
				if (parser.getPriority() > maxPriority) {
					Document tempDocument = parser.parseFile(filePath);
					if (tempDocument != null) {
						result = tempDocument;
						maxPriority = parser.getPriority();
					}
				}
			}
			return result;
		} else {
			return null;
		}
	}

	public ShellFile getShellFile() {
		return shellFile;
	}

}
