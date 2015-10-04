package shell.view.boxconstructor.stylesheetparser;

import java.util.ArrayList;
import java.util.HashMap;

import shell.model.document.AttributeSet;
import shell.model.document.Document;

public class StyleTreeNode {

	protected AttributeSet attributeSet;

	protected StyleTreeNode parent;

	protected ArrayList<StyleTreeNode> children;

	protected HashMap<String, StyleTreeNode> nodeMap;

	protected StyleTreeNode(Document document) {
		this.attributeSet = document.getAttributeSet();
		children = new ArrayList<StyleTreeNode>();
		nodeMap = new HashMap<String, StyleTreeNode>();
	}

	protected AttributeSet getAttributeSet(ArrayList<String> fingerprint, int no) {
		if (no == fingerprint.size()) {
			return attributeSet;
		}
		String value = fingerprint.get(no);
		if (nodeMap.containsKey(value)) {
			return nodeMap.get(value).getAttributeSet(fingerprint, no + 1);
		} else {
			return new AttributeSet();
		}
	}

}
