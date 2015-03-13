package cu.uci.abcd.cataloguing.impl;



import java.util.List;
import java.util.Map;

import org.unesco.jisis.corelib.common.FieldDefinitionTable;
import org.unesco.jisis.corelib.common.FieldSelectionTable;
import org.unesco.jisis.corelib.common.PrintFormat;
import org.unesco.jisis.corelib.common.WorksheetDef;
import org.unesco.jisis.corelib.record.IRecord;
import org.unesco.jisis.corelib.record.Record;
import cu.uci.abcd.dataprovider.jisis.IJisisDataProvider;
import cu.uci.abcd.cataloguing.IDataBaseManager;
import cu.uci.abcd.dataprovider.jisis.exception.JisisDatabaseException;
import cu.uci.abcd.dataprovider.jisis.search.option.Option;


public class DataBaseManager implements IDataBaseManager {

	private IJisisDataProvider service;
	

	@Override
	public void createDatabase(String name, FieldDefinitionTable fdt,
			FieldSelectionTable fst, WorksheetDef defaultWorksheet,
			PrintFormat defaultPft) throws JisisDatabaseException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteRecord(IRecord record, String databaseName)
			throws JisisDatabaseException {
		
		service.deleteRecord(record, databaseName);
		
	}



	@Override
	public void updateRecord(IRecord record, String databaseName)
			throws JisisDatabaseException {
		// TODO Auto-generated method stub
		
		service.updateRecord(record, databaseName);
		
	}



	@Override
	public void removeDatabase(String name) throws JisisDatabaseException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<String> getDatabaseNames() throws JisisDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void saveRecord(IRecord record, List<String> ids ,String databaseName)
			throws JisisDatabaseException {
		// TODO Auto-generated method stub
		
		service.saveRecord(record, databaseName);
		
	}



	@Override
	public void saveFieldSelectionTable(FieldSelectionTable fst)
			throws JisisDatabaseException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public FieldSelectionTable getFieldSelectionTable(String databaseName)
			throws JisisDatabaseException {
		// TODO Auto-generated method stub
		
		return service.getFieldSelectionTable(databaseName);
	}



	@Override
	public List<Record> findByOptions(List<Option> options, String databaseName)
			throws JisisDatabaseException {
		// TODO Auto-generated method stub
		
		return service.findByOptions(options, databaseName);
	}



	@Override
	public List<Record> find(String term, String databaseName)
			throws JisisDatabaseException {
		// TODO Auto-generated method stub
		
		return service.find(term, databaseName);
	}



	@Override
	public List<String> getWorksheetNames(String databaseName)
			throws JisisDatabaseException {
		// TODO Auto-generated method stub
		return service.getWorksheetNames(databaseName);
	}



	@Override
	public WorksheetDef getWorksheet(String worksheetName, String databaseName)
			throws JisisDatabaseException {
		// TODO Auto-generated method stub
		return service.getWorksheet(worksheetName, databaseName);
	}
	
	
	
	public void bind(IJisisDataProvider provider, Map<?, ?> properties){
		this.service = provider;
	}

	public IJisisDataProvider getService() {
		// TODO Auto-generated method stub
		return service;
	}
	
}
