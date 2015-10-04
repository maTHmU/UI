package shell.view.boxconstructor.stylesheetparser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import common.FilePaths;

import shell.ShellFile;
import shell.model.document.AttributeSet;
import shell.model.document.Document;
import shell.view.boxstruct.GeneralBox;

public class StyleSheetParser {

	private static final String CELL_LABEL = "Cell";

	private static final String DATA_LABEL = "BoxData";

	private static final String GROUP_LABEL = "CellGroupData";

	private static final String GROUP_MARK = "$" + GROUP_LABEL;

	private ShellFile shellFile;

	private String filePath;

	private StyleTreeNode styleRoot;

	protected static Stack<StyleTreeNode> stack;

	protected static int depth;

	public StyleSheetParser(ShellFile shellFile, String filename) {
		this.shellFile = shellFile;
		this.filePath = FilePaths.STYLESHEET_PATH.concat(filename);
		parseStyleSheet();
	}

	private void parseStyleSheet() {
		Document document = shellFile.getParserManager().parse(filePath);
		this.styleRoot = new StyleTreeNode(document);
		stack = new Stack<StyleTreeNode>();
		depth = 0;
		stack.push(styleRoot);
		constructStyleTree(document);
	}

	private StyleTreeNode constructStyleTree(Document document) {
		Iterator<Document> it = document.getChildren().listIterator();
		while (it.hasNext()) {
			Document childDocument = it.next();
			String value = getDocumentValue(childDocument);
			if (value == null) {
				constructStyleTree(childDocument);
			} else if (value.equals(GROUP_MARK)) {
				depth++;
				constructStyleTree(childDocument);
				depth--;
			} else {
				StyleTreeNode childNode = new StyleTreeNode(childDocument);
				if (stack.size() <= depth) {
					stack.add(childNode);
				} else {
					stack.set(depth, childNode);
				}
				stack.get(depth - 1).children.add(childNode);
				stack.get(depth - 1).nodeMap.put(value, childNode);
			}
		}
		return null;
	}

	private String getDocumentValue(Document document) {
		if (document.getTag().getName().equals(CELL_LABEL)) {
			Document data = document.getChild(0);
			if (data.getTag().getName().equals(DATA_LABEL)) {
				return data.getChild(0).getAttributeValueByName("Text");
			} else {
				return null;
			}
		} else if (document.getTag().getName().equals(GROUP_LABEL)) {
			return GROUP_MARK;
		} else {
			return null;
		}
	}

	public AttributeSet getAttributeSet(GeneralBox box) {
		ArrayList<String> fingerprint = box.getFingerprint();
		return styleRoot.getAttributeSet(fingerprint, 0);
	}

	public ShellFile getShellFile() {
		return shellFile;
	}

	public void setShellFile(ShellFile shellFile) {
		this.shellFile = shellFile;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public StyleTreeNode getStyleRoot() {
		return styleRoot;
	}

	public void setStyleRoot(StyleTreeNode styleRoot) {
		this.styleRoot = styleRoot;
	}

}
