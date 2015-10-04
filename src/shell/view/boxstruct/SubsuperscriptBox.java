package shell.view.boxstruct;

import java.awt.Graphics;
import java.util.ArrayList;

import shell.control.boxhandler.SubsuperscriptBoxHandler;
import shell.model.document.Attribute;

public class SubsuperscriptBox extends ComponentBox {

	protected ComponentBox base;

	protected ComponentBox subscript;

	protected ComponentBox superscript;

	public SubsuperscriptBox(int orderNo) {
		super(orderNo);
	}

	public SubsuperscriptBox(GeneralBox subsuperscriptBox) {
		super(subsuperscriptBox.getDocument(), subsuperscriptBox.parent,
				subsuperscriptBox.orderNo, subsuperscriptBox.arguments,
				subsuperscriptBox.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		base.calculateArguments(width);
		subscript.calculateArguments(width);
		superscript.calculateArguments(width);
		arguments.height = base.arguments.height +
				superscript.arguments.height + superscript.arguments.depth;
		arguments.depth = base.arguments.depth +
				subscript.arguments.height + subscript.arguments.depth;
		arguments.width = base.arguments.width + Math.max(
				subscript.arguments.width, superscript.arguments.width);

		base.arguments.posX = 0;
		base.arguments.posY = superscript.arguments.height +
				superscript.arguments.depth;
		subscript.arguments.posX = base.arguments.width;
		subscript.arguments.posY = superscript.arguments.height +
				superscript.arguments.depth + base.arguments.height + base.arguments.depth;
		superscript.arguments.posX = base.arguments.width;
		superscript.arguments.posY = 0;
	}

	@Override
	public void changeStructure() {
		if (base == null) {
			parent.removeChild(orderNo);
		} else if (subscript == null) {
			SuperscriptBox superscriptBox = new SuperscriptBox(this);
			superscriptBox.setChild(0, base);
			superscriptBox.setChild(1, superscript);
			parent.setChild(orderNo, superscriptBox);
		} else if (superscript == null) {
			SubscriptBox subscriptBox = new SubscriptBox(this);
			subscriptBox.setChild(0, base);
			subscriptBox.setChild(1, subscript);
			parent.setChild(orderNo, subscriptBox);
		}
	}

	@Override
	public GeneralBox generateCopy() {
		SubsuperscriptBox newSubsuperscriptBox = new SubsuperscriptBox(this);
		return newSubsuperscriptBox;
	}

	@Override
	public void generateHandler() {
		handler = new SubsuperscriptBoxHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		ArrayList<GeneralBox> children = new ArrayList<GeneralBox>();
		children.add(base);
		children.add(subscript);
		children.add(superscript);
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
		} else if (subscript.isPointInside(x, y)) {
			return subscript.locate(x, y);
		} else if (superscript.isPointInside(x, y)) {
			return superscript.locate(x, y);
		} else {
			return this;
		}
	}

	@Override
	public void paintBox(Graphics g) {
		base.paintBox(g);
		subscript.paintBox(g);
		superscript.paintBox(g);
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
				subscript = null;
				changeStructure();
			} else if (no == 2) {
				superscript = null;
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
				subscript = (ComponentBox)childBox;
			} else if (no == 2) {
				superscript = (ComponentBox)childBox;
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

	public ComponentBox getSubscript() {
		return subscript;
	}

	public void setSubscript(ComponentBox subscript) {
		this.subscript = subscript;
	}

	public ComponentBox getSuperscript() {
		return superscript;
	}

	public void setSuperscript(ComponentBox superscript) {
		this.superscript = superscript;
	}

}
