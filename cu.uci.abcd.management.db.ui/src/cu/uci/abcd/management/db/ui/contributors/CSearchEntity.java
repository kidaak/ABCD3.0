package cu.uci.abcd.management.db.ui.contributors;

import java.util.LinkedList;
import java.util.List;

import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class CSearchEntity implements IGridViewEntity {

    private int idFST;
    private String nombreCampo;
    private String prefijo;
    private String ordenable;

    public CSearchEntity(int idFST, String nombreCampo, String prefijo, String ordenable) {
	super();
	this.idFST = idFST;
	this.nombreCampo = nombreCampo;
	this.prefijo = prefijo;
	this.ordenable = ordenable;
    }

    public CSearchEntity() {
    }

    @TreeTableColumn(/*header = "ID FST", */percentWidth = 10, index = 0)
    public int getIdFST() {
	return idFST;
    }

    public void setIdFST(int idFST) {
	this.idFST = idFST;
    }

    @TreeTableColumn(/*header = "Nombre del Campo",*/ percentWidth = 45, index = 1)
    public String getNombreCampo() {
	return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
	this.nombreCampo = nombreCampo;
    }

    @TreeTableColumn(/*header = "Prefijo",*/ percentWidth = 25, index = 2)
    public String getPrefijo() {
	return prefijo;
    }

    public void setPrefijo(String prefijo) {
	this.prefijo = prefijo;
    }

    @TreeTableColumn(/*header = "Ordenable",*/ percentWidth = 20, index = 3)
    public String getOrdenable() {
	return ordenable;
    }

    public void setOrdenable(String ordenable) {
	this.ordenable = ordenable;
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
