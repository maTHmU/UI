package shell.view.boxstruct;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import shell.control.boxhandler.GeneralBoxHandler;
import shell.control.event.BoxEvent;
import shell.model.document.Attribute;
import shell.model.document.AttributeSet;
import shell.model.document.Document;
import shell.view.boxconstructor.stylesheetparser.StyleSheetParser;

public abstract class GeneralBox {

	protected Document document;

	protected GeneralBox parent;

	protected int orderNo;

	protected BoxArguments arguments;

	protected GlobalAttributes attributes;

	protected int cursor;

	protected int focus;

	protected GeneralBox focusBox;

	protected GeneralBoxHandler handler;

	public GeneralBox(int orderNo) {
		this(null, null, orderNo, new BoxArguments(), new GlobalAttributes());
	}

	public GeneralBox(int orderNo, Document document, GeneralBox parent) {
		this(document, parent, orderNo, new BoxArguments(), new GlobalAttributes());
	}

	public GeneralBox(Document document, GeneralBox parent, int orderNo,
			BoxArguments arguments, GlobalAttributes attributes) {
		this.document = document;
		this.parent = parent;
		this.orderNo = orderNo;
		this.arguments = new BoxArguments(arguments);
		this.attributes = new GlobalAttributes(attributes);
		this.cursor = 0;
		initFocus();
		generateHandler();
	}

	public void parseAttributes(StyleSheetParser styleSheetParser) {
		if (parent != null) {
			attributes = parent.getAttributes().generateCopy();
		}
		if (document != null) {
			parseKeyAttributeSet(document.getAttributeSet());
			parseAttributeSet(styleSheetParser.getAttributeSet(this));
			parseAttributeSet(document.getAttributeSet());
		}
	}

	private void parseKeyAttributeSet(AttributeSet attributeSet) {
		Iterator<Attribute> it = attributeSet.getAttributes().listIterator();
		while (it.hasNext()) {
			Attribute attribute = it.next();
			parseKeyLocalAttribute(attribute);
		}
	}

	private void parseAttributeSet(AttributeSet attributeSet) {
		Iterator<Attribute> it = attributeSet.getAttributes().listIterator();
		while (it.hasNext()) {
			Attribute attribute = it.next();
			if (attribute.isGlobal()) {
				parseGlobalAttribute(attribute);
			} else {
				parseLocalAttribute(attribute);
			}
		}
	}

	public void parseGlobalAttribute(Attribute attribute) {
		attributes.parseAttribute(attribute);
	}

	public void applyTranslation() {
		ArrayList<GeneralBox> children = getChildren();
		Iterator<GeneralBox> it = children.listIterator();
		while (it.hasNext()) {
			GeneralBox box = it.next();
			box.arguments.posX += arguments.posX;
			box.arguments.posY += arguments.posY;
			box.applyTranslation();
		}
	}

	public boolean isPointInside(int x, int y) {
		int tx = x - arguments.posX;
		int ty = y - arguments.posY;
		return (tx >= 0 && tx < arguments.width &&
				ty >= 0 && ty < arguments.height + arguments.depth);
	}

	protected GeneralBox getBoxRoot() {
		return document.getShellFile().getBoxRoot();
	}

	protected void initFocus() {
		focus = -1;
		focusBox = null;
	}

	protected void setFocusAt(int no, GeneralBox box) {
		focus = no;
		focusBox = box;
	}

	protected GeneralBox getFinalFocus() {
		if (focusBox == null) {
			return this;
		} else {
			return focusBox.getFinalFocus();
		}
	}

	protected void requestFocus() {
		setFirstNodeAsFocus();
		GeneralBox currentBox = this;
		while (true) {
			GeneralBox parentBox = currentBox.parent;
			if (parentBox == null) {
				break;
			} else {
				parentBox.setFocusAt(currentBox.orderNo, currentBox);
				currentBox = parentBox;
			}
		}
	}

	protected void releaseFocus() {
		initFocus();
		GeneralBox currentBox = this;
		while (true) {
			GeneralBox parentBox = currentBox.parent;
			if (parentBox == null) {
				break;
			} else {
				parentBox.initFocus();
				currentBox = parentBox;
			}
		}
	}

	public void processEvent(BoxEvent event) {
		GeneralBox finalFocus = null;
		if (event.isTypingEvent()) {
			finalFocus = getFinalFocus();
		} else if (event.isControlEvent()) {
			finalFocus = getFinalFocus();
		} else if (event.isClickEvent()) {
			Point currentLocation = event.getCurrentLocation();
			finalFocus = locate(currentLocation.x, currentLocation.y);
		}
		if (finalFocus != null) {
			finalFocus.getHandler().process(event);
		}
	}

	public abstract void calculateArguments(int width);

	public abstract void changeStructure();

	public abstract GeneralBox generateCopy();

	public abstract void generateHandler();

	public abstract ArrayList<GeneralBox> getChildren();

	public abstract ArrayList<String> getFingerprint();

	public abstract GeneralBox locate(int x, int y);

	public abstract void paintBox(Graphics g);

	public abstract void parseKeyLocalAttribute(Attribute attribute);

	public abstract void parseLocalAttribute(Attribute attribute);

	public abstract void removeChild(int no);

	public abstract void setChild(int no, GeneralBox childBox);

	public abstract void setFirstNodeAsFocus();

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public GeneralBox getParent() {
		return parent;
	}

	public void setParent(GeneralBox parent) {
		this.parent = parent;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public BoxArguments getArguments() {
		return arguments;
	}

	public void setArguments(BoxArguments arguments) {
		this.arguments = arguments;
	}

	public GlobalAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(GlobalAttributes attributes) {
		this.attributes = attributes;
	}

	public int getCursor() {
		return cursor;
	}

	public void setCursor(int cursor) {
		this.cursor = cursor;
	}

	public int getFocus() {
		return focus;
	}

	public void setFocus(int focus) {
		this.focus = focus;
	}

	public GeneralBox getFocusBox() {
		return focusBox;
	}

	public void setFocusBox(GeneralBox focusBox) {
		this.focusBox = focusBox;
	}

	public GeneralBoxHandler getHandler() {
		return handler;
	}

	public void setHandler(GeneralBoxHandler handler) {
		this.handler = handler;
	}

}
