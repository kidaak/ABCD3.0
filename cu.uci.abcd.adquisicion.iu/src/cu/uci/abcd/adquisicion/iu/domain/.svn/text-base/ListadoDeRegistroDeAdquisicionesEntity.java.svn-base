package cu.uci.abcd.adquisicion.iu.domain;

import java.util.List;

import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class ListadoDeRegistroDeAdquisicionesEntity implements IGridViewEntity {
	private long mfn ;
	private String resumen ;
	private String tipoDeAdquisicion;
	private String data;
	private String estadoDelRegistro;
	
	
	public ListadoDeRegistroDeAdquisicionesEntity(long mfn, String resumen,
			String tipoDeAdquisicion, String data, String estadoDelRegistro) {
		super();
		this.mfn = mfn;
		this.resumen = resumen;
		this.tipoDeAdquisicion = tipoDeAdquisicion;
		this.data = data;
		this.estadoDelRegistro = estadoDelRegistro;
	}
	
	

	public long getMfn() {
		return mfn;
	}



	public void setMfn(long mfn) {
		this.mfn = mfn;
	}


	@TreeTableColumn(percentWidth= 40, index=0)
	public String getResumen() {
		return resumen;
	}



	public void setResumen(String resumen) {
		this.resumen = resumen;
	}


	@TreeTableColumn(percentWidth= 20, index=1)
	public String getTipoDeAdquisicion() {
		return tipoDeAdquisicion;
	}



	public void setTipoDeAdquisicion(String tipoDeAdquisicion) {
		this.tipoDeAdquisicion = tipoDeAdquisicion;
	}


	@TreeTableColumn(percentWidth= 20, index=2)
	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}


	@TreeTableColumn(percentWidth= 20, index=3)
	public String getEstadoDelRegistro() {
		return estadoDelRegistro;
	}



	public void setEstadoDelRegistro(String estadoDelRegistro) {
		this.estadoDelRegistro = estadoDelRegistro;
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
