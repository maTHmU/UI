package shell.model.document;

import java.util.HashMap;

public class Tag {

	private String name;

	private boolean breakTag;

	public Tag(String name, boolean breakTag) {
		this.name = name;
		this.breakTag = breakTag;
	}

	public Tag(String name) {
		this(name, false);
	}

	public Tag(Tag tag) {
		this(tag.name, tag.breakTag);
	}

	public static Tag BoxData
			= new Tag("BoxData");
	public static Tag Cell
			= new Tag("Cell", true);
	public static Tag CellGroupData
			= new Tag("CellGroupData", true);
	public static Tag FractionBox
			= new Tag("FractionBox");
	public static Tag GridBox
			= new Tag("GridBox");
	public static Tag List
			= new Tag("List");
	public static Tag Notebook
			= new Tag("Notebook", true);
	public static Tag OverscriptBox
			= new Tag("OverscriptBox");
	public static Tag RadicalBox
			= new Tag("RadicalBox");
	public static Tag RowBox
			= new Tag("RowBox");
	public static Tag SqrtBox
			= new Tag("SqrtBox");
	public static Tag StringBox
			= new Tag("StringBox");
	public static Tag StyleBox
			= new Tag("StyleBox");
	public static Tag SubscriptBox
			= new Tag("SubscriptBox");
	public static Tag SubsuperscriptBox
			= new Tag("SubsuperscriptBox");
	public static Tag SuperscriptBox
			= new Tag("SuperscriptBox");
	public static Tag UnderoverscriptBox
			= new Tag("UnderoverscriptBox");
	public static Tag UnderscriptBox
			= new Tag("UnderscriptBox");

	public static HashMap<String, Tag> tagMap;
	static {
		tagMap = new HashMap<String, Tag>();
		tagMap.put("BoxData", BoxData);
		tagMap.put("Cell", Cell);
		tagMap.put("CellGroupData", CellGroupData);
		tagMap.put("FractionBox", FractionBox);
		tagMap.put("GridBox", GridBox);
		tagMap.put("List", List);
		tagMap.put("Notebook", Notebook);
		tagMap.put("OverscriptBox", OverscriptBox);
		tagMap.put("RadicalBox", RadicalBox);
		tagMap.put("RowBox", RowBox);
		tagMap.put("SqrtBox", SqrtBox);
		tagMap.put("StringBox", StringBox);
		tagMap.put("StyleBox", StyleBox);
		tagMap.put("SubscriptBox", SubscriptBox);
		tagMap.put("SupsuperscriptBox", SubsuperscriptBox);
		tagMap.put("SuperscriptBox", SuperscriptBox);
		tagMap.put("UnderoverscriptBox", UnderoverscriptBox);
		tagMap.put("Underscriptbox", UnderscriptBox);
	}

	public String getName() {
		return name;
	}

	public boolean isBreakTag() {
		return breakTag;
	}

	public boolean isVirtual() {
		return name.equals("List");
	}

	public boolean isList() {
		return name.equals("List");
	}

}
