package shell.view.boxstruct;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import shell.control.boxhandler.CharBoxHandler;
import shell.model.document.Attribute;

public class CharBox extends ComponentBox {

	private char letter;

	public CharBox(int orderNo) {
		super(orderNo);
	}

	public CharBox(GeneralBox charBox) {
		super(charBox.getDocument(), charBox.parent, charBox.orderNo,
				charBox.arguments, charBox.attributes);
	}

	private Color getFontColor() {
		return parent.parent.attributes.fontColor;
	}

	@Override
	public void calculateArguments(int width) {
		/* TODO: ����һ����ʱ�����
		 * ������Ҫ��������������еĲ�������
		 * ��Ҳ��Ψһ��Ҫ�õ�����ĵط�
		 */
		arguments.height = 14;
		arguments.depth = 7;
		arguments.width = 8;
		arguments.posX = 0;
		arguments.posY = 0;
	}

	@Override
	public void changeStructure() {
		if (letter == 0) {
			parent.removeChild(orderNo);
		}
	}

	@Override
	public GeneralBox generateCopy() {
		CharBox newCharBox = new CharBox(this);
		return newCharBox;
	}

	@Override
	public void generateHandler() {
		handler = new CharBoxHandler(this);
	}

	@Override
	public ArrayList<GeneralBox> getChildren() {
		ArrayList<GeneralBox> children = new ArrayList<GeneralBox>();
		return children;
	}

	@Override
	public ArrayList<String> getFingerprint() {
		ArrayList<String> fingerprint = new ArrayList<String>();
		fingerprint.add(document.getTag().getName());
		return fingerprint;
	}

	@Override
	public GeneralBox locate(int x, int y) {
		return this;
	}

	@Override
	public void paintBox(Graphics g) {
		g.setColor(getFontColor());
		g.drawString(new Character(letter).toString(),
				arguments.posX, arguments.posY + arguments.height);
	}

	@Override
	public void parseKeyLocalAttribute(Attribute attribute) {
		
	}

	@Override
	public void parseLocalAttribute(Attribute attribute) {
		// �����е���������ֵ����������ֵ���丸�ڵ������
	}

	@Override
	public void removeChild(int no) {
		// ���������ӽڵ㡣
		Exception e = new Exception("Invalid child type.");
		e.printStackTrace();
	}

	@Override
	public void setChild(int no, GeneralBox childBox) {
		// ���������ӽڵ㡣
		Exception e = new Exception("Invalid child type.");
		e.printStackTrace();
	}

	@Override
	public void setFirstNodeAsFocus() {
		// ֱ���Թ���
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

}
