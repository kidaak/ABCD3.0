
package cu.uci.abcd.adquisicion.iu.controller;

import java.util.Map;

import org.unesco.jisis.corelib.exceptions.DbException;
import org.unesco.jisis.corelib.record.IRecord;

import cu.uci.abcd.adquisicion.IRegistrationManageAcquisitionServices;
import cu.uci.abcd.dataprovider.jisis.exception.JisisDatabaseException;
import cu.uci.abos.ui.api.IViewController;

public class RegistrarRegistroDeAdquisicionController implements IViewController {

	private IRegistrationManageAcquisitionServices registrationServices;

	public void RegisterAcquisition(IRecord record) throws DbException {
		try {
			registrationServices.RegisterAcquisition(record);
		} catch (JisisDatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	public void bind(IRegistrationManageAcquisitionServices registrationServices, Map<?, ?> properties) {
		this.registrationServices = registrationServices;
	}
}
