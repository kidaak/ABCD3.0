package cu.uci.abcd.circulation.ui.model;

import java.util.List;

import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class GridTransactionsObjectLoan implements IGridViewEntity{

	private String name;
	private String user;
	private String userType;
	private String userCode;
	private String loanType;
	private String record;
	private String devolution;
	private String state;
	
	public GridTransactionsObjectLoan(String name, String user,
			String userType, String userCode, String loanType, String record,
			String devolution, String state) {
		this.name = name;
		this.user = user;
		this.userType = userType;
		this.userCode = userCode;
		this.loanType = loanType;
		this.record = record;
		this.devolution = devolution;
		this.state = state;
	}

	public GridTransactionsObjectLoan() {
	}
	
	@Override
	public void addChild(IGridViewEntity child) {
	
	}
	@TreeTableColumn(index=0,percentWidth = 50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@TreeTableColumn(index=1,percentWidth = 50)
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	@TreeTableColumn(index=2, percentWidth = 50)
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@TreeTableColumn(index=3,percentWidth = 50)
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@TreeTableColumn( index=4,percentWidth = 50)
	public String getReservationDate() {
		return loanType;
	}
	public void setReservationDate(String reservationDate) {
		this.loanType = reservationDate;
	}

	@TreeTableColumn(index=5,percentWidth = 50)
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}

	@TreeTableColumn(index=6,percentWidth = 50)
	public String getDevolution() {
		return devolution;
	}
	public void setDevolution(String devolution) {
		this.devolution = devolution;
	}
	
	@TreeTableColumn(index=7, percentWidth = 50)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		return null;
	}
}
