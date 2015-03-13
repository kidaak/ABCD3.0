package cu.uci.abos.ui.api.reponsive;

import java.util.LinkedList;
import java.util.List;
import static java.lang.Math.max;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

public class ScaleLayout extends Layout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ScaleProvider scaleProvider;

	public ScaleLayout(ScaleProvider scaleProvider) {
		this.scaleProvider = scaleProvider;
	}

	public ScaleProvider getScaleProvider() {
		return scaleProvider;
	}

	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint,
			boolean flushCache) {
		Scale scale = scaleProvider.getScale();
		Point result = newSize(0, 0, wHint, hHint);
		for (ScaleData columnHead : getColumnHeads(scale, composite)) {
			Point columnSize = computeColumnSize(scale, columnHead);
			result = new Point(result.x + columnSize.x, max(result.y,
					columnSize.y));
		}
		return newSize(result.x, result.y, wHint, hHint);
	}

	private static Point newSize(int width, int height, int wHint, int hHint) {
		return new Point(wHint == SWT.DEFAULT ? width : wHint,
				hHint == SWT.DEFAULT ? height : hHint);
	}

	private static Point computeColumnSize(Scale scale, ScaleData columnHead) {
		Point result = new Point(0, 0);
		for (ScaleData element : getTiedElements(scale, columnHead)) {
			Point size = computeSize(scale, element);
			Rectangle margin = element.on(scale).getMargin();
			int x = max(result.x, size.x + margin.x + margin.width);
			int y = result.y + size.y + margin.y + margin.height;
			result = new Point(x, y);
		}
		return result;
	}

	@Override
	protected void layout(Composite composite, boolean flushCache) {
		Scale scale = scaleProvider.getScale();
		int xPos = composite.getClientArea().x;
		for (ScaleData columnHead : getColumnHeads(scale, composite)) {
			int columnWidth = layoutColumn(scale, columnHead, composite, xPos);
			xPos += columnWidth;
		}
	}

	private static int layoutColumn(Scale scale, ScaleData head,
			Composite composite, int xPos) {
		int result = calculateColumnWidth(scale, head);
		int yPos = composite.getClientArea().y;
		for (ScaleData element : getTiedElements(scale, head)) {
			Rectangle bounds = calculateElementBounds(scale, element, xPos,
					yPos, result);
			bounds.height = adjustHeightIfBottomAttached(scale, element,
					bounds, head, composite);
			bounds.width = adjustWidthIfRightAttached(scale, element, bounds,
					head, composite);
			element.getControl().setBounds(bounds);
			Rectangle margin = element.on(scale).getMargin();
			yPos += bounds.height + margin.y + margin.height;
		}
		return result;
	}

	private static Rectangle calculateElementBounds(Scale scale,
			ScaleData element, int x, int y, int width) {
		int height = computeSize(scale, element).y;
		Rectangle margin = element.on(scale).getMargin();
		return new Rectangle(x + margin.x, y + margin.y, width - margin.x
				- margin.width, height);
	}

	private static int adjustHeightIfBottomAttached(Scale scale,
			ScaleData element, Rectangle bounds, ScaleData columnHead,
			Composite composite) {
		int result = bounds.height;
		List<ScaleData> elements = getTiedElements(scale, columnHead);
		if (isLastElementInList(element, elements)
				&& !hasHeightHint(scale, element)) {
			Rectangle margin = element.on(scale).getMargin();
			result = composite.getClientArea().height - bounds.y
					- margin.height;
		}
		return result;
	}

	private static int adjustWidthIfRightAttached(Scale scale,
			ScaleData element, Rectangle bounds, ScaleData head,
			Composite composite) {
		int result = bounds.width;
		List<ScaleData> columnHeads = getColumnHeads(scale, composite);
		if (isLastElementInList(head, columnHeads)
				&& !hasWidthHint(scale, element)) {
			Rectangle margin = element.on(scale).getMargin();
			result = composite.getClientArea().width - bounds.x - margin.width;
		}
		return result;
	}

	private static List<ScaleData> getColumnHeads(Scale scale,
			Composite composite) {
		List<ScaleData> result = new LinkedList<ScaleData>();
		for (Control control : composite.getChildren()) {
			ScaleData data = (ScaleData) control.getLayoutData();
			if (data != null && !data.on(scale).hasPredecessor()) {
				result.add(data);
			}
		}
		return result;
	}

	private static int calculateColumnWidth(Scale scale, ScaleData head) {
		int result = 0;
		for (ScaleData element : getTiedElements(scale, head)) {
			Rectangle margin = element.on(scale).getMargin();
			result = max(result, computeSize(scale, element).x + margin.x
					+ margin.width);
		}
		return result;
	}

	private static List<ScaleData> getTiedElements(Scale scale,
			ScaleData firstElement) {
		List<ScaleData> result = new LinkedList<ScaleData>();
		result.add(firstElement);
		if (firstElement.on(scale).hasSuccessor()) {
			ScaleData successor = firstElement.on(scale).getSuccessor();
			result.addAll(getTiedElements(scale, successor));
		}
		return result;
	}

	private static Point computeSize(Scale scale, ScaleData element) {
		ScaleDetail detail = element.on(scale);
		Control control = element.getControl();
		return control.computeSize(detail.getWidth(), detail.getHeight(), true);
	}

	private static boolean isLastElementInList(ScaleData element,
			List<ScaleData> elements) {
		return element == elements.get(elements.size() - 1);
	}

	private static boolean hasHeightHint(Scale scale, ScaleData element) {
		return element.on(scale).getHeight() != SWT.DEFAULT;
	}

	private static boolean hasWidthHint(Scale scale, ScaleData element) {
		return element.on(scale).getWidth() != SWT.DEFAULT;
	}

}
