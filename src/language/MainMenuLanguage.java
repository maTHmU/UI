package language;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JMenuItem;

import common.StringOperations;

public class MainMenuLanguage {

	protected HashMap<String, Integer> menuMap;

	protected ArrayList<String> menuName;

	protected ArrayList<String> menuText;

	protected ArrayList<Integer> menuMnemonicIndex;

	protected MainMenuLanguage(String filePath) {
		menuMap = new HashMap<String, Integer>();
		menuName = new ArrayList<String>();
		menuText = new ArrayList<String>();
		menuMnemonicIndex = new ArrayList<Integer>();
		try {
			File inputFile = new File(filePath + "MainMenu.txt");
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			String buffer;
			String[] subString;
			while ((buffer = input.readLine()) != null) {
				if (buffer.length() > 0) {
					subString = buffer.split(" ");
					menuMap.put(subString[0], menuName.size());
					menuName.add(subString[0]);
					menuText.add(StringOperations.replaceCharacters(subString[1], '_', ' '));
					menuMnemonicIndex.add(Integer.parseInt(subString[2]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeMenuItemLanguage(JMenuItem menuItem, String name) {
		int no = menuMap.get(name);
		menuItem.setText(menuText.get(no));
		menuItem.setToolTipText(menuText.get(no));
		menuItem.setDisplayedMnemonicIndex(menuMnemonicIndex.get(no));
	}

}
