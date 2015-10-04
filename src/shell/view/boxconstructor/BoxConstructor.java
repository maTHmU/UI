package shell.view.boxconstructor;

import java.util.Iterator;

import shell.ShellFile;
import shell.model.document.Document;
import shell.view.boxconstructor.stylesheetparser.StyleSheetParser;
import shell.view.boxstruct.GeneralBox;

public class BoxConstructor {

	private static final String STYLESHEET_ATTRIBUTE_NAME = "DefaultStyle";

	private ShellFile shellFile;

	private BoxFactory boxFactory;

	private StyleSheetParser stylesheetParser;

	public BoxConstructor(ShellFile shellFile, Document document) {
		this(shellFile, new BoxFactory(), new StyleSheetParser(shellFile,
				document.getAttributeValueByName(STYLESHEET_ATTRIBUTE_NAME)));
	}

	public BoxConstructor(ShellFile shellFile, BoxFactory boxFactory,
			StyleSheetParser styleSheetParser) {
		this.shellFile = shellFile;
		this.boxFactory = boxFactory;
		this.stylesheetParser = styleSheetParser;
	}

	public GeneralBox constructStruct(Document document) {
		GeneralBox box = boxFactory.getBoxFromDocument(document);
		Iterator<Document> it = document.getChildren().listIterator();
		int no = 0;
		while (it.hasNext()) {
			GeneralBox childBox = constructStruct(it.next());
			childBox.setParent(box);
			childBox.setOrderNo(no);
			box.setChild(no, childBox);
			no++;
		}
		return box;
	}

	public void parseAttributes(GeneralBox box) {
		box.parseAttributes(stylesheetParser);
		Iterator<GeneralBox> it = box.getChildren().listIterator();
		while (it.hasNext()) {
			GeneralBox childBox = it.next();
			parseAttributes(childBox);
		}
	}

	public ShellFile getShellFile() {
		return shellFile;
	}

	public BoxFactory getBoxFactory() {
		return boxFactory;
	}

	public StyleSheetParser getCSSParser() {
		return stylesheetParser;
	}

}
