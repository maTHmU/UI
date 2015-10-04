package shell.model.document;

import java.util.ArrayList;

import shell.ShellFile;

public class Document {

	private ShellFile shellFile;

	private Document parent;

	private ArrayList<Document> children;

	private Tag tag;

	private AttributeSet attributeSet;

	public Document() {
		this.shellFile = null;
		this.parent = null;
		this.children = new ArrayList<Document>();
		this.tag = null;
		this.attributeSet = new AttributeSet();
	}

	public Document(ShellFile shellFile) {
		this();
		setShellFile(shellFile);
	}

	public Document(ShellFile shellFile, String tagName) {
		this();
		setShellFile(shellFile);
		setTag(tagName);
	}

	@Override
	public String toString() {
		// TODO: this is just a checking version.
		StringBuffer buffer = new StringBuffer();
		buffer.append(tag.getName());
		buffer.append("[");
		for (int i = 0; i < children.size(); i++) {
			buffer.append(children.get(i).toString());
		}
		buffer.append("]");
		int count = attributeSet.getAttributeCount();
		if (count > 0) {
			buffer.append("<");
			for (int i = 0; i < count; i++) {
				buffer.append(attributeSet.getAttribute(i).toString());
			}
			buffer.append(">");
		}
		return buffer.toString();
	}

	public void setShellFile(ShellFile shellFile) {
		this.shellFile = shellFile;
	}

	public ShellFile getShellFile() {
		return shellFile;
	}

	public void setParent(Document parent) {
		this.parent = parent;
	}

	public Document getParent() {
		return parent;
	}

	public void addChild(Document document) {
		children.add(document);
		document.setParent(this);
	}

	public ArrayList<Document> getChildren() {
		return children;
	}

	public Document getChild(int no) {
		return children.get(no);
	}

	public boolean isRootDocument() {
		return parent == null;
	}

	public void setTag(String tagName) {
		this.tag = new Tag(Tag.tagMap.get(tagName));
	}

	public Tag getTag() {
		return tag;
	}

	public void addAttribute(String attributeName, String attributeValue) {
		Attribute attribute = new Attribute(Attribute.attributeMap.get(attributeName), attributeValue);
		attributeSet.addAttribute(attribute);
	}

	public String getAttributeValueByName(String name) {
		return attributeSet.getValueByName(name);
	}

	public AttributeSet getAttributeSet() {
		return attributeSet;
	}

}
