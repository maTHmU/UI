package framework.maintabbedpane;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TextScrollPane extends JScrollPane {

	private static final long serialVersionUID = 5013179582401747652L;

	private MainTabbedPane tabbedPane;

	private TextPanel textPanel;

	public TextScrollPane(MainTabbedPane tabbedPane, String filePath, boolean existed) {
		super();
		this.tabbedPane = tabbedPane;
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		textPanel = new TextPanel(this, filePath, existed);
		getViewport().add(textPanel);
	}

	public MainTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public TextPanel getTextPanel() {
		return textPanel;
	}

}
