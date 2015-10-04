package shell.view.boxstruct;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Iterator;

import shell.StringParser;
import shell.control.boxhandler.NotebookHandler;
import shell.model.document.Attribute;

public class Notebook extends StructBox {

	protected List list;

	private Color background;

	private int leftMargin;

	private int rightMargin;

	private int topMargin;

	private int bottomMargin;

	private int cellIndenting;

	public Notebook(int orderNo) {
		super(orderNo);
	}

	public Notebook(GeneralBox notebook) {
		super(notebook.getDocument(), notebook.parent, notebook.orderNo,
				notebook.arguments, notebook.attributes);
	}

	@Override
	public void calculateArguments(int width) {
		list.arguments.height = 0;
		list.arguments.depth = 0;
		list.arguments.width = width;
		Iterator<GeneralBox> it = list.boxes.listIterator();
		while (it.hasNext()) {
			GeneralBox box = it.next();
			box.calculateArguments(width - cellIndenting - leftMargin - rightMargin);
			box.arguments.posX = 0;
			box.arguments.posY = list.arguments.height;
			list.arguments.height += box.arguments.height;
		}

		arguments = list.arguments.clone();
		list.arguments.posX = leftMargin;
		list.arguments.posY = topMargin;
	}

	@Override
	public void changeStructure() {
		// 顶层结构不会改变
	}

	@Override
	public GeneralBox generateCopy() {
		Notebook newNotebook = new Notebook(this);
		return newNotebook;
	}

	@Override
	public void generateHandler() {
		handler = new NotebookHandler(this);
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
		g.setColor(background);
		g.fillRect(0, 0, arguments.width, arguments.height);
		list.paintBox(g);
	}

	@Override
	public void parseKeyLocalAttribute(Attribute attribute) {
		
	}

	@Override
	public void parseLocalAttribute(Attribute attribute) {
		String name = attribute.getName();
		String value = attribute.getValue();
		if (name.equals("Background")) {
			background = StringParser.parseColor(value);
		} else if (name.equals("CellIndenting")) {
			cellIndenting = StringParser.parseInteger(value);
		} else if (name.equals("LeftMargin")) {
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
				list.getBoxes().clear();
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

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public int getLeftMargin() {
		return leftMargin;
	}

	public void setLeftMargin(int leftMargin) {
		this.leftMargin = leftMargin;
	}

	public int getRightMargin() {
		return rightMargin;
	}

	public void setRightMargin(int rightMargin) {
		this.rightMargin = rightMargin;
	}

	public int getTopMargin() {
		return topMargin;
	}

	public void setTopMargin(int topMargin) {
		this.topMargin = topMargin;
	}

	public int getBottomMargin() {
		return bottomMargin;
	}

	public void setBottomMargin(int bottomMargin) {
		this.bottomMargin = bottomMargin;
	}

	public int getCellIndenting() {
		return cellIndenting;
	}

	public void setCellIndenting(int cellIndenting) {
		this.cellIndenting = cellIndenting;
	}

}
