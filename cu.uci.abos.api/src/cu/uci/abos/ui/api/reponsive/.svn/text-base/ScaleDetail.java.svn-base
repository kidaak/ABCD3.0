package cu.uci.abos.ui.api.reponsive;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;

public class ScaleDetail {
	private final ScaleData current;
	private final Scale scale;

	private ScaleData predecessor;
	private ScaleData successor;
	private Rectangle margin;
	private int width;
	private int height;

	public ScaleDetail(ScaleData current, Scale scale) {
		this.current = current;
		this.scale = scale;
		this.width = SWT.DEFAULT;
		this.height = SWT.DEFAULT;
		this.margin = new Rectangle(0, 0, 0, 0);
	}

	public int getWidth() {
		return width;
	}

	public ScaleDetail setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public ScaleDetail setHeight(int height) {
		this.height = height;
		return this;
	}

	public ScaleDetail setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
		return this;
	}

	public Rectangle getMargin() {
		return margin;
	}

	public ScaleDetail setMargin(int left, int top, int right, int bottom) {
		this.margin = new Rectangle(left, top, right, bottom);
		return this;
	}

	public ScaleDetail tie(ScaleData successor) {
		if (this.successor != null) {
			this.successor.on(scale).setPredecessor(null);
		}
		this.successor = successor;
		if (successor != null) {
			successor.on(scale).setPredecessor(current);
		}
		return this;
	}

	public ScaleData getSuccessor() {
		return successor;
	}

	public boolean hasSuccessor() {
		return successor != null;
	}

	boolean hasPredecessor() {
		return predecessor != null;
	}

	private void setPredecessor(ScaleData predecessor) {
		this.predecessor = predecessor;
	}
}
