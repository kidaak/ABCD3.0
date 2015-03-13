package cu.uci.abcd.administration.nomenclators.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import cu.uci.abcd.administration.nomenclators.IManageNomenclator;
import cu.uci.abcd.dao.common.NomenclatorDAO;
import cu.uci.abcd.domain.common.Nomenclator;


public class NomenclatorImpl implements IManageNomenclator {
	private NomenclatorDAO nomenclatorDAO;
	
    
	@Override
	public Nomenclator RegisterNomenclator(Nomenclator tNomenclator) {
		// TODO Auto-generated method stub
		return nomenclatorDAO.save(tNomenclator);
	}

	@Override
	public Nomenclator SearchNomenclator(long tNomenclatorID) {
		// TODO Auto-generated method stub
		 return nomenclatorDAO.findOne(tNomenclatorID);

	}
	@Override
	public List<Nomenclator> ListAll() {
		// TODO Auto-generated method stub
		
		return (List<Nomenclator>) nomenclatorDAO.findAll();
	}

	@Override
	public void DeleteNomenclator(long tUserID) {
		// TODO Auto-generated method stub
		Nomenclator deleteNomenclator = nomenclatorDAO.findOne(tUserID);
		nomenclatorDAO.delete(deleteNomenclator);

	}
	
	public void bind(NomenclatorDAO nomenclatorDAO, Map <?, ?> properties){
		this.nomenclatorDAO = nomenclatorDAO;
	}

}
