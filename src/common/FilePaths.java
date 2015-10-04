package common;

public class FilePaths {

	public static final String SYSTEM_FILE_PATH = new String("SystemFiles/");

	public static final String TEMP_FILE_PATH = new String(SYSTEM_FILE_PATH
			.concat("TempFile/"));

	public static final String WORK_SPACE_PATH = new String(SYSTEM_FILE_PATH
			.concat("WorkSpace/"));

	public static final String ITEM_PATH = new String(SYSTEM_FILE_PATH
			.concat("Items/"));

	public static final String OPERATORS_PATH = new String(ITEM_PATH
			.concat("Operators/"));

	public static final String BOXES_PATH = new String(ITEM_PATH
			.concat("Boxes/"));

	public static final String CHARACTERS_PATH = new String(ITEM_PATH
			.concat("Characters/"));

	public static final String ALIASES_PATH = new String(ITEM_PATH
			.concat("Aliases/"));

	public static final String FONTS_PATH = new String(ITEM_PATH
			.concat("Fonts/"));

	public static final String ICONS_PATH = new String(ITEM_PATH
			.concat("Icons/"));

	public static final String MAINTOOLBAR_ICONS_PATH = new String(ICONS_PATH
			.concat("MainToolBar/"));

	public static final String INPUTTOOLBAR_ICONS_PATH = new String(ICONS_PATH
			.concat("InputToolBar/"));

	public static final String INPUTTOOLBAR_MATH_ICONS_PATH = new String(
			INPUTTOOLBAR_ICONS_PATH.concat("Math/"));

	public static final String INPUTTOOLBAR_GREEK_ICONS_PATH = new String(
			INPUTTOOLBAR_ICONS_PATH.concat("Greek/"));

	public static final String ALGEBRAIC_PALLETES_ICONS_PATH = new String(
			ICONS_PATH.concat("AlgebraicManipulation/"));

	public static final String BASIC_MATH_PALLETES_ICONS_PATH = new String(
			ICONS_PATH.concat("BasicMathInput/"));

	public static final String PALLETES_PATH = new String(ITEM_PATH
			.concat("Palletes/"));

	public static final String ALGEBRAIC_PALLETES_PATH = new String(
			PALLETES_PATH.concat("AlgebraicManipulation/"));

	public static final String BASIC_MATH_PALLETES_PATH = new String(
			PALLETES_PATH.concat("BasicMathInput/"));

	public static final String INTERPRETES_PATH = new String(ITEM_PATH
			.concat("Interprete/"));

	public static final String INPUT_INTERPRETES_PATH = new String(
			INTERPRETES_PATH.concat("InputForm/"));

	public static final String BOX_INTERPRETES_PATH = new String(
			INTERPRETES_PATH.concat("BoxForm/"));

	public static final String LANGUAGE_PATH = new String(ITEM_PATH
			.concat("Language/"));

	public static final String STYLESHEET_PATH = new String(ITEM_PATH
			.concat("StyleSheets/"));

}
