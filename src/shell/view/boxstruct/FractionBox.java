package shell.view.boxstruct;

import java.awt.Graphics;
import java.util.ArrayList;

import shell.control.boxhandler.FractionBoxHandler;
import shell.model.document.Attribute;

public class FractionBox extends ComponentBox {

	protected ComponentBox numerator;

	protected ComponentBox denominator;

	public FractionBox(int orderNo) {
		super(orderNo);
	}

	public FractionBox(GeneralBox fractionBox) {
		super(fractionBox.getDocument(), fractionBox.parent, fractionBox.orderNo,
				fractionBox.arguments, fractionBox.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStructure() {
		if (numerator == null) {
			parent.setChild(orderNo, denominator);
		} else if (denominator == null) {
			parent.setChild(orderNo, numerator);
		}
	}

	@Override
	public GeneralBox generateCopy() {
		FractionBox newFractionBox = new FractionBox(this);
		return newFractionBox;
	}

	@Override
	public void generateHandler() {
		handler = new FractionBoxHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		ArrayList<GeneralBox> children = new ArrayList<GeneralBox>();
		children.add(numerator);
		children.add(denominator);
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
		if (numerator.isPointInside(x, y)) {
			return numerator.locate(x, y);
		} else if (denominator.isPointInside(x, y)) {
			return denominator.locate(x, y);
		} else {
			return this;
		}
	}

	@Override
	public void paintBox(Graphics g) {
		
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
				numerator = null;
				changeStructure();
			} else if (no == 1) {
				denominator = null;
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
				numerator = (ComponentBox)childBox;
			} else if (no == 1) {
				denominator = (ComponentBox)childBox;
			} else {
				throw(new Exception("Invalid child index."));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setFirstNodeAsFocus() {
		setFocusAt(0, numerator);
		numerator.setFirstNodeAsFocus();
	}

	public ComponentBox getNumerator() {
		return numerator;
	}

	public void setNumerator(ComponentBox numerator) {
		this.numerator = numerator;
	}

	public ComponentBox getDenominator() {
		return denominator;
	}

	public void setDenominator(ComponentBox denominator) {
		this.denominator = denominator;
	}

}
