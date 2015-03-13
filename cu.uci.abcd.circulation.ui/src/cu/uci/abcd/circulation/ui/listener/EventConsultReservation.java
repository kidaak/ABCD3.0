package cu.uci.abcd.circulation.ui.listener;

import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;

public class EventConsultReservation implements Listener {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Composite agrupa;
		private Composite busquedaB;
		private Composite busquedaA;
		private Link link;
		
		

		public EventConsultReservation(Composite agrupa,Composite busquedaB, Composite busquedaA, Link link) {
			super();
			this.agrupa = agrupa;
			this.busquedaB = busquedaB;
			this.busquedaA = busquedaA;
			this.link = link;
		}
		
	@Override
	public void handleEvent(Event arg0) {
		if (link.getText().equals("<a>Búsqueda Avanzada</a>")) {
			agrupa.setSize(710, 300);
			FormData tempo=(FormData)agrupa.getLayoutData();
			tempo.height=300;
			busquedaB.setVisible(false);
			busquedaA.setVisible(true);
			agrupa.getShell().layout(true, true);
			agrupa.getShell().redraw();
			agrupa.getShell().update();
			link.setText("<a>Búsqueda Básica</a>"); 
		}
		else if (link.getText().equals("<a>Búsqueda Básica</a>")) {
			agrupa.setSize(710,130);
			FormData tempo=(FormData)agrupa.getLayoutData();
			tempo.height=130;
			busquedaB.setVisible(true);
			busquedaA.setVisible(false);
			agrupa.getShell().layout(true, true);
			agrupa.getShell().redraw();
			agrupa.getShell().update();
			link.setText("<a>Búsqueda Avanzada</a>");  
		}
		
	}

}
