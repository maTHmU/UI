package shell.view.boxstruct;

import java.awt.Graphics;
import java.util.ArrayList;

import shell.control.boxhandler.UnderoverscriptBoxHandler;
import shell.model.document.Attribute;

public class UnderoverscriptBox extends ComponentBox {

	protected ComponentBox base;

	protected ComponentBox underscript;

	protected ComponentBox overscript;

	public UnderoverscriptBox(int orderNo) {
		super(orderNo);
	}

	public UnderoverscriptBox(GeneralBox underoverscriptBox) {
		super(underoverscriptBox.getDocument(), underoverscriptBox.parent,
				underoverscriptBox.orderNo, underoverscriptBox.arguments,
				underoverscriptBox.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		base.calculateArguments(width);
		underscript.calculateArguments(width);
		overscript.calculateArguments(width);
		arguments.height = base.arguments.height +
				overscript.arguments.height + overscript.arguments.depth;
		arguments.depth = base.arguments.depth +
				underscript.arguments.height + underscript.arguments.depth;
		arguments.width = Math.max(base.arguments.width, Math.max(
				underscript.arguments.width, overscript.arguments.width));

		base.arguments.posX = (arguments.width - base.arguments.width) / 2;
		base.arguments.posY = overscript.arguments.height +
				overscript.arguments.depth;
		underscript.arguments.posX = (arguments.width - underscript.arguments.width) / 2;
		underscript.arguments.posY = overscript.arguments.height +
				overscript.arguments.depth + base.arguments.height + base.arguments.depth;
		overscript.arguments.posX = (arguments.width - overscript.arguments.width) / 2;
		overscript.arguments.posY = 0;
	}

	@Override
	public void changeStructure() {
		if (base == null) {
			parent.removeChild(orderNo);
		} else if (underscript == null) {
			OverscriptBox overscriptBox = new OverscriptBox(this);
			overscriptBox.setChild(0, base);
			overscriptBox.setChild(1, overscript);
			parent.setChild(orderNo, overscriptBox);
		} else if (overscript == null) {
			UnderscriptBox underscriptBox = new UnderscriptBox(this);
			underscriptBox.setChild(0, base);
			underscriptBox.setChild(1, underscript);
			parent.setChild(orderNo, underscriptBox);
		}
	}

	@Override
	public GeneralBox generateCopy() {
		UnderoverscriptBox newSubsuperscriptBox = new UnderoverscriptBox(this);
		return newSubsuperscriptBox;
	}

	@Override
	public void generateHandler() {
		handler = new UnderoverscriptBoxHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		ArrayList<GeneralBox> children = new ArrayList<GeneralBox>();
		children.add(base);
		children.add(underscript);
		children.add(overscript);
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
		} else if (underscript.isPointInside(x, y)) {
			return underscript.locate(x, y);
		} else if (overscript.isPointInside(x, y)) {
			return overscript.locate(x, y);
		} else {
			return this;
		}
	}

	@Override
	public void paintBox(Graphics g) {
		base.paintBox(g);
		underscript.paintBox(g);
		overscript.paintBox(g);
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
				underscript = null;
				changeStructure();
			} else if (no == 2) {
				overscript = null;
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
				underscript = (ComponentBox)childBox;
			} else if (no == 2) {
				overscript = (ComponentBox)childBox;
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

	public ComponentBox getUnderscript() {
		return underscript;
	}

	public void setUnderscript(ComponentBox underscript) {
		this.underscript = underscript;
	}

	public ComponentBox getOverscript() {
		return overscript;
	}

	public void setOverscript(ComponentBox overscript) {
		this.overscript = overscript;
	}

}
