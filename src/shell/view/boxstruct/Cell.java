package shell.view.boxstruct;

import java.awt.Graphics;
import java.util.ArrayList;

import shell.StringParser;
import shell.control.boxhandler.CellHandler;
import shell.model.document.Attribute;

public class Cell extends StructBox {

	protected DataBox dataBox;

	private String cellStyle;

	private int leftMargin;

	private int rightMargin;

	private int topMargin;

	private int bottomMargin;

	public Cell(int orderNo) {
		super(orderNo);
	}

	public Cell(GeneralBox cell) {
		super(cell.getDocument(), cell.parent, cell.orderNo,
				cell.arguments, cell.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		dataBox.calculateArguments(width - leftMargin - rightMargin);
		arguments = dataBox.arguments.clone();
		arguments.width = width;
		arguments.height += topMargin + bottomMargin;
		dataBox.arguments.posX = leftMargin;
		dataBox.arguments.posY = topMargin;
	}

	@Override
	public void changeStructure() {
		if (dataBox == null) {
			parent.removeChild(orderNo);
		}
	}

	@Override
	public GeneralBox generateCopy() {
		Cell newCell = new Cell(this);
		return newCell;
	}

	@Override
	public void generateHandler() {
		handler = new CellHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		ArrayList<GeneralBox> children = new ArrayList<GeneralBox>();
		children.add(dataBox);
		return children;
	}

	@Override
	public ArrayList<String> getFingerprint() {
		ArrayList<String> fingerprint = new ArrayList<String>();
		fingerprint.add(document.getTag().getName());
		fingerprint.add(cellStyle);
		return fingerprint;
	}

	@Override
	public GeneralBox locate(int x, int y) {
		if (dataBox.isPointInside(x, y)) {
			return dataBox.locate(x, y);
		} else {
			return this;
		}
	}

	@Override
	public void paintBox(Graphics g) {
		dataBox.paintBox(g);
	}

	@Override
	public void parseKeyLocalAttribute(Attribute attribute) {
		String name = attribute.getName();
		String value = attribute.getValue();
		if (name.equals("CellStyle")) {
			cellStyle = value;
		}
	}

	@Override
	public void parseLocalAttribute(Attribute attribute) {
		String name = attribute.getName();
		String value = attribute.getValue();
		if (name.equals("LeftMargin")) {
			leftMargin = StringParser.parseInteger(value);
		} else if (name.equals("RightMargin")) {
			rightMargin = StringParser.parseInteger(value);
		} else if (name.equals("TopMargin")) {
			topMargin = StringParser.parseInteger(value);
		} else if (name.equals("BottomMargin")) {
			bottomMargin = StringParser.parseInteger(value);
		}
	}

	@Override
	public void removeChild(int no) {
		try {
			if (no == 0) {
				dataBox = null;
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
				dataBox = (DataBox)childBox;
				if (dataBox == null) {
					throw(new Exception("Invalid child type."));
				}
			} else {
				throw(new Exception("Invalid child number."));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setFirstNodeAsFocus() {
		setFocusAt(0, dataBox);
		dataBox.setFirstNodeAsFocus();
	}

	public DataBox getDataBox() {
		return dataBox;
	}

	public void setDataBox(DataBox dataBox) {
		this.dataBox = dataBox;
	}

	public String getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(String cellStyle) {
		this.cellStyle = cellStyle;
	}

	public int getCellLeftMargin() {
		return leftMargin;
	}

	public void setCellLeftMargin(int cellLeftMargin) {
		this.leftMargin = cellLeftMargin;
	}

	public int getCellRightMargin() {
		return rightMargin;
	}

	public void setCellRightMargin(int cellRightMargin) {
		this.rightMargin = cellRightMargin;
	}

	public int getCellTopMargin() {
		return topMargin;
	}

	public void setCellTopMargin(int cellTopMargin) {
		this.topMargin = cellTopMargin;
	}

	public int getCellBottomMargin() {
		return bottomMargin;
	}

	public void setCellBottomMargin(int cellBottomMargin) {
		this.bottomMargin = cellBottomMargin;
	}

}
