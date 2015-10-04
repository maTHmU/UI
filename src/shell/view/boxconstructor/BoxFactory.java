package shell.view.boxconstructor;

import java.util.HashMap;

import shell.model.document.Document;
import shell.view.boxstruct.BoxData;
import shell.view.boxstruct.Cell;
import shell.view.boxstruct.CellGroupData;
import shell.view.boxstruct.CharBox;
import shell.view.boxstruct.FractionBox;
import shell.view.boxstruct.GeneralBox;
import shell.view.boxstruct.List;
import shell.view.boxstruct.Notebook;
import shell.view.boxstruct.OverscriptBox;
import shell.view.boxstruct.RadicalBox;
import shell.view.boxstruct.RowBox;
import shell.view.boxstruct.SqrtBox;
import shell.view.boxstruct.StringBox;
import shell.view.boxstruct.SubscriptBox;
import shell.view.boxstruct.SubsuperscriptBox;
import shell.view.boxstruct.SuperscriptBox;
import shell.view.boxstruct.UnderoverscriptBox;
import shell.view.boxstruct.UnderscriptBox;

public class BoxFactory {

	public static BoxData boxData = new BoxData(0);
	public static Cell cell = new Cell(0);
	public static CellGroupData cellGroupData = new CellGroupData(0);
	public static CharBox charBox = new CharBox(0);
	public static FractionBox fractionBox = new FractionBox(0);
	public static List list = new List(0);
	public static Notebook notebook = new Notebook(0);
	public static OverscriptBox overscriptBox = new OverscriptBox(0);
	public static RadicalBox radicalBox = new RadicalBox(0);
	public static RowBox rowBox = new RowBox(0);
	public static SqrtBox sqrtBox = new SqrtBox(0);
	public static StringBox stringBox = new StringBox(0);
	public static SubscriptBox subscriptBox = new SubscriptBox(0);
	public static SubsuperscriptBox subsuperscriptBox = new SubsuperscriptBox(0);
	public static SuperscriptBox superscriptBox = new SuperscriptBox(0);
	public static UnderoverscriptBox underoverscriptBox = new UnderoverscriptBox(0);
	public static UnderscriptBox underscriptBox = new UnderscriptBox(0);

	public static HashMap<String, GeneralBox> boxMap;
	static {
		boxMap = new HashMap<String, GeneralBox>();
		boxMap.put("BoxData", boxData);
		boxMap.put("Cell", cell);
		boxMap.put("CellGroupData", cellGroupData);
		boxMap.put("CharBox", charBox);
		boxMap.put("FractionBox", fractionBox);
		boxMap.put("List", list);
		boxMap.put("Notebook", notebook);
		boxMap.put("OverscriptBox", overscriptBox);
		boxMap.put("RadicalBox", radicalBox);
		boxMap.put("RowBox", rowBox);
		boxMap.put("SqrtBox", sqrtBox);
		boxMap.put("StringBox", stringBox);
		boxMap.put("SubscriptBox", subscriptBox);
		boxMap.put("SubsuperscriptBox", subsuperscriptBox);
		boxMap.put("SuperscriptBox", superscriptBox);
		boxMap.put("UnderoverscriptBox", underoverscriptBox);
		boxMap.put("UnderscriptBox", underscriptBox);
	}

	public BoxFactory() {
		
	}

	public GeneralBox getBoxFromDocument(Document document) {
		GeneralBox box = boxMap.get(document.getTag().getName()).generateCopy();
		box.setDocument(document);
		return box;
	}

}
