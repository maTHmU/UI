package language;

import framework.mycomponents.MyButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import common.StringOperations;

public class MainToolBarLanguage {

	protected HashMap<String, Integer> toolBarMap;

	protected ArrayList<String> toolBarName;

	protected ArrayList<String> toolBarText;

	protected MainToolBarLanguage(String filePath) {
		toolBarMap = new HashMap<String, Integer>();
		toolBarName = new ArrayList<String>();
		toolBarText = new ArrayList<String>();
		try {
			File inputFile = new File(filePath + "MainToolBar.txt");
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			String buffer;
			String[] subString;
			while ((buffer = input.readLine()) != null) {
				if (buffer.length() > 0) {
					subString = buffer.split(" ");
					toolBarMap.put(subString[0], toolBarName.size());
					toolBarName.add(subString[0]);
					toolBarText.add(StringOperations.replaceCharacters(subString[1], '_', ' '));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeToolBarLanguage(MyButton toolBarButton) {
		int no = toolBarMap.get(toolBarButton.getName());
		toolBarButton.setToolTipText(toolBarText.get(no));
	}

}
