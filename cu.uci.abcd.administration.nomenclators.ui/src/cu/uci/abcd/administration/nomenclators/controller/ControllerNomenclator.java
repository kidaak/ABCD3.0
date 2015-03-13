package cu.uci.abcd.administration.nomenclators.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import cu.uci.abcd.administration.nomenclators.IManageNomenclator;
import cu.uci.abcd.domain.common.Nomenclator;
import cu.uci.abos.ui.api.IViewController;

public class ControllerNomenclator implements IViewController{
    private IManageNomenclator manageNomenclator;
    
    public Nomenclator RegisterNomenclator(Nomenclator tNomenclator){
    	return manageNomenclator.RegisterNomenclator(tNomenclator);
    }
	public Nomenclator SearchNomenclator(long tNomenclatorID){
		return manageNomenclator.SearchNomenclator(tNomenclatorID);
	}
	public List<Nomenclator> ListAll(){
		return manageNomenclator.ListAll();
	}
	public void DeleteNomenclator(long tNomenclatorID){
		manageNomenclator.DeleteNomenclator(tNomenclatorID);
	}
	
	public void bind(IManageNomenclator manageNomenclator, Map<?, ?> properties) {
		this.manageNomenclator= manageNomenclator;
	}
}
	
