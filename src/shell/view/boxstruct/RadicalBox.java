package shell.view.boxstruct;

import java.awt.Graphics;
import java.util.ArrayList;

import shell.control.boxhandler.RadicalBoxHandler;
import shell.model.document.Attribute;

public class RadicalBox extends ComponentBox {

	protected ComponentBox base;

	protected ComponentBox index;

	public RadicalBox(int orderNo) {
		super(orderNo);
	}

	public RadicalBox(ComponentBox radicalBox) {
		super(radicalBox.getDocument(), radicalBox.parent, radicalBox.orderNo,
				radicalBox.arguments, radicalBox.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStructure() {
		if (base == null) {
			parent.setChild(orderNo, new StringBox(this));
		} else if (index == null) {
			SqrtBox sqrtBox = new SqrtBox(this);
			sqrtBox.setChild(0, base);
			parent.setChild(orderNo, sqrtBox);
		}
	}

	@Override
	public GeneralBox generateCopy() {
		RadicalBox newRadicalBox = new RadicalBox(this);
		return newRadicalBox;
	}

	@Override
	public void generateHandler() {
		handler = new RadicalBoxHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		ArrayList<GeneralBox> children = new ArrayList<GeneralBox>();
		children.add(base);
		children.add(index);
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
		if (base.isPointInside(x, y)) {
			return base.locate(x, y);
		} else if (index.isPointInside(x, y)) {
			return index.locate(x, y);
		} else {
			return this;
		}
	}

	@Override
	public void paintBox(Graphics g) {
		base.paintBox(g);
		index.paintBox(g);
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
				base = null;
				changeStructure();
			} else if (no == 1) {
				index = null;
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
				base = (ComponentBox)childBox;
			} else if (no == 1) {
				index = (ComponentBox)childBox;
			} else {
				throw(new Exception("Invalid child index."));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setFirstNodeAsFocus() {
		setFocusAt(0, base);
		base.setFirstNodeAsFocus();
	}

	public ComponentBox getBase() {
		return base;
	}

	public void setBase(ComponentBox base) {
		this.base = base;
	}

	public ComponentBox getIndex() {
		return index;
	}

	public void setIndex(ComponentBox index) {
		this.index = index;
	}

}
