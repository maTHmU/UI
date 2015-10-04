package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

import framework.menupanel.MenuPanel;
import framework.inputtabbedpane.InputTabbedPane;
import framework.maintabbedpane.MainTabbedPane;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 2050762324543203799L;

	private static final Dimension FRAME_SIZE = new Dimension(1000, 800);

	private static final Color FRAME_BACKGROUND = Color.WHITE;

	private Dimension frameSize;

	private Point frameLocation;

	private MenuPanel menuPanel;

	private InputTabbedPane inputTabbedPane;

	private MainTabbedPane mainTabbedPane;

	public MainFrame() {
		super("maTHmU");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = new Dimension(FRAME_SIZE);
		frameLocation = new Point(
				(screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setLocation(frameLocation);
		setSize(frameSize);
		setResizable(false);
		setBackground(FRAME_BACKGROUND);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		menuPanel = new MenuPanel();
		add(menuPanel, BorderLayout.NORTH);
		inputTabbedPane = new InputTabbedPane();
		add(inputTabbedPane, BorderLayout.SOUTH);
		mainTabbedPane = new MainTabbedPane();
		add(mainTabbedPane, BorderLayout.CENTER);
		mainTabbedPane.setBackground(Color.WHITE);
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public InputTabbedPane getInputTabbedPane() {
		return inputTabbedPane;
	}

	public MainTabbedPane getMainTabbedPane() {
		return mainTabbedPane;
	}
}
