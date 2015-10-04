package common;


public class StringOperations {

	public static final int UNICODE_LENGTH = 4;

	public static final char UNICODE_PREFIX = '0';

	public static final int UNICODE_RADIX = 16;

	public static final int NAMED_CHARACTER = -1;

	public static final int ALIAS_DELIMITER = 0xF764;

	public static final int PLACE_HOLDER = 0xF528;

	public static final int CURSOR_STROKE = 2;

	public static final int QUOTE = '\"';

	public static final int ALIAS_BACKSLASH = '\\';

	public static final int OPERATOR_LEFT_BRACKET = '[';

	public static final int OPERATOR_RIGHT_BRACKET = ']';

	public static final int LIST_LEFT_BRACKET = '{';

	public static final int LIST_RIGHT_BRACKET = '}';

	public static final int LIST_SEPARATOR = ',';

	public static final String CONNECT_OPERATION_NAME = new String("Connect");

	public static boolean isASCIIPrintableChar(int ch) {
		return (ch >= 0x20 && ch < 0x7f);
	}

	public static boolean isSpaceChar(int ch) {
		return ch == 0x20;
	}

	public static boolean isAliasedChar(char ch) {
		return (ch == QUOTE || ch == ALIAS_BACKSLASH);
	}

	public static boolean isNamedCharacter(int ch) {
		return ch == NAMED_CHARACTER;
	}

	public static String cursorString() {
		return new StringBuffer().append((char)CURSOR_STROKE).toString();
	}

	public static String addQuotes(String str) {
		return new String((char)QUOTE + str + (char)QUOTE);
	}

	public static String addBracketsInBoxForm(String str) {
		return new String("RowBox[{\"(\", " + str + ", \")\"}]");
	}

	public static String removeWhiteSpaces(String str) {
		StringBuffer temp = new StringBuffer(str);
		while (temp.length() != 0 && isSpaceChar(temp.charAt(0))) {
			temp.deleteCharAt(0);
		}
		while (temp.length() != 0 && isSpaceChar(temp.charAt(temp.length() - 1))) {
			temp.deleteCharAt(temp.length() - 1);
		}
		return temp.toString();
	}

	public static String toHexString(char ch) {
		StringBuffer str = new StringBuffer(Integer.toHexString(ch));
		while (str.length() < UNICODE_LENGTH) {
			str.insert(0, UNICODE_PREFIX);
		}
		return str.toString();
	}

	public static int getNextSeparatorIndex(String boxForm, int fromIndex) {
		int listBracket = 0;
		int operatorBracket = 0;
		boolean inQuote = false;
		boolean inAlias = false;
		for (int i = fromIndex; i < boxForm.length(); i++) {
			if (isMatched(listBracket, operatorBracket, inQuote) && isListSeparator(boxForm.charAt(i))) {
				return i;
			}
			if (!inQuote) {
				if (boxForm.charAt(i) == StringOperations.LIST_LEFT_BRACKET) {
					listBracket ++;
				} else if (boxForm.charAt(i) == StringOperations.LIST_RIGHT_BRACKET) {
					if (listBracket > 0) listBracket --;
				} else if (boxForm.charAt(i) == StringOperations.OPERATOR_LEFT_BRACKET) {
					operatorBracket ++;
				} else if (boxForm.charAt(i) == StringOperations.OPERATOR_RIGHT_BRACKET) {
					if (operatorBracket > 0) operatorBracket --;
				}
			}
			if ((!inAlias) && boxForm.charAt(i) == StringOperations.QUOTE) {
				inQuote = !inQuote;
			}
			if (boxForm.charAt(i) == StringOperations.ALIAS_BACKSLASH) {
				inAlias = !inAlias;
			} else {
				inAlias = false;
			}
		}
		return -1;
	}

	public static boolean isCompletedCellForm(String cellForm) {
		int listBracket = 0;
		int operatorBracket = 0;
		boolean inQuote = false;
		boolean inAlias = false;
		for (int i = 0; i < cellForm.length(); i++) {
			if (!inQuote) {
				if (cellForm.charAt(i) == StringOperations.LIST_LEFT_BRACKET) {
					listBracket ++;
				} else if (cellForm.charAt(i) == StringOperations.LIST_RIGHT_BRACKET) {
					if (listBracket > 0) listBracket --;
				} else if (cellForm.charAt(i) == StringOperations.OPERATOR_LEFT_BRACKET) {
					operatorBracket ++;
				} else if (cellForm.charAt(i) == StringOperations.OPERATOR_RIGHT_BRACKET) {
					if (operatorBracket > 0) operatorBracket --;
				}
			}
			if ((!inAlias) && cellForm.charAt(i) == StringOperations.QUOTE) {
				inQuote = !inQuote;
			}
			if (cellForm.charAt(i) == StringOperations.ALIAS_BACKSLASH) {
				inAlias = !inAlias;
			} else {
				inAlias = false;
			}
		}
		return isMatched(listBracket, operatorBracket, inQuote);
	}

	private static boolean isMatched(int listBracket, int operatorBracket, boolean inQuote) {
		return (listBracket == 0 && operatorBracket == 0 && (!inQuote));
	}

	private static boolean isListSeparator(char ch) {
		return (ch == StringOperations.LIST_SEPARATOR || ch == LIST_RIGHT_BRACKET || ch == OPERATOR_RIGHT_BRACKET);
	}

	public static String getFirstFromRowBoxForm(String rowBoxForm) {
		if (rowBoxForm.charAt(0) == '\"') {
			return null;
		}
		String content = rowBoxForm.substring(rowBoxForm.indexOf('[') + 2, rowBoxForm.lastIndexOf(']') - 1);
		if (content.charAt(0) == QUOTE) {
			return content.substring(1, content.indexOf('\"', 1));
		} else {
			return null;
		}
	}

	public static String replaceCharacters(String str, char find, char replace) {
		StringBuffer buffer = new StringBuffer(str);
		for (int i = 0; i < buffer.length(); i++) {
			if (buffer.charAt(i) == find) {
				buffer.setCharAt(i, replace);
			}
		}
		return buffer.toString();
	}

}
