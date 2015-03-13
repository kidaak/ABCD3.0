package cu.uci.abcd.adquisicion.iu.domain;

import java.util.List;

import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class ListadoDePedidosPendientesEntity implements IGridViewEntity {
	
	private int tag;
	private String titulo;
	private String autor;
	private String editor;
	
	
	public ListadoDePedidosPendientesEntity(int tag, String titulo, String autor, String editor) {
		this.tag = tag;
		this.titulo = titulo;
		this.autor = autor;
		this.editor = editor;
		
	}
	
	public ListadoDePedidosPendientesEntity() {
	}

	@TreeTableColumn(percentWidth=10, index=0)
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	@TreeTableColumn(percentWidth = 50, index=1)
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@TreeTableColumn(percentWidth = 10, index=2)
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	//@TreeTableColumn(header="Indicadores", width=95, index=3)
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	

	@Override
	public void addChild(IGridViewEntity child) {
		// do nothing		
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		// do nothing
		return null;
	}}
	
	

 


	 
