package cu.uci.abcd.cataloguing.controller;

import java.util.List;
import java.util.Map;

import org.unesco.jisis.corelib.record.Record;
import org.unesco.jisis.corelib.common.WorksheetDef;
import org.unesco.jisis.corelib.exceptions.DbException;

import cu.uci.abcd.cataloguing.IDataBaseManager;
import cu.uci.abcd.dataprovider.jisis.IJisisDataProvider;
import cu.uci.abcd.dataprovider.jisis.exception.JisisDatabaseException;
import cu.uci.abos.ui.api.IViewController;

public class RegisterController implements IViewController {
	
	private IDataBaseManager service;
	
	public void saveRecord(Record record, List<String> ids, String dataBaseName)throws DbException{
		
		try {
			service.saveRecord(record, ids, dataBaseName);
			
		} catch (JisisDatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<String> getWorksheetNames(String dataBaseName)
			throws JisisDatabaseException {
		// TODO Auto-generated method stub
		return service.getWorksheetNames(dataBaseName);
	}
	
	public WorksheetDef getWorksheet(String worksheetName, String dataBaseName)
			throws JisisDatabaseException {
		// TODO Auto-generated method stub
		return service.getWorksheet(worksheetName, dataBaseName);
	}
	
	public IJisisDataProvider getService(){return service.getService();}
	
	
	
	public void bind(IDataBaseManager service, Map<?, ?> properties) {
		this.service = service;
	}

}
