/*package cu.uci.abcd.management.db.ui.contributors;

import java.util.LinkedList;
import java.util.List;

import org.unesco.jisis.corelib.common.IWorksheetDef;

import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class DEWViewEntity implements IWorksheetDef, IGridViewEntity {

    private static final long serialVersionUID = 1L;

    private DEWViewEntity parent;
    private List<IGridViewEntity> children;
    //private FDTViewEntity fdtViewEntity;
    private String description;
    private String displayControl;
    private String defaultValue;
    private String helpMessage;
    private String validationFormat;
    private String pickList;
    private String subfieldCode;
/*
    public DEWViewEntity(DEWViewEntity parent, FDTViewEntity fdtViewEntity, String subfieldCode, String description, String displayControl, String defaultValue, String helpMsg, String valFormat,
	    String pickList) {
	initialize(parent, fdtViewEntity, subfieldCode, description, displayControl, defaultValue, helpMsg, valFormat, pickList);
	parent.addChild(this);
    }

    public DEWViewEntity(FDTViewEntity fdtViewEntity, String subfieldCode, String description, String displayControl, String defaultValue, String helpMsg, String valFormat, String pickList) {
	initialize(null, fdtViewEntity, subfieldCode, description, displayControl, defaultValue, helpMsg, valFormat, pickList);
    }

    private void setParent(DEWViewEntity parent) {
	this.parent = parent;
    }

    public DEWViewEntity getParent() {
	return this.parent;
    }

    @Override
    public void addChild(IGridViewEntity dewViewEntity) {
	((DEWViewEntity) dewViewEntity).setParent(this);
	if (!this.children.contains(dewViewEntity)) {
	    this.children.add(dewViewEntity);
	}
    }

    @Override
    public List<IGridViewEntity> getChildren() {
	return this.children;
    }

    private void initialize(DEWViewEntity parent, FDTViewEntity fdtViewEntity, String subfieldCode, String description, String displayControl, String defaultValue, String helpMsg, String valFormat,
	    String pickList) {
	this.parent = parent;
	this.children = new LinkedList<IGridViewEntity>();
	this.fdtViewEntity = fdtViewEntity;
	this.subfieldCode = subfieldCode;
	this.description = description;
	this.displayControl = displayControl;
	this.defaultValue = defaultValue;
	this.helpMessage = helpMsg;
	this.validationFormat = valFormat;
	this.pickList = pickList;
    }

    @TreeTableColumn(index = 0, percentWidth = 0)
    public String getNodeName() {
	if (this.isSubfield())
	    return this.subfieldCode;
	else
	    return "tag " + this.fdtViewEntity.getTag();
    }

    public boolean isSubfield() {
	return this.subfieldCode != "" && this.subfieldCode != null;
    }

    @TreeTableColumn(header = "Ind", width = 50, index = 1)
    public boolean hasIndicators() {
	return this.fdtViewEntity.hasIndicators();
    }

    @TreeTableColumn(header = "Rep", width = 50, index = 2)
    public boolean isRepeatable() {
	return this.fdtViewEntity.isRepeatable();
    }

    @TreeTableColumn(header = "1er subcampo", width = 100, index = 3)
    public boolean hasFirstSubfield() {
	return this.fdtViewEntity.hasFirstSubfield();
    }

    @TreeTableColumn(header = "Tipo", width = 100, index = 4)
    public int getType() {
	return this.fdtViewEntity.getType();
    }

    @TreeTableColumn(header = "Mostrar", width = 200, index = 5)
    @Override
    public String getDescription() {
	return this.description;
    }

    @TreeTableColumn(header = "Por defecto", width = 100, index = 6)
    @Override
    public String getDefaultValue() {
	return this.defaultValue;
    }

    @TreeTableColumn(header = "Control", width = 100, index = 7)
    @Override
    public String getDisplayControl() {
	return this.displayControl;
    }

    @TreeTableColumn(header = "Mensaje ayuda", width = 150, index = 8)
    @Override
    public String getHelpMessage() {
	return this.helpMessage;
    }

    @TreeTableColumn(header = "Lista Escojer", width = 150, index = 9)
    @Override
    public String getPickList() {
	return this.pickList;
    }

    @TreeTableColumn(header = "Formato", width = 150, index = 10)
    @Override
    public String getValidationFormat() {
	return this.validationFormat;
    }

    @Override
    public void setValidationFormat(String format) {
	this.validationFormat = format;
    }

    @Override
    public void setDefaultValue(String value) {
	this.defaultValue = value;
    }

    @Override
    public void setHelpMessage(String message) {
	this.helpMessage = message;
    }

    @Override
    public void setPickList(String pickList) {
	this.pickList = pickList;
    }

    @Override
    public int getTag() {
	return this.fdtViewEntity.getTag();
    }

    @Override
    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public void setTag(int tag) {
	this.fdtViewEntity.setTag(tag);
    }

    @Override
    public String getSubfieldCode() {
	return this.subfieldCode;
    }

    @Override
    public void setSubfieldCode(String code) {
	this.subfieldCode = code;
    }

    @Override
    public void setDisplayControl(String control) {
	this.displayControl = control;
    }
    
    

	@Override
	public void addChild(IGridViewEntity arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayControl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHelpMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPickList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSubfieldCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getValidationFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDefaultValue(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescription(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayControl(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHelpMessage(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPickList(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSubfieldCode(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTag(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValidationFormat(String arg0) {
		// TODO Auto-generated method stub
		
	}
}
*/