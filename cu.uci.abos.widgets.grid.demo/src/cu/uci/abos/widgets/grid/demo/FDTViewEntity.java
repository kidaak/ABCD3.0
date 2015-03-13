package cu.uci.abos.widgets.grid.demo;

import java.util.List;

import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class FDTViewEntity implements IGridViewEntity {
	
	private int tag;
	private String name;
	private int type;
	private boolean indicators;
	private boolean rep;
	private boolean firstSubfield;
	private String subfieldPatterns;
	
	public FDTViewEntity(int tag, String name, int type, boolean indicators, boolean rep, boolean firstSubfield, String subfieldPatterns) {
		this.tag = tag;
		this.name = name;
		this.type = type;
		this.indicators = indicators;
		this.rep = rep;
		this.firstSubfield = firstSubfield;
		this.subfieldPatterns = subfieldPatterns;
	}
	
	public FDTViewEntity() {
	}

	@TreeTableColumn(percentWidth=10, index=0)
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	@TreeTableColumn(percentWidth = 50, index=1)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@TreeTableColumn(percentWidth = 10, index=2)
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	//@TreeTableColumn(header="Indicadores", width=95, index=3)
	public boolean isIndicators() {
		return indicators;
	}
	public void setIndicators(boolean indicators) {
		this.indicators = indicators;
	}
	//@TreeTableColumn(header="Rep", width=95, index=4)
	public boolean isRep() {
		return rep;
	}
	public void setRep(boolean rep) {
		this.rep = rep;
	}
	//@TreeTableColumn(header="1st subcampo", width=95, index=5)
	public boolean isFirstSubfield() {
		return firstSubfield;
	}
	public void setFirstSubfield(boolean firstSubfield) {
		this.firstSubfield = firstSubfield;
	}
	@TreeTableColumn(percentWidth=30, index=6)
	public String getSubfieldPatterns() {
		return subfieldPatterns;
	}
	public void setSubfieldPatterns(String subfieldPatterns) {
		this.subfieldPatterns = subfieldPatterns;
	}

	@Override
	public void addChild(IGridViewEntity child) {
		// do nothing		
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		// do nothing
		return null;
	}
	
	
}
