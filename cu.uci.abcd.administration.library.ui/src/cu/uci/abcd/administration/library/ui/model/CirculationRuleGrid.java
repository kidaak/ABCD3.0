package cu.uci.abcd.administration.library.ui.model;

import java.util.List;

import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class CirculationRuleGrid implements IGridViewEntity {

	private String userType;
	private String materialType;
	private int loanPermited;
	private String time;
	private int reserve;
	
	public CirculationRuleGrid(String userType, String materialType,
			int loanPermited, String time, int reserve) {
		this.userType = userType;
		this.materialType = materialType;
		this.loanPermited = loanPermited;
		this.time = time;
		this.reserve = reserve;
	}
	
	public CirculationRuleGrid() {
	}
	@TreeTableColumn(percentWidth = 20, index=0)
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@TreeTableColumn(percentWidth = 20, index=1)
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	@TreeTableColumn(percentWidth = 20, index=2)
	public int getLoanPermited() {
		return loanPermited;
	}
	public void setLoanPermited(int loanPermited) {
		this.loanPermited = loanPermited;
	}
	@TreeTableColumn(percentWidth = 20, index=3)
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@TreeTableColumn(percentWidth = 20, index=4)
	public int getReserve() {
		return reserve;
	}
	public void setReserve(int reserve) {
		this.reserve = reserve;
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
