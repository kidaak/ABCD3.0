package cu.uci.abcd.management.db.ui.contributors;

import java.util.LinkedList;
import java.util.List;

import cu.uci.abos.l10n.AbosMessages;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class SFSearchEntity implements IGridViewEntity {

    private int id;
    private int tecnica;
    private String formatoExtraccion;

    public SFSearchEntity(int id, int tecnica, String formatoExtraccion, boolean acciones) {
	super();
	this.id = id;
	this.tecnica = tecnica;
	this.formatoExtraccion = formatoExtraccion;
    }

    public SFSearchEntity() {
    }

    @TreeTableColumn(/*header = "ID", */percentWidth = 10, index = 0)
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    @TreeTableColumn(/*header = "Técnica", */percentWidth = 15, index = 1)
    public int getTecnica() {
	return tecnica;
    }

    public void setTecnica(int tecnica) {
	this.tecnica = tecnica;
    }

    @TreeTableColumn(/*header = "Formato de Extracción",*/ percentWidth = 75, index = 2)
    public String getFormatoExtraccion() {
	return formatoExtraccion;
    }

    public void setFormatoExtraccion(String formatoExtraccion) {
	this.formatoExtraccion = formatoExtraccion;
    }

    @Override
    public void addChild(IGridViewEntity child) {
	// TODO Auto-generated method stub

    }

    @Override
    public List<IGridViewEntity> getChildren() {
	return new LinkedList<IGridViewEntity>();
    }

}
