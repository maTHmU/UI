package shell.view.boxstruct;

import java.awt.Graphics;
import java.util.ArrayList;

import shell.control.boxhandler.RowBoxHandler;
import shell.model.document.Attribute;

public class RowBox extends ComponentBox {

	protected List list;

	public RowBox(int orderNo) {
		super(orderNo);
	}

	public RowBox(GeneralBox rowBox) {
		super(rowBox.getDocument(), rowBox.parent, rowBox.orderNo,
				rowBox.arguments, rowBox.attributes);
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
		} else if (list.getBoxCount() == 1) {
			parent.setChild(0, list.getBox(0));
		}
	}

	@Override
	public GeneralBox generateCopy() {
		RowBox newRowBox = new RowBox(this);
		return newRowBox;
	}

	@Override
	public void generateHandler() {
		handler = new RowBoxHandler(this);
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
		list.paintBox(g);
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
