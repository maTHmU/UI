package shell.view.boxstruct;

import java.awt.Graphics;
import java.util.ArrayList;

import shell.control.boxhandler.BoxDataHandler;
import shell.model.document.Attribute;

public class BoxData extends DataBox {

	protected ComponentBox componentBox;

	public BoxData(int orderNo) {
		super(orderNo);
	}

	public BoxData(GeneralBox boxData) {
		super(boxData.getDocument(), boxData.parent, boxData.orderNo,
				boxData.arguments, boxData.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		componentBox.calculateArguments(width);
		arguments.height = componentBox.arguments.height +
			componentBox.arguments.depth;
		arguments.depth = 0;
		arguments.width = componentBox.arguments.width;

		componentBox.arguments.posX = 0;
		componentBox.arguments.posY = 0;
	}

	@Override
	public void changeStructure() {
		if (componentBox == null) {
			parent.removeChild(orderNo);
		}
	}

	@Override
	public GeneralBox generateCopy() {
		BoxData newBoxData = new BoxData(this);
		return newBoxData;
	}

	@Override
	public void generateHandler() {
		handler = new BoxDataHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		ArrayList<GeneralBox> children = new ArrayList<GeneralBox>();
		children.add(componentBox);
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
		if (componentBox.isPointInside(x, y)) {
			return componentBox.locate(x, y);
		} else {
			return this;
		}
	}

	@Override
	public void paintBox(Graphics g) {
		componentBox.paintBox(g);
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
				componentBox = null;
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
				componentBox = (ComponentBox)childBox;
				if (componentBox == null) {
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
		setFocusAt(0, componentBox);
		componentBox.setFirstNodeAsFocus();
	}

	public ComponentBox getList() {
		return componentBox;
	}

	public void setComponentBox(ComponentBox componentBox) {
		this.componentBox = componentBox;
	}

}
