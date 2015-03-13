package cu.uci.abos.widget.repeatable.field.listener;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Listener;

public class EventDelete implements Listener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ExpandBar expandBar;
	private ExpandItem expandItem;
	    
    public EventDelete(ExpandItem expandItem, ExpandBar expandBar){
	    	
	   this.expandItem = expandItem;
	   this.expandBar = expandBar;
	   
	}
	
	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		
		expandItem.dispose();
		   
		expandBar.getShell().layout(true, true);
	    expandBar.getShell().redraw();
		expandBar.getShell().update();
	
	}

}
