package shell.control.boxhandler;

import shell.control.event.BoxEvent;
import shell.view.boxstruct.SubscriptBox;

public class SubscriptBoxHandler extends ComponentBoxHandler {

	private SubscriptBox subscriptBox;

	public SubscriptBoxHandler(SubscriptBox subscriptBox) {
		this.subscriptBox = subscriptBox;
	}

	@Override
	public void process(BoxEvent event) {
		// TODO Auto-generated method stub
		
	}

	public SubscriptBox getSubscriptBox() {
		return subscriptBox;
	}

	public void setSubscriptBox(SubscriptBox subscriptBox) {
		this.subscriptBox = subscriptBox;
	}

}
