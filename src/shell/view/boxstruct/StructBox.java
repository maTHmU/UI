package shell.view.boxstruct;

import shell.model.document.Document;

public abstract class StructBox extends GeneralBox {

	public StructBox(int orderNo) {
		super(orderNo);
	}

	public StructBox(Document document, GeneralBox parent, int orderNo,
			BoxArguments arguments, GlobalAttributes attributes) {
		super(document, parent, orderNo, arguments, attributes);
	}

}
