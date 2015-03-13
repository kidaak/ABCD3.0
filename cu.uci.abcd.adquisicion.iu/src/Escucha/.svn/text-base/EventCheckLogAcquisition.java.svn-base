package Escucha;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.unesco.jisis.corelib.exceptions.DbException;

import cu.uci.abcd.adquisicion.iu.controller.ConsultarRegistroDeAdquisicionController;
import cu.uci.abos.ui.api.IViewController;


public class EventCheckLogAcquisition implements Listener{

	
	 
	 
	private static final long serialVersionUID = 1L;
	private Text title;
	private Text author;
	private Combo typeOfAcquisition;
	private Combo itemType;
	private Combo state;
	private DateTime since;
	private DateTime untli;
	private ConsultarRegistroDeAdquisicionController controller;	

	public EventCheckLogAcquisition(Text title, Text author, Combo typeOfAcquisition,Combo itemType
			,Combo state, DateTime dt_Desde,DateTime dateTimeHasta,
			IViewController controller2) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.author = author;
		this.typeOfAcquisition = typeOfAcquisition;
		this.itemType = itemType;
		this.state = state;
		this.since = dt_Desde;
		this.untli= dateTimeHasta;
		this.controller = (ConsultarRegistroDeAdquisicionController) controller2;
	}


	@Override
	public void handleEvent(Event arg0) {
		// TODO Auto-generated method stub
		
		try {
			controller.consultService(title.getText(),author.getText(),typeOfAcquisition.getText());
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
