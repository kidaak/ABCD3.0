package cu.uci.abcd.circulation.ui.listener;

import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;

public class EventConsultSanction implements Listener {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    private Composite agrupa;
		private Composite busquedaB;
		private Composite busquedaA;
		private Link link;
		
		

		public EventConsultSanction(Composite agrupa,Composite busquedaB, Composite busquedaA, Link link) {
			super();
			this.agrupa = agrupa;
			this.busquedaB = busquedaB;
			this.busquedaA = busquedaA;
			this.link = link;
		}
		
	@Override
	public void handleEvent(Event arg0) {
		if (link.getText().equals("<a>Búsqueda Avanzada</a>")||link.getText().equals("<a>Advanced Search</a>")){
			agrupa.setSize(720, 320);
			FormData tempo=(FormData)agrupa.getLayoutData();
			tempo.height=320;
			busquedaB.setVisible(false);
			busquedaA.setVisible(true);
			agrupa.getShell().layout(true, true);
			agrupa.getShell().redraw();
			agrupa.getShell().update();
			link.setText("<a>Búsqueda Básica</a>"); 
		}
		else if (link.getText().equals("<a>Búsqueda Básica</a>")||link.getText().equals("<a>Basic Search</a>")){
			agrupa.setSize(720,110);
			FormData tempo=(FormData)agrupa.getLayoutData();
			tempo.height=110;
			busquedaB.setVisible(true);
			busquedaA.setVisible(false);
			agrupa.getShell().layout(true, true);
			agrupa.getShell().redraw();
			agrupa.getShell().update();
			link.setText("<a>Búsqueda Avanzada</a>");  
		}
		
	}

}
