package cu.uci.abcd.management.db.ui.contributors;

import java.util.LinkedList;
import java.util.List;

import org.unesco.jisis.corelib.common.FieldDefinitionTable.FieldDefinition;

import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class FDTViewEntity extends FieldDefinition implements IGridViewEntity {

	private FDType fdType;
	
    public FDTViewEntity(int tag, String name, FDType type, boolean indicators, boolean repeatable, boolean firstSubfield, String subfields) {
    	super(tag, name, Integer.parseInt(type.getId().toString()), indicators, repeatable, firstSubfield, subfields);
    	this.fdType = type;
    }

    @TreeTableColumn(percentWidth = 10, index = 0)
    @Override
    public int getTag() {
    	return super.getTag();
    };

    @TreeTableColumn(percentWidth = 34, index = 1)
    @Override
    public String getName() {
    	return super.getName();
    }
    
    @Override
    public int getType() {
    	return super.getType();
    }
    
    @TreeTableColumn(percentWidth = 16, index = 2)
    public String getTypeName() {
    	return this.fdType.name();
    }
    
    public FDType getFDType() {
    	return this.fdType;
    }

    @TreeTableColumn(percentWidth = 10, index = 3)
    @Override
    public boolean hasIndicators() {
    	return super.hasIndicators();
    }

    @TreeTableColumn(percentWidth = 10, index = 4)
    @Override
    public boolean isRepeatable() {
    	return super.isRepeatable();
    }

    @TreeTableColumn(percentWidth = 10, index = 5)
    @Override
    public boolean hasFirstSubfield() {
    	return super.hasFirstSubfield();
    };

    @TreeTableColumn(percentWidth = 10, index = 6)
    @Override
    public String getSubfields() {
    	return super.getSubfields();
    }

    @Override
    public void setType(int type) {
    	super.setType(type);
    }
    
    public void setType(FDType type) {
    	super.setType(Integer.parseInt(type.getId().toString()));
    	this.fdType = type;
    }

    @Override
    public void setIndicators(boolean hasIndicators) {
    	super.setIndicators(hasIndicators);
    }

    @Override
    public void setSubfields(String subfields) {
    	super.setSubfields(subfields);
    }

    public void setName(String name) {
    	this.name_ = name;
    }

    public void setRepeatable(boolean repeateable) {
    	this.repeatable_ = repeateable;
    }

    public void setTag(int tag) {
    	this.tag_ = tag;
    }

    public void setHasFirstSubfield(boolean hasFirstSubfield) {
    	this.firstSubfield_ = hasFirstSubfield;
    }

    @Override
    public void addChild(IGridViewEntity child) {
    	// do nothing.
    }

    @Override
    public List<IGridViewEntity> getChildren() {
    	return new LinkedList<IGridViewEntity>();
    }	
}
