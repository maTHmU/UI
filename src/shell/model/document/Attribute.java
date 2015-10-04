package shell.model.document;

import java.util.HashMap;

public class Attribute {

	private String name;

	private String value;

	private boolean global;

	public Attribute(String name, boolean global) {
		setAttribute(name, "", global);
	}

	public Attribute(String name, String value, boolean global) {
		setAttribute(name, value, global);
	}

	public Attribute(Attribute attribute) {
		setAttribute(attribute.name, attribute.value, attribute.global);
	}

	public Attribute(Attribute attribute, String value) {
		setAttribute(attribute.name, value, attribute.global);
	}

	public void setAttribute(Attribute attribute) {
		setAttribute(attribute.name, attribute.value, attribute.global);
	}

	public void setAttribute(String name, String value, boolean global) {
		this.name = name;
		this.value = value;
		this.global = global;
	}

	public static Attribute Background = new Attribute("Background", false);
	public static Attribute BottomMargin = new Attribute("BottomMargin", false);
	public static Attribute CellIndenting = new Attribute("CellIndenting", false);
	public static Attribute CellMargin = new Attribute("CellMargin", false);
	public static Attribute CellStyle = new Attribute("CellStyle", false);
	public static Attribute DefaultStyle = new Attribute("DefaultStyle", false);
	public static Attribute FontColor = new Attribute("FontColor", true);
	public static Attribute FontFamily = new Attribute("FontFamily", true);
	public static Attribute FontSize = new Attribute("FontSize", true);
	public static Attribute FontStyle = new Attribute("FontStyle", true);
	public static Attribute FrameMargin = new Attribute("FrameMargin", false);
	public static Attribute ID = new Attribute("ID", false);
	public static Attribute LeftMargin = new Attribute("LeftMargin", false);
	public static Attribute RightMargin = new Attribute("RightMargin", false);
	public static Attribute Text = new Attribute("Text", false);
	public static Attribute TopMargin = new Attribute("TopMargin", false);
	public static Attribute WindowSize = new Attribute("WindowSize", false);

	public static HashMap<String, Attribute> attributeMap;
	static {
		attributeMap = new HashMap<String, Attribute>();
		attributeMap.put("Background", Background);
		attributeMap.put("BottomMargin", BottomMargin);
		attributeMap.put("CellIndenting", CellIndenting);
		attributeMap.put("CellMargin", CellMargin);
		attributeMap.put("CellStyle", CellStyle);
		attributeMap.put("DefaultStyle", DefaultStyle);
		attributeMap.put("FontColor", FontColor);
		attributeMap.put("FontFamily", FontFamily);
		attributeMap.put("FontSize", FontSize);
		attributeMap.put("FontStyle", FontStyle);
		attributeMap.put("FrameMargin", FrameMargin);
		attributeMap.put("ID", ID);
		attributeMap.put("LeftMargin", LeftMargin);
		attributeMap.put("RightMargin", RightMargin);
		attributeMap.put("Text", Text);
		attributeMap.put("TopMargin", TopMargin);
		attributeMap.put("WindowSize", WindowSize);
	}

	@Override
	public String toString() {
		return name + "=\"" + value + "\"";
	}

	public boolean isSameAttribute(Attribute attribute) {
		return name.equals(attribute.name);
	}

	public boolean equals(Attribute attribute) {
		return name.equals(attribute.name) && value.equals(attribute.value);
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public boolean isGlobal() {
		return global;
	}

}
