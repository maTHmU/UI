package shell.control.event;

import java.awt.Point;

public class BoxEvent {

	protected enum EVENT_TYPE {
		TYPING, CONTROL, CLICK
	}

	// TODO: 规定各种控制事件的常量编码

	private EVENT_TYPE type;

	private int keyChar;

	private int controlCode;

	private Point previousLocation;

	private Point currentLocation;

	public BoxEvent(EVENT_TYPE type) {
		this.type = type;
	}

	public boolean isTypingEvent() {
		return type == EVENT_TYPE.TYPING;
	}

	public boolean isControlEvent() {
		return type == EVENT_TYPE.CONTROL;
	}

	public boolean isClickEvent() {
		return type == EVENT_TYPE.CLICK;
	}

	public EVENT_TYPE getType() {
		return type;
	}

	public void setType(EVENT_TYPE type) {
		this.type = type;
	}

	public int getKeyChar() {
		return keyChar;
	}

	public void setKeyChar(int keyChar) {
		this.keyChar = keyChar;
	}

	public int getControlCode() {
		return controlCode;
	}

	public void setControlCode(int controlCode) {
		this.controlCode = controlCode;
	}

	public Point getPreviousLocation() {
		return previousLocation;
	}

	public void setPreviousLocation(Point previousPoint) {
		this.previousLocation = previousPoint;
	}

	public Point getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point currentPoint) {
		this.currentLocation = currentPoint;
	}

}
