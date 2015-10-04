package shell.view.boxstruct;

import java.awt.Graphics;
import java.util.ArrayList;

import shell.control.boxhandler.OverscriptBoxHandler;
import shell.model.document.Attribute;

public class OverscriptBox extends ComponentBox {

	protected ComponentBox base;

	protected ComponentBox script;

	public OverscriptBox(int orderNo) {
		super(orderNo);
	}

	public OverscriptBox(GeneralBox overscriptBox) {
		super(overscriptBox.getDocument(), overscriptBox.parent,
				overscriptBox.orderNo, overscriptBox.arguments,
				overscriptBox.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		base.calculateArguments(width);
		script.calculateArguments(width);
		arguments.height = base.arguments.height +
				script.arguments.height + script.arguments.depth;
		arguments.depth = base.arguments.depth;
		arguments.width = Math.max(base.arguments.width, script.arguments.width);

		base.arguments.posX = (arguments.width - base.arguments.width) / 2;
		base.arguments.posY = script.arguments.height +	script.arguments.depth;
		script.arguments.posX = (arguments.width - script.arguments.width) / 2;
		script.arguments.posY = 0;
	}

	@Override
	public void changeStructure() {
		if (base == null) {
			parent.removeChild(orderNo);
		} else if (script == null) {
			parent.setChild(orderNo, base);
		}
	}

	@Override
	public GeneralBox generateCopy() {
		OverscriptBox newOverscriptBox = new OverscriptBox(this);
		return newOverscriptBox;
	}

	@Override
	public void generateHandler() {
		handler = new OverscriptBoxHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		ArrayList<GeneralBox> children = new ArrayList<GeneralBox>();
		children.add(base);
		children.add(script);
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
		} else if (script.isPointInside(x, y)) {
			return script.locate(x, y);
		} else {
			return this;
		}
	}

	@Override
	public void paintBox(Graphics g) {
		base.paintBox(g);
		script.paintBox(g);
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
				script = null;
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
				changeStructure();
			} else if (no == 1) {
				script = (ComponentBox)childBox;
				changeStructure();
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

	public ComponentBox getScript() {
		return script;
	}

	public void setScript(ComponentBox script) {
		this.script = script;
	}

}
