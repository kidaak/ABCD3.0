package cu.uci.abcd.circulation.ui.listener;

import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;

public class EventConsultUserLoan implements Listener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Composite busquedaA;
	private Link link;

	public EventConsultUserLoan(Composite busquedaA, Link link) {
		super();
		this.busquedaA = busquedaA;
		this.link = link;
	}

	@Override
	public void handleEvent(Event arg0) {
		if (link.getText().equals("<a>Búsqueda Avanzada</a>")) {
			busquedaA.setSize(800, 210);
			FormData tempo=(FormData)busquedaA.getLayoutData();
			tempo.height=210;
			busquedaA.setLayoutData(tempo);
		    busquedaA.getShell().layout(true, true);
			busquedaA.getShell().redraw();
			busquedaA.getShell().update();
			link.setText("<a>Búsqueda Básica</a>");
		} 
		else if (link.getText().equals("<a>Búsqueda Básica</a>")) {
			busquedaA.setSize(800, 75);
			FormData tempo=(FormData)busquedaA.getLayoutData();
			tempo.height=75;
			busquedaA.setLayoutData(tempo);
			busquedaA.getShell().layout(true, true);
			busquedaA.getShell().redraw();
			busquedaA.getShell().update();
			link.setText("<a>Búsqueda Avanzada</a>");
		}

	}

}
