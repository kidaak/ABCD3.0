package cu.uci.abcd.adquisicion.iu.controller;

import java.util.List;
import java.util.Map;

import org.unesco.jisis.corelib.exceptions.DbException;
import org.unesco.jisis.corelib.record.Record;

import cu.uci.abcd.adquisicion.IRegistrationManageAcquisitionServices;
import cu.uci.abos.ui.api.IViewController;

public class ConsultarRegistroDeAdquisicionController implements IViewController {
	private IRegistrationManageAcquisitionServices consultServices;

	public List<Record> consultService(String parametro1, String parametro2, String parametro3) throws DbException {
		return consultServices.findRecord(parametro1,parametro2,parametro3); 
	}
	
	
	public void bind(IRegistrationManageAcquisitionServices registrationServices, Map<?, ?> properties) {
		this.consultServices = registrationServices;
	}

}
