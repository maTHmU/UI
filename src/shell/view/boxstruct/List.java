package shell.view.boxstruct;

import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Iterator;

import shell.control.boxhandler.ListHandler;
import shell.model.document.Attribute;
import shell.model.document.Document;

public class List extends ComponentBox {

	protected ArrayList<GeneralBox> boxes;

	public List(int orderNo) {
		super(orderNo);
		initBoxSize();
	}

	public List(GeneralBox list) {
		super(list.getDocument(), list.parent, list.orderNo,
				list.arguments, list.attributes);
		initBoxSize();
	}

	private void initBoxSize() {
		boxes = new ArrayList<GeneralBox>();
		if (document != null) {
			int size = document.getChildren().size();
			for (int i = 0; i < size; i++) {
				boxes.add(null);
			}
		}
	}

	public void setDocument(Document document) {
		this.document = document;
		initBoxSize();
	}

	@Override
	public void calculateArguments(int width) {
		Iterator<GeneralBox> it = boxes.listIterator();
		arguments.height = 0;
		arguments.depth = 0;
		while (it.hasNext()) {
			GeneralBox box = it.next();
			box.calculateArguments(width);
			if (arguments.height < box.arguments.height) {
				arguments.height = box.arguments.height;
			}
			if (arguments.depth < box.arguments.depth) {
				arguments.depth = box.arguments.depth;
			}
		}
		it = boxes.listIterator();
		arguments.width = 0;
		while (it.hasNext()) {
			GeneralBox box = it.next();
			box.arguments.posX = arguments.width;
			box.arguments.posY = arguments.height - box.arguments.height;
			arguments.width += box.arguments.width;
		}
	}

	@Override
	public void changeStructure() {
		if (getBoxCount() <= 1) {
			parent.changeStructure();
		}
	}

	@Override
	public GeneralBox generateCopy() {
		List newList = new List(this);
		return newList;
	}

	@Override
	public void generateHandler() {
		handler = new ListHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		return boxes;
	}

	@Override
	public ArrayList<String> getFingerprint() {
		ArrayList<String> fingerprint = new ArrayList<String>();
		fingerprint.add(document.getTag().getName());
		return fingerprint;
	}

	@Override
	public GeneralBox locate(int x, int y) {
		Iterator<GeneralBox> it = boxes.listIterator();
		while (it.hasNext()) {
			GeneralBox box = it.next();
			if (box.isPointInside(x, y)) {
				return box.locate(x, y);
			}
		}
		return this;
	}

	@Override
	public void paintBox(Graphics g) {
		Iterator<GeneralBox> it = boxes.listIterator();
		while (it.hasNext()) {
			GeneralBox box = it.next();
			box.paintBox(g);
		}
	}

	@Override
	public void parseKeyLocalAttribute(Attribute attribute) {
		
	}

	@Override
	public void parseLocalAttribute(Attribute attribute) {
		
	}

	@Override
	public void removeChild(int no) {
		try {
			if (no >= 0 && no < getBoxCount()) {
				boxes.remove(no);
				changeStructure();
			} else {
				throw(new Exception("Invalid child index."));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setChild(int no, GeneralBox childBox) {
		// TODO 此处其实应该是调用true 但是这里临时采用这样的方案 应当改正
		insertChild(no, childBox, true);
	}

	@Override
	public void setFirstNodeAsFocus() {
		if (boxes.size() == 0) {
			setFocusAt(0, null);
		} else {
			setFocusAt(0, boxes.get(0));
		}
	}

	public void addChild(GeneralBox childBox) {
		insertChild(boxes.size(), childBox, false);
	}

	public void addChild(int no, GeneralBox childBox) {
		insertChild(no, childBox, false);
	}

	public void clearChild() {
		boxes.clear();
	}

	public void insertChild(int no, GeneralBox childBox, boolean overwrite) {
		try {
			if (no >= 0 && no < boxes.size()) {
				if (overwrite) {
					boxes.set(no, childBox);
				} else {
					boxes.add(no, childBox);
				}
			} else if (no == boxes.size()) {
				if (overwrite) {
					throw(new Exception("Invalid child index."));
				} else {
					boxes.add(childBox);
				}
			} else {
				throw(new Exception("Invalid child index."));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<GeneralBox> getBoxes() {
		return boxes;
	}

	public int getBoxCount() {
		return boxes.size();
	}

	public GeneralBox getBox(int no) {
		return boxes.get(no);
	}

}
