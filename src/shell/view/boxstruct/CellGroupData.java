package shell.view.boxstruct;

import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Iterator;

import shell.control.boxhandler.CellGroupDataHandler;
import shell.model.document.Attribute;

public class CellGroupData extends DataBox {

	protected List list;

	public CellGroupData(int orderNo) {
		super(orderNo);
	}

	public CellGroupData(GeneralBox cellGroupData) {
		super(cellGroupData.getDocument(), cellGroupData.parent, cellGroupData.orderNo,
				cellGroupData.arguments, cellGroupData.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		list.arguments.height = 0;
		list.arguments.depth = 0;
		list.arguments.width = width;
		Iterator<GeneralBox> it = list.boxes.listIterator();
		while (it.hasNext()) {
			GeneralBox box = it.next();
			box.calculateArguments(width);
			box.arguments.posX = 0;
			box.arguments.posY = list.arguments.height;
			list.arguments.height += box.arguments.height;
		}

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
			parent.parent.setChild(orderNo, list.getBox(0));
		}
	}

	@Override
	public GeneralBox generateCopy() {
		CellGroupData newCellGroupData = new CellGroupData(this);
		return newCellGroupData;
	}

	@Override
	public void generateHandler() {
		handler = new CellGroupDataHandler(this);
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
		// TODO Auto-generated method stub
		
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
		setFocusAt(0, null);
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
