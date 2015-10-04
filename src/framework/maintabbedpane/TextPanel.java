package framework.maintabbedpane;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import shell.ShellFile;

public class TextPanel extends JPanel {

	private static final long serialVersionUID = 8617066539445805825L;

	private static final Dimension PREFERRED_SIZE = new Dimension(967, 596);

	private TextScrollPane scrollPane;

	private ShellFile shellFile;

	private boolean existed;

	public TextPanel(TextScrollPane scrollPane, String filePath, boolean existed) {
		super();
		this.scrollPane = scrollPane;

		setLayout(null);
		setPreferredSize(PREFERRED_SIZE);
		setSize(PREFERRED_SIZE);

		this.existed = existed;
		shellFile = new ShellFile(this, filePath, existed);

		addListeners();
		requestFocus();
	}

	private void addListeners() {
		addKeyListener(shellFile.getInputState());
		addMouseListener(shellFile.getInputState());
		addMouseMotionListener(shellFile.getInputState());
		addMouseWheelListener(shellFile.getInputState());
	}

	public void paint(Graphics g) {
		shellFile.paint(g);
		requestFocus();
	}

	public TextScrollPane getScrollPane() {
		return scrollPane;
	}

	public ShellFile getShellFile() {
		return shellFile;
	}

	public void setExisted(boolean existed) {
		this.existed = existed;
	}

	public boolean isExisted() {
		return existed;
	}

}
