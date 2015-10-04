package shell.view.boxstruct;

public class BoxArguments {

	protected int height;

	protected int depth;

	protected int width;

	protected int posX;

	protected int posY;

	/* TODO:
	 * ���Ӹ���Ĳ�����
	 * �����Ӳ�����ʱ��һ��Ҫͬʱ�޸������������Ӧ�Ĺ��췽����
	 * ����Ϊ��ӽ��Ĳ�������getter��setter��
	*/

	public BoxArguments() {
		this(0, 0, 0, 0, 0);
	}

	public BoxArguments(BoxArguments arguments) {
		this(arguments.height, arguments.depth, arguments.width,
				arguments.posX, arguments.posY);
	}

	public BoxArguments(int height, int depth, int width,
			int posX, int posY) {
		this.height = height;
		this.depth = depth;
		this.width = width;
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public BoxArguments clone() {
		return new BoxArguments(this);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
