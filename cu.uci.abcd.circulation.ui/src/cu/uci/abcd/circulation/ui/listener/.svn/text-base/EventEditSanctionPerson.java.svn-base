package cu.uci.abcd.circulation.ui.listener;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


public class EventEditSanctionPerson implements Listener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Composite composite;
    private Button rdbSMulta;
 
   
	public EventEditSanctionPerson(Composite composite,Button rdbSMulta) {
		super();
	   	this.composite = composite;
	    this.rdbSMulta=rdbSMulta;
				
	}
	
	
				

	@Override
	public void handleEvent(Event arg0) {
		if (rdbSMulta.getSelection() == true) {
			composite.setVisible(true);
			composite.getShell().layout(true, true);
			composite.getShell().redraw();
			composite.getShell().update();			
		  }
		else if (rdbSMulta.getSelection()==false) {
			composite.setVisible(false);
			composite.getShell().layout(true, true);
			composite.getShell().redraw();
			composite.getShell().update();			 
		}
	}
}
