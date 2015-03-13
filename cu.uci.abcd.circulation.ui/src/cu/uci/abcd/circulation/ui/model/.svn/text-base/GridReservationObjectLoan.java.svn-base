package cu.uci.abcd.circulation.ui.model;

import java.util.List;

import cu.uci.abos.l10n.circulation.AbosMessages;
import cu.uci.abos.l10n.util.MessageUtil;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class GridReservationObjectLoan implements IGridViewEntity{

	private String name;
	private String user;
	private String userType;
	private String userCode;
	private String reservationDate;
	private String deliveryDate;
	private String completed;
	
	
	public GridReservationObjectLoan(String name, String user, String userType,
			String userCode, String reservationDate, String deliveryDate,
			String completed) {
    	this.name = name;
		this.user = user;
		this.userType = userType;
		this.userCode = userCode;
		this.reservationDate = reservationDate;
		this.deliveryDate = deliveryDate;
		this.completed = completed;
	}

	public GridReservationObjectLoan() {
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

	@TreeTableColumn(index=1, percentWidth = 0)
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	@TreeTableColumn( index=2, percentWidth = 0)
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@TreeTableColumn( index=3,percentWidth = 0)
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@TreeTableColumn(index=4,  percentWidth = 0)
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	@TreeTableColumn(index=5, percentWidth = 0)
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@TreeTableColumn(index=6,percentWidth = 0)
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}
