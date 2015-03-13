package cu.uci.abos.widget.repeatable.field.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import cu.uci.abos.widget.repeatable.field.CataloguingComponent;
import cu.uci.abos.widget.repeatable.field.ControlType;
import cu.uci.abos.util.api.FormDatas;

public class EventSimpleAdd implements Listener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String textName = "";
	private Composite father;
	private Composite parent;
	private ControlType controlType;
	
	public EventSimpleAdd(String text, Composite father, Composite parent, ControlType controlType){
		
		this.textName = text;
		this.father = father;
		this.parent = parent;
		this.controlType = controlType;
	}
	
	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		
		CataloguingComponent component = new CataloguingComponent(father, 0, textName, controlType);
		
		int childrenCount = father.getChildren().length;
		
		component.getLink().addListener(SWT.Selection, new EventSimpleDelete(parent, father, component));
		
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
	}
	
	

}
