package cu.uci.abos.widget.repeatable.field.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Listener;

import cu.uci.abos.widget.repeatable.field.CataloguingComponent;
import cu.uci.abos.util.api.FormDatas;

public class EventDeteleField implements Listener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Composite parent;
	private Composite father;
	private ExpandItem expandItem;
	private CataloguingComponent cataloguingComponent;
	
	
	public EventDeteleField(Composite parent, ExpandItem expandItem, Composite father,CataloguingComponent cataloguingComponent){
		this.parent = parent;
		this.expandItem = expandItem;
		this.father = father;
		this.cataloguingComponent = cataloguingComponent;	
	}
	
	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		
		int childrenCount = father.getChildren().length;
		
		cataloguingComponent.dispose();
		
        childrenCount = father.getChildren().length;
		
		Composite last = (Composite)father.getChildren()[childrenCount - 1];
		
		FormDatas.attach(last).atTopTo(father, 0);
		
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

}
