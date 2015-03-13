package cu.uci.abcd.circulation.ui.listener;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;


public class EventConsultObjectLoan implements Listener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Composite busquedaB;
	private Composite busquedaA;
	private Link link;
	

	public EventConsultObjectLoan(Composite busquedaA, Link link) {
		super();
	
		this.busquedaA = busquedaA;
		this.link = link;
	}
	
	@Override
	public void handleEvent(Event arg0) {
		
		if (link.getText().equals("<a>Búsqueda Avanzada</a>")) {
			busquedaA.setVisible(true);
		    link.setText("<a>Búsqueda Básica</a>"); 
		}
		else if (link.getText().equals("<a>Búsqueda Básica</a>")) {
			busquedaA.setVisible(false);
			link.setText("<a>Búsqueda Avanzada</a>");  
		}
		
		
		}
}
