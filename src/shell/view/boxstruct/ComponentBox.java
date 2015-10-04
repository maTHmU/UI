package shell.view.boxstruct;

import shell.model.document.Document;

public abstract class ComponentBox extends GeneralBox {

	public ComponentBox(int orderNo) {
		super(orderNo);
	}

	public ComponentBox(Document document, GeneralBox parent, int orderNo,
			BoxArguments arguments, GlobalAttributes attributes) {
		super(document, parent, orderNo, arguments, attributes);
	}

}
