package cu.uci.abcd.circulation.ui.model;

import java.util.List;

import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class GridSanctionObjectLoan implements IGridViewEntity{

	private String name;
	private String user;
	private String userType;
	private String userCode;
	private String sanctionsType;
	private String date;
	private String durations;
	private String price;
		
	
	public GridSanctionObjectLoan(String name, String user, String userType,
			String userCode,String sanctionsType, String date, String durations, String price) {
    	this.name = name;
		this.user = user;
		this.userType = userType;
		this.userCode = userCode;
		this.sanctionsType = sanctionsType;
		this.date = date;
		this.durations = durations;
		this.price= price;
	}

	public GridSanctionObjectLoan() {
	}
	
	@Override
	public void addChild(IGridViewEntity child) {
		// TODO Auto-generated method stub
		
	}
	@TreeTableColumn(index=0, percentWidth = 0)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@TreeTableColumn( index=1,percentWidth = 0)
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	@TreeTableColumn(index=2,percentWidth = 0)
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@TreeTableColumn(index=3,percentWidth = 0)
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@TreeTableColumn(index=4,percentWidth = 0)
	public String getSanctionsType() {
		return sanctionsType;
	}
	public void setSanctionsType(String sanctionsType) {
		this.sanctionsType = sanctionsType;
	}

	@TreeTableColumn(index=5,percentWidth = 0)
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@TreeTableColumn(index=6,percentWidth = 0)
	public String getDurations() {
		return durations;
	}
	public void setDurations(String durations) {
		this.durations = durations;
	}

	@TreeTableColumn(index=7,percentWidth = 0)
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}
