package framework.maintabbedpane;

import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import common.FileOperations;

public class MainTabbedPane extends JTabbedPane implements ChangeListener {

	private static final long serialVersionUID = 5723315826164832770L;

	private ArrayList<TextScrollPane> tabs;

	private int currentTabLocation;

	private int newTabNo;

	public MainTabbedPane() {
		super(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

		tabs = new ArrayList<TextScrollPane>();
		currentTabLocation = -1;
		newTabNo = 0;

//		addNewTab(null);
		addNewTab("D:/My Studio/Java/maTHmUv1.0.0/workspace/plus~.txt");
		addChangeListener(this);
	}

	private void addNewTab(String filePath) {
		String fileName;
		boolean existed = false;
		if (filePath == null) {
			newTabNo ++;
			fileName = getGeneratedTabName(newTabNo);
			filePath = FileOperations.getPathFromFileName(fileName);
		} else {
			fileName = FileOperations.getFileNameFromPath(filePath);
			existed = true;
		}
		TextScrollPane newTextScrollPane = new TextScrollPane(this, filePath, existed);
		currentTabLocation = tabs.size();
		insertTab(fileName, null, newTextScrollPane, null, currentTabLocation);
	}

	private String getGeneratedTabName(int no) {
		String name = "Untitled-" + new Integer(no).toString() + "." + "mu";
		return name;
	}

	public TextScrollPane getCurrentPane() {
		return tabs.get(currentTabLocation);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		
	}

}
