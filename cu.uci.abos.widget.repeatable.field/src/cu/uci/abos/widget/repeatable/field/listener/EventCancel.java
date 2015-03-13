package cu.uci.abos.widget.repeatable.field.listener;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class EventCancel implements Listener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CTabFolder tabFolder;
	private int position;
	
	public EventCancel(CTabFolder tabFolder, int position){
		this.tabFolder = tabFolder;
		this.position = position;
	}

	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		
		tabFolder.setSelection(position);
		
	}

}
