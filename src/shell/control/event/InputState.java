package shell.control.event;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import shell.ShellFile;

public class InputState implements KeyListener, MouseListener,
		MouseMotionListener, MouseWheelListener {

	private static final int MAX_KEY_CODE = 65536;

	private ShellFile shellFile;

	private boolean[] keyDown;

	private boolean mouseLeftKeyDown;

	private boolean mouseRightKeyDown;

	private boolean mouseMiddleKeyDown;

	private Point mouseLocation;

	public InputState(ShellFile shellFile) {
		this(shellFile, new boolean[MAX_KEY_CODE], false, false, false);
	}

	public InputState(InputState state) {
		this(state.shellFile, state.keyDown, state.mouseLeftKeyDown,
				state.mouseRightKeyDown, state.mouseMiddleKeyDown);
	}

	public InputState(ShellFile shellFile, boolean[] keyDown,
			boolean mouseLeftKeyDown, boolean mouseRightKeyDown,
			boolean mouseMiddleKeyDown) {
		this.shellFile = shellFile;
		this.keyDown = keyDown;
		this.mouseLeftKeyDown = mouseLeftKeyDown;
		this.mouseRightKeyDown = mouseRightKeyDown;
		this.mouseMiddleKeyDown = mouseMiddleKeyDown;
	}

	public void processEvent(BoxEvent event) {
		shellFile.getBoxRoot().processEvent(event);
	}

	public boolean[] getKeyDown() {
		return keyDown;
	}

	public void setKeyDown(boolean[] keyDown) {
		this.keyDown = keyDown;
	}

	public boolean isMouseLeftKeyDown() {
		return mouseLeftKeyDown;
	}

	public void setMouseLeftKeyDown(boolean mouseLeftKeyDown) {
		this.mouseLeftKeyDown = mouseLeftKeyDown;
	}

	public boolean isMouseRightKeyDown() {
		return mouseRightKeyDown;
	}

	public void setMouseRightKeyDown(boolean mouseRightKeyDown) {
		this.mouseRightKeyDown = mouseRightKeyDown;
	}

	public boolean isMouseMiddleKeyDown() {
		return mouseMiddleKeyDown;
	}

	public void setMouseMiddleKeyDown(boolean mouseMiddleKeyDown) {
		this.mouseMiddleKeyDown = mouseMiddleKeyDown;
	}

	public Point getMouseLocation() {
		return mouseLocation;
	}

	public void setMouseLocation(Point mouseLocation) {
		this.mouseLocation = mouseLocation;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		keyDown[keyCode] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		keyDown[keyCode] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int keyChar = e.getKeyChar();
		BoxEvent event = new BoxEvent(BoxEvent.EVENT_TYPE.TYPING);
		event.setKeyChar(keyChar);
		processEvent(event);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point currentLocation = e.getPoint();
		BoxEvent event = new BoxEvent(BoxEvent.EVENT_TYPE.CLICK);
		event.setCurrentLocation(currentLocation);
		processEvent(event);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 暂时不考虑进入事件
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 暂时不考虑退出事件
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int button = e.getButton();
		if (button == MouseEvent.BUTTON1) {
			mouseLeftKeyDown = true;
		} else if (button == MouseEvent.BUTTON2) {
			mouseMiddleKeyDown = true;
		} else if (button == MouseEvent.BUTTON3) {
			mouseRightKeyDown = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();
		if (button == MouseEvent.BUTTON1) {
			mouseLeftKeyDown = false;
		} else if (button == MouseEvent.BUTTON2) {
			mouseMiddleKeyDown = false;
		} else if (button == MouseEvent.BUTTON3) {
			mouseRightKeyDown = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 暂时不考虑拖拽事件
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Point location = e.getPoint();
		mouseLocation = location;
		// TODO 暂时不考虑移动事件具体相应
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO 暂时不考虑滚轮事件
	}

}
