package cu.uci.abos.widget.repeatable.field.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import cu.uci.abos.widget.repeatable.field.ControlType;
import cu.uci.abos.widget.repeatable.field.CataloguingComponent;
import cu.uci.abos.util.api.FormDatas;

public class EventAddField implements Listener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String textName = "";
	private Composite father;
	private ExpandItem expandItem;
	private Composite parent;
	private int type;
	private Link link;
	private ControlType controlType;
	private Control control;
	private CTabFolder tabFolder;
	private String description;
	private int tag;

	
	public EventAddField(String text, Composite father, ExpandItem expandItem, Composite parent, int type, ControlType controlType, CTabFolder tabFolder,
			String description, int tag){
	
		this.textName = text;
		this.father = father;
		this.expandItem = expandItem;
		this.parent = parent;
		this.type = type;
		this.controlType = controlType;
		this.tabFolder = tabFolder;
		this.description = description;
		this.tag = tag;
	}
	
	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		
		CataloguingComponent component = new CataloguingComponent(father, 0, type, textName, controlType, expandItem, tabFolder, description, tag);
		
	    int childrenCount = father.getChildren().length;
		
		component.getLink().addListener(SWT.Selection, new EventDeteleField(parent, expandItem, father, component));
		
        FormDatas.attach(component).atTopTo(father, 0);
		
		for (int i = childrenCount -2; i > -1; i--) {
			
			FormDatas.attach(father.getChildren()[i]).atTopTo(father.getChildren()[i+1], 10);
			
		}
		
		father.getShell().layout(true, true);
	    father.getShell().redraw();
		father.getShell().update();
		
		parent.getShell().layout(true, true);
	    parent.getShell().redraw();
		parent.getShell().update();
		
		expandItem.setHeight(parent.computeSize(SWT.DEFAULT,
				SWT.DEFAULT).y+5);
	  		
	}

	public Link getLin() {
		return link;
	}

	public void setLin(Link lin) {
		this.link = lin;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}
	

}
