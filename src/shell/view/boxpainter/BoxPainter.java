package shell.view.boxpainter;

import java.awt.Graphics;

import shell.view.boxstruct.GeneralBox;

public class BoxPainter {

	private GeneralBox boxRoot;

	private int width;

	private int height;

	public BoxPainter(GeneralBox boxRoot, int width, int height) {
		this.boxRoot = boxRoot;
		this.width = width;
		this.height = height;
	}

	public void paint(Graphics g) {
		boxRoot.calculateArguments(width);
		if (boxRoot.getArguments().getHeight() < height) {
			boxRoot.getArguments().setHeight(height);
		}
		boxRoot.getArguments().setPosX(0);
		boxRoot.getArguments().setPosY(0);
		boxRoot.applyTranslation();

		boxRoot.paintBox(g);
//		boxRoot.paintCursor(g);
	}

	public GeneralBox getBoxRoot() {
		return boxRoot;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
