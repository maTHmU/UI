package language;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import common.FilePaths;

public class LanguageManager {

	protected static final String FILE_PATH = FilePaths.LANGUAGE_PATH;

	private static final String DEFAULT_LANGUAGE = "¼òÌåÖÐÎÄ";

	protected int currentLanguage;

	protected ArrayList<Language> languages;

	protected HashMap<String, Integer> nameMap;

	public LanguageManager() {
		languages = new ArrayList<Language>();
		nameMap = new HashMap<String, Integer>();
		try {
			File inputFile = new File(FILE_PATH);
			String fileName[] = inputFile.list();
			for (int i = 0; i < fileName.length; i++) {
				nameMap.put(fileName[i], i);
				createLanguage(fileName[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setLanguage(nameMap.get(DEFAULT_LANGUAGE));
	}

	private void createLanguage(String languageName) {
		languages.add(new Language(languageName));
	}

	public void setLanguage(int no) {
		currentLanguage = no;
		languages.get(no).setLanguage();
	}

	public void selectLanguage() {
		setLanguage(1 - currentLanguage);
	}

}
