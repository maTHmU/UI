package shell;

import java.awt.Graphics;

import framework.maintabbedpane.TextPanel;

import shell.control.event.InputState;
import shell.model.document.Document;
import shell.model.documentparser.DocumentParser;
import shell.model.documentparser.ParserManager;
import shell.view.boxconstructor.BoxConstructor;
import shell.view.boxpainter.BoxPainter;
import shell.view.boxstruct.GeneralBox;

public class ShellFile {

	private TextPanel textPanel;

	private ParserManager parserManager;

	private Document document;

	private DocumentParser documentParser;

	private GeneralBox boxRoot;

	private BoxConstructor boxConstructor;

	private BoxPainter boxPainter;

	private InputState inputState;

	public ShellFile(TextPanel textPanel, String filePath, boolean existed) {
		this.textPanel = textPanel;

		parserManager = new ParserManager(this);
		if (existed) {
			existed = parserManager.fileExisted(filePath);
		}
		textPanel.setExisted(existed);
		document = parserManager.parse(filePath);

		update(true);

		inputState = new InputState(this);
	}

	public void update(boolean newConstructorRequired) {
		if (newConstructorRequired) {
			boxConstructor = new BoxConstructor(this, document);
			boxRoot = boxConstructor.constructStruct(document);
			boxConstructor.parseAttributes(boxRoot);
			boxRoot.setFirstNodeAsFocus();
		}
		textPanel.repaint();
	}

	public void paint(Graphics g) {
		boxPainter = new BoxPainter(boxRoot, textPanel.getWidth(),
				textPanel.getHeight());
		boxPainter.paint(g);
	}

	public TextPanel getTextPanel() {
		return textPanel;
	}

	public ParserManager getParserManager() {
		return parserManager;
	}

	public Document getDocument() {
		return document;
	}

	public DocumentParser getDocumentParser() {
		return documentParser;
	}

	public GeneralBox getBoxRoot() {
		return boxRoot;
	}

	public BoxPainter getBoxPainter() {
		return boxPainter;
	}

	public InputState getInputState() {
		return inputState;
	}

}
