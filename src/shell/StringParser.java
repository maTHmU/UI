package shell;

import java.awt.Color;

public class StringParser {

	public static final int parseInteger(String str) {
		return new Integer(str).intValue();
		// TODO: More conditions
	}

	public static final Color parseColor(String str) {
		// TODO: 
		int red = Integer.parseInt(str.substring(0, 2), 16);
		int green = Integer.parseInt(str.substring(2, 4), 16);
		int blue = Integer.parseInt(str.substring(4, 6), 16);
		return new Color(red, green, blue);
	}

	public static final int parseFontSize(String str) {
		// TODO:
		return parseInteger(str);
	}

	public static final int parseFontStyle(String str) {
		// TODO:
		return parseInteger(str);
	}

}
