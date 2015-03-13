package cu.uci.abcd.circulation.ui.model;

import java.util.List;


import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class ObjectLoanView  implements IGridViewEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String objectType;
	private String quantity;
	private String controlNumber;
	private String editionNumber;
	private String loanState;
	private Integer idLoanObject;
	
	
	
	public ObjectLoanView(String title, String author,String objectType,
			String quantity, String controlNumber, String editionNumber,
			String loanState, Integer idLoanObject) {
		this.title = title;
		this.objectType = objectType;
		this.author = author;
		this.quantity = quantity;
		this.controlNumber = controlNumber;
		this.editionNumber = editionNumber;
		this.loanState = loanState;
		this.idLoanObject=idLoanObject;
	}
	
	public Integer getIdLoanObject() {
		return idLoanObject;
	}

	public void setIdLoanObject(Integer idLoanObject) {
		this.idLoanObject = idLoanObject;
	}

	public ObjectLoanView() {
	}
	
	@TreeTableColumn(index=0, percentWidth = 50)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@TreeTableColumn( index=1, percentWidth = 50)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	@TreeTableColumn(index=2, percentWidth = 50)
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	
	@TreeTableColumn(index=3, percentWidth = 50)
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@TreeTableColumn(  index=4,percentWidth = 50)
	public String getControlNumber() {
		return controlNumber;
	}
	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	@TreeTableColumn(index=5, percentWidth = 50)
	public String getEditionNumber() {
		return editionNumber;
	}
	public void setEditionNumber(String editionNumber) {
		this.editionNumber = editionNumber;
	}

	@TreeTableColumn( index=6, percentWidth = 50)
	public String getLoanState() {
		return loanState;
	}
	public void setLoanState(String loanState) {
		this.loanState = loanState;
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
