package cu.uci.abos.widget.repeatable.field.listener;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import cu.uci.abos.util.api.FormDatas;
import cu.uci.abos.widget.repeatable.field.CataloguingComponent;

public class EventSimpleDelete implements Listener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Composite parent;
	private Composite father;
	private CataloguingComponent cataloguingComponent;
	
	public EventSimpleDelete(Composite parent, Composite father, CataloguingComponent component){
		
		this.parent = parent;
		
		this.father = father;
		
		this.cataloguingComponent = component;
		
	}

	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		
		cataloguingComponent.dispose();
		
		int childrenCount = father.getChildren().length;
		
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
	}

}
