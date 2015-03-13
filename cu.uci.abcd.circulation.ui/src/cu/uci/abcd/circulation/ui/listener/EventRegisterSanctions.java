package cu.uci.abcd.circulation.ui.listener;

import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class EventRegisterSanctions implements Listener {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	        private Composite agrupa;
			private Composite busquedaB;
			private Composite compo;
			private Button icono;
			private Button di;

			public EventRegisterSanctions(Composite agrupa,Composite busquedaB, Composite compo, Button icono, Button di) {
				super();
				this.agrupa = agrupa;
				this.busquedaB = busquedaB;
				this.compo = compo;
				this.icono = icono;
				this.di = di;
				
			}
			
		@Override
		public void handleEvent(Event arg0) {
			if (icono.isVisible() == true) {
				agrupa.setSize(720, 220);
				FormData tempo=(FormData)agrupa.getLayoutData();
				tempo.height=220;
				busquedaB.setVisible(false);
				compo.setVisible(true);
				agrupa.getShell().layout(true, true);
				agrupa.getShell().redraw();
				agrupa.getShell().update();
				
				
			}
			else if (di.isVisible() == true) {
				agrupa.setSize(720,110);
				FormData tempo=(FormData)agrupa.getLayoutData();
				tempo.height=110;
				busquedaB.setVisible(true);
				compo.setVisible(false);
				agrupa.getShell().layout(true, true);
				agrupa.getShell().redraw();
				agrupa.getShell().update();
							
			}
			
		}

}
