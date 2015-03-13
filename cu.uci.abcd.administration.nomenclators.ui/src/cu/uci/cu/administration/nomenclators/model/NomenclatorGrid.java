package cu.uci.cu.administration.nomenclators.model;

import java.util.List;


import cu.uci.abcd.domain.common.Nomenclator;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

/**
 * 
 * @author Dayana Rivera
 *
 */

public class NomenclatorGrid extends Nomenclator implements IGridViewEntity{

	/**
	 * 
	 */
	

	public NomenclatorGrid(String nomenclatorType, String lNomenclator, String description) {
		super();
		this.setNomenclatorCode(nomenclatorType);
		this.setNomeclatorName(lNomenclator);
		this.setNomenclatorDescription(description);
		
	}
	
	public NomenclatorGrid() {
		super();
	}
	
	@TreeTableColumn(percentWidth=30, index=0)
	public String getNomenclatorType() {
		return super.getNomenclatorCode();
	}
	@TreeTableColumn(percentWidth=20, index=1)
	public String getNomenclatorN() {
		return super.getNomeclatorName();
	}
	@TreeTableColumn(percentWidth=30, index=2)
	public String getNomenclatorD() {
		return super.getNomenclatorDescription();
	}
	@TreeTableColumn(percentWidth=20, index=2)
	public String getNomenclatorU() {
		return super.getNomenclatorDescription();
	}
	
	@Override
	public void addChild(IGridViewEntity child) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}
