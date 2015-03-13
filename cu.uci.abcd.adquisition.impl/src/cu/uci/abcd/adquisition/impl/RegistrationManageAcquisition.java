package cu.uci.abcd.adquisition.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.unesco.jisis.corelib.exceptions.DbException;
import org.unesco.jisis.corelib.record.IRecord;
import org.unesco.jisis.corelib.record.Record;

import cu.uci.abcd.adquisicion.IRegistrationManageAcquisitionServices;
import cu.uci.abcd.dataprovider.jisis.IJisisDataProvider;
import cu.uci.abcd.dataprovider.jisis.exception.JisisDatabaseException;
import cu.uci.abcd.dataprovider.jisis.search.option.Option;
import cu.uci.abcd.dataprovider.jisis.search.option.OptionAND;

//3.10. Manage Registry Acquisition

public class RegistrationManageAcquisition implements IRegistrationManageAcquisitionServices{

	private IJisisDataProvider registro ;
	private Option option1 ;
	private Option option2 ;
	private Option option3 ;
	
	

	public List<Option> listOption(String parametro1, String parametro2){
		option1 = new OptionAND("title", parametro1);
		option2 = new OptionAND("author",parametro2);

		List <Option> list = Arrays.asList(option1,option2);

		return list;
	}

	//RF_AQ15_Registry Acquisition
	@Override
	public void RegisterAcquisition(IRecord newRecord) throws JisisDatabaseException  {
		// TODO Auto-generated method stub
		

		try {
			if(registro.findByOptions(listOption(newRecord.getField(2).getStringFieldValue(), newRecord.getField(3).getStringFieldValue()), "Registro_De_Adquisicion").isEmpty())
				registro.saveRecord(newRecord,"Registro_De_Adquisicion");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void EditRecordAcquisition(Record record, Record newRecord) {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < record.getFieldCount(); i++) {
				if(record.getField(i).getFieldValue() != newRecord.getField(i).getFieldValue())
					record.getField(i).setFieldValue(newRecord.getField(i).getFieldValue());
			} 


		} catch (DbException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			registro.updateRecord(record, "Registro_De_Adquisicion");
		} catch (JisisDatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//RF_AQ18_ Delete Record Acquisition
	@Override
	public void DeleteRecordAcquisition(Record newRecord) throws JisisDatabaseException {
		// TODO Auto-generated method stub
		try {
			listOption(newRecord.getField(2).getStringFieldValue(), newRecord.getField(3).getStringFieldValue());
			
			for (int i = 0; i < registro.findByOptions(listOption(newRecord.getField(2).getStringFieldValue(), 
					newRecord.getField(3).getStringFieldValue()), "Registro_De_Adquisicion").size(); i++) {
				if (registro.findByOptions(listOption(newRecord.getField(2).getStringFieldValue(), 
						newRecord.getField(3).getStringFieldValue()), "Registro_De_Adquisicion").get(i).equals(newRecord)) {
					registro.deleteRecord(newRecord,"Registro_De_Adquisicion");
				}
			}
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void bind(IJisisDataProvider registro, Map<?, ?> properties) {
		this.registro = registro;
	}

	@Override
	public List<Record> findRecord(String parametro1,String parametro2,String parametro3) {
		// TODO Auto-generated method stub
		option1 = new OptionAND("title", parametro1);
		option2 = new OptionAND("author",parametro2);
		option3 = new Option("Tipo de Material",parametro3);
		
		List <Option> aux = new ArrayList<>();
		aux.add(0, option1);
		aux.add(1, option2);
		aux.add(3, option3);
		
			
		try {
			return registro.findByOptions(aux, "Registro_De_Adquisicion");
		} catch (JisisDatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}




}
