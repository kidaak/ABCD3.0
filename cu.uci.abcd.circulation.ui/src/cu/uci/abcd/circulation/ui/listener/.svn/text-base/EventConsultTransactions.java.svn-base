package cu.uci.abcd.circulation.ui.listener;

import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;

public class EventConsultTransactions implements Listener {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Composite agrupa;
		private Composite busquedaB;
		private Composite busquedaA;
		private Link link;
		
		

		public EventConsultTransactions(Composite agrupa,Composite busquedaB, Composite busquedaA, Link link) {
			super();
			this.agrupa = agrupa;
			this.busquedaB = busquedaB;
			this.busquedaA = busquedaA;
			this.link = link;
		}
		
	@Override
	public void handleEvent(Event arg0) {
		if (link.getText().equals("<a>Búsqueda Avanzada</a>")) {
			agrupa.setSize(720, 350);
			FormData tempo=(FormData)agrupa.getLayoutData();
			tempo.height=350;
			busquedaB.setVisible(false);
			busquedaA.setVisible(true);
			agrupa.getShell().layout(true, true);
			agrupa.getShell().redraw();
			agrupa.getShell().update();
			link.setText("<a>Búsqueda Básica</a>"); 
		}
		else if (link.getText().equals("<a>Búsqueda Básica</a>")) {
			agrupa.setSize(720,270);
			FormData tempo=(FormData)agrupa.getLayoutData();
			tempo.height=270;
			busquedaB.setVisible(true);
			busquedaA.setVisible(false);
			agrupa.getShell().layout(true, true);
			agrupa.getShell().redraw();
			agrupa.getShell().update();
			link.setText("<a>Búsqueda Avanzada</a>");  
		}
		
	}

}
