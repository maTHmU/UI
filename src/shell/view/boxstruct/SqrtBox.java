package shell.view.boxstruct;

import java.awt.Graphics;
import java.util.ArrayList;

import shell.control.boxhandler.SqrtBoxHandler;
import shell.model.document.Attribute;

public class SqrtBox extends ComponentBox {

	protected ComponentBox base;

	public SqrtBox(int orderNo) {
		super(orderNo);
	}

	public SqrtBox(GeneralBox sqrtBox) {
		super(sqrtBox.getDocument(), sqrtBox.parent, sqrtBox.orderNo,
				sqrtBox.arguments, sqrtBox.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeStructure() {
		if (base == null) {
			parent.setChild(orderNo, new StringBox(this));
		}
	}

	@Override
	public GeneralBox generateCopy() {
		SqrtBox sqrtBox = new SqrtBox(this);
		return sqrtBox;
	}

	@Override
	public void generateHandler() {
		handler = new SqrtBoxHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		ArrayList<GeneralBox> children = new ArrayList<GeneralBox>();
		children.add(base);
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
		} else {
			return this;
		}
	}

	@Override
	public void paintBox(Graphics g) {
		base.paintBox(g);
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

}
