package shell.view.boxstruct;

import shell.model.document.Document;

public abstract class DataBox extends GeneralBox {

	public DataBox(int orderNo) {
		super(orderNo);
	}

	public DataBox(Document document, GeneralBox parent, int orderNo,
			BoxArguments arguments, GlobalAttributes attributes) {
		super(document, parent, orderNo, arguments, attributes);
	}

}
