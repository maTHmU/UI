package language;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTabbedPane;

import common.StringOperations;

public class InputTabbedPaneLanguage {

	protected HashMap<String, Integer> tabbedPaneMap;

	protected ArrayList<String> tabbedPaneName;

	protected ArrayList<String> tabbedPaneText;

	protected InputTabbedPaneLanguage(String filePath) {
		tabbedPaneMap = new HashMap<String, Integer>();
		tabbedPaneName = new ArrayList<String>();
		tabbedPaneText = new ArrayList<String>();
		try {
			File inputFile = new File(filePath + "InputTabbedPane.txt");
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			String buffer;
			String[] subString;
			while ((buffer = input.readLine()) != null) {
				if (buffer.length() > 0) {
					subString = buffer.split(" ");
					tabbedPaneMap.put(subString[0], tabbedPaneName.size());
					tabbedPaneName.add(subString[0]);
					tabbedPaneText.add(StringOperations.replaceCharacters(subString[1], '_', ' '));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeTabbedPaneLanguage(JTabbedPane tabbedPane, int tab, String name) {
		int no = tabbedPaneMap.get(name);
		tabbedPane.setTitleAt(tab, tabbedPaneText.get(no));
	}

}
