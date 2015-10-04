package common;

import language.LanguageManager;

public class Index {

	public static final int UNICODE_RADIX = StringOperations.UNICODE_RADIX;

	public static LanguageManager languageManager;

	public Index() {
		
	}

	public static void initBeforeFrameConstruction() {
		
	}

	public static void initAfterFrameConstruction() {
		languageManager = new LanguageManager();
	}

}
