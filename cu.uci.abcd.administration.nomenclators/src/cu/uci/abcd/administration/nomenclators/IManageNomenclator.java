package cu.uci.abcd.administration.nomenclators;

import java.util.Collection;
import java.util.List;

import cu.uci.abcd.domain.common.Nomenclator;




/**
 * 
 * @author Dayana Rivera
 *
 */
public interface IManageNomenclator {
	
    public Nomenclator RegisterNomenclator(Nomenclator tNomenclator);
	
	public Nomenclator SearchNomenclator(long tNomenclatorID); 
	
	public List<Nomenclator> ListAll();
	
	public void DeleteNomenclator(long tUserID); 
	
	
	
}

