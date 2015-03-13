package cu.uci.abcd.administration.nomenclators.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.administration.nomenclators.IManageRecordType;
import cu.uci.abcd.dao.common.RecordTypeDAO;
import cu.uci.abcd.domain.common.RecordType;


public class RecordTypeImpl implements IManageRecordType {
	private RecordTypeDAO recordTypeDAO;

	@Override
	public RecordType RegisterRecordType(RecordType tRecord) {
		return recordTypeDAO.save(tRecord);
	}

	@Override
	public RecordType SearchRecordType(long tRecordID) {
		
		return recordTypeDAO.findOne(tRecordID);
	}

	@Override
	public Collection<RecordType> ListAll(){
		
		return (Collection<RecordType>) recordTypeDAO.findAll();
	}
	@Override
	public void DeleteRecordType(long tRecordID) {
		// TODO Auto-generated method stub
		RecordType deleteRT = recordTypeDAO.findOne(tRecordID);
		recordTypeDAO.delete(deleteRT);
		
	}

	
	 public void bind1(Object recordTypeDAO, Map <?, ?> properties){
		 this.recordTypeDAO = (RecordTypeDAO) recordTypeDAO;
		}

}
