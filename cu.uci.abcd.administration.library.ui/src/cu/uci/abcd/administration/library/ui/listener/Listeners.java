package cu.uci.abcd.administration.library.ui.listener;

import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;

public class Listeners implements Listener{

	private static final long serialVersionUID = 1L;
	private Composite test1;
	private Link link;

	public Listeners(Composite test1, Link link) {
		super();
		this.test1 = test1;
		this.link = link;
	}

	@Override
	public void handleEvent(Event arg0) {
		if (link.getText().equals("<a>Busqueda Avanzada</a>")) {
			test1.setSize(705, 210);
			FormData tempo=(FormData)test1.getLayoutData();
			tempo.height=210;
			test1.setLayoutData(tempo);
		    test1.getShell().layout(true, true);
			test1.getShell().redraw();
			test1.getShell().update();
			link.setText("<a>Busqueda Basica</a>");
		} else if (link.getText().equals("<a>Busqueda Basica</a>")) {
			test1.setSize(705, 100);
			FormData tempo=(FormData)test1.getLayoutData();
			tempo.height=100;
			test1.setLayoutData(tempo);
			test1.getShell().layout(true, true);
			test1.getShell().redraw();
			test1.getShell().update();
			link.setText("<a>Busqueda Avanzada</a>");
		}

	}

}
