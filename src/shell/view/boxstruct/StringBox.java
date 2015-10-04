package shell.view.boxstruct;

import java.awt.Graphics;
import java.util.ArrayList;

import shell.control.boxhandler.StringBoxHandler;
import shell.model.document.Attribute;

public class StringBox extends ComponentBox {

	protected List list;

	public StringBox(int orderNo) {
		super(orderNo);
	}

	public StringBox(GeneralBox stringBox) {
		super(stringBox.getDocument(), stringBox.parent, stringBox.orderNo,
				stringBox.arguments, stringBox.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		list.calculateArguments(width);
		arguments = list.arguments.clone();
		list.arguments.posX = 0;
		list.arguments.posY = 0;
	}

	@Override
	public void changeStructure() {
		if (list == null) {
			parent.removeChild(orderNo);
		} else if (list.getBoxCount() == 0) {
			parent.removeChild(orderNo);
		}
	}

	@Override
	public GeneralBox generateCopy() {
		StringBox newStringBox = new StringBox(this);
		return newStringBox;
	}

	@Override
	public void generateHandler() {
		handler = new StringBoxHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		ArrayList<GeneralBox> children = new ArrayList<GeneralBox>();
		children.add(list);
		return children;
	}

	@Override
	public ArrayList<String> getFingerprint() {
		ArrayList<String> fingerprint = new ArrayList<String>();
		fingerprint.add(document.getTag().getName());
		return fingerprint;
	}

	@Override
	public GeneralBox locate(int x, int y) {
		if (list.isPointInside(x, y)) {
			return list.locate(x, y);
		} else {
			return this;
		}
	}

	@Override
	public void paintBox(Graphics g) {
		g.setFont(attributes.font);
		list.paintBox(g);
	}

	@Override
	public void parseKeyLocalAttribute(Attribute attribute) {
		String name = attribute.getName();
		String value = attribute.getValue();
		if (name.equals("Text")) {
			list = new List(0);
			list.parent = this;
			list.clearChild();
			for (int i = 0; i < value.length(); i++) {
				CharBox charBox = new CharBox(i);
				charBox.parent = list;
				charBox.setLetter(value.charAt(i));
				list.addChild(charBox);
			}
			setChild(0, list);
		}
	}

	@Override
	public void parseLocalAttribute(Attribute attribute) {
		
	}

	@Override
	public void removeChild(int no) {
		try {
			if (no == 0) {
				list = null;
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
		try {
			if (no == 0) {
				list = (List)childBox;
				if (list == null) {
					throw(new Exception("Invalid child type."));
				}
			} else {
				throw(new Exception("Invalid child index."));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setFirstNodeAsFocus() {
		setFocusAt(0, list);
		list.setFirstNodeAsFocus();
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
