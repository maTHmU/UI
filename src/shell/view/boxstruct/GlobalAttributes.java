package shell.view.boxstruct;

import java.awt.Color;
import java.awt.Font;

import shell.StringParser;
import shell.model.document.Attribute;

public class GlobalAttributes {

	private static final Font DEFAULT_FONT = new Font("Courier New", 0, 12);

	private static final Color DEFAULT_COLOR = new Color(0, 0, 0);

	protected Font font;

	protected Color fontColor;

	public GlobalAttributes() {
		this(DEFAULT_FONT, DEFAULT_COLOR);
	}

	public GlobalAttributes(GlobalAttributes globalAttributes) {
		this(globalAttributes.font, globalAttributes.fontColor);
	}

	public GlobalAttributes(Font font, Color fontColor) {
		this.font = font;
		this.fontColor = fontColor;
	}

	protected void parseAttribute(Attribute attribute) {
		String name = attribute.getName();
		String value = attribute.getValue();
		if (name.equals("FontColor")) {
			fontColor = StringParser.parseColor(value);
		} else if (name.equals("FontFamily")) {
			setFontFamily(value);
		} else if (name.equals("FontSize")) {
			int fontSize = StringParser.parseFontSize(value);
			setFontSize(fontSize);
		} else if (name.equals("FontStyle")) {
			int fontStyle = StringParser.parseFontStyle(value);
			setFontStyle(fontStyle);
		}
	}

	public GlobalAttributes generateCopy() {
		return new GlobalAttributes(this);
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public String getFontFamily() {
		return font.getFamily();
	}

	public void setFontFamily(String fontFamily) {
		this.font = new Font(fontFamily, font.getStyle(), font.getSize());
	}

	public int getFontStyle() {
		return font.getStyle();
	}

	public void setFontStyle(int fontStyle) {
		this.font = new Font(font.getFamily(), fontStyle, font.getSize());
	}

	public int getFontSize() {
		return font.getSize();
	}

	public void setFontSize(int fontSize) {
		this.font = new Font(font.getFamily(), font.getStyle(), fontSize);
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

}
