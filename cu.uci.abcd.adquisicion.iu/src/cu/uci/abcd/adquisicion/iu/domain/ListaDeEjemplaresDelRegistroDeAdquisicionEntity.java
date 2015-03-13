package cu.uci.abcd.adquisicion.iu.domain;

import java.util.List;

import cu.uci.abos.widgets.grid.*;


public class ListaDeEjemplaresDelRegistroDeAdquisicionEntity implements IGridViewEntity {
  // estanteria = shelf
	private long tag;
	private String barCode ;
	private String shelf;
	private String materialState;
	private String useRestrictions; 
	
	
	public ListaDeEjemplaresDelRegistroDeAdquisicionEntity(long tag,String barCode,String shelf,String materialState,String useRestrictions){
		this.tag = tag;
		this.barCode = barCode; 
		this.shelf = shelf;
		this.materialState = materialState;
		this.useRestrictions = useRestrictions;
	}
	
	@TreeTableColumn(percentWidth= 5, index=0)
	public long getTag() {
		return tag;
	}


	public void setTag(long tag) {
		this.tag = tag;
	}

	@TreeTableColumn(percentWidth = 20, index=1)
	public String getBarCode() {
		return barCode;
	}


	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@TreeTableColumn(percentWidth = 25, index=2)
	public String getShelf() {
		return shelf;
	}


	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	@TreeTableColumn(percentWidth = 25, index=3)
	public String getMaterialState() {
		return materialState;
	}


	public void setMaterialState(String materialState) {
		this.materialState = materialState;
	}

	@TreeTableColumn(percentWidth = 25, index=4)
	public String getUseRestrictions() {
		return useRestrictions;
	}


	public void setUseRestrictions(String useRestrictions) {
		this.useRestrictions = useRestrictions;
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
