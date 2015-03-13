package cu.uci.abos.widgets.grid;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class Column {
	
	private Image image;
	private String header;
	private int percentWidth, initialWidth;
	private boolean moveable;
	private int alignment;
	private int index;
	private List<TreeColumnListener> listeners;
	private ImageManager imageManager;
	private Method dataExtractor;
	private IEditableArea editableArea;

	
	public Column(Display display, String imageFileName, IEditableArea editableArea, TreeColumnListener mouseDown) {	//Action columns with editable area.
		this.initialize(display, imageFileName, "", -1, -1, editableArea, mouseDown);
	}
	
	public Column(Display display, String imageFileName, TreeColumnListener mouseDown) {	//Action columns without editable area.
		this.initialize(display, imageFileName, "", -1, -1, null, mouseDown);
	}
	
	public Column(int percentWidth, int index) {	//Data column.
		this.initialize(null, "", "", percentWidth, index, null, null);
	}
	
	private void initialize(Display display, String imageFileName, String header, int percentWidth, int index, IEditableArea editableArea, TreeColumnListener mouseDown) {
		if(display != null) {
			this.imageManager = new ImageManager(display);
			if(imageFileName != "") {
				this.image = imageManager.loadImage(imageFileName);
			}
		}
		this.header = header;
		this.percentWidth = percentWidth;
		this.index = index;
		this.listeners = new LinkedList<TreeColumnListener>();		
		if(mouseDown != null) {
			this.listeners.add(mouseDown);
		}
		this.setEditableArea(editableArea);
		this.alignment = SWT.CENTER;
		this.moveable = true;
	}
	
	public String getHeader() {
		return this.header;
	}
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	public int getPercentWidth() {
		return this.percentWidth;
	}
	
	public int getInitialWidth() {
		return this.initialWidth;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public boolean getMoveable() {
		return this.moveable;
	}
	
	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}
	
	public int getAlignment() {
		return this.alignment;
	}
	
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void addListener(TreeColumnListener listener) {
		this.listeners.add(listener);
	}
	
	public void fireListeners(TreeColumnEvent eventData) {
		eventData.editableArea = this.editableArea;
		for(int i = this.listeners.size() - 1; i >= 0; i--) {
			TreeColumnListener listener = this.listeners.get(i);
			listener.handleEvent(eventData);
		}
	}

	public void setDataExtractor(Method dataExtractor) {
		this.dataExtractor = dataExtractor;
	}
	
	public Object getCellData(IGridViewEntity entity) {
		Object result = null;
		try {
			result = this.dataExtractor.invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public IEditableArea getEditableArea() {
		return editableArea;
	}

	public void setEditableArea(IEditableArea editableArea) {
		this.editableArea = editableArea;
	}
}
