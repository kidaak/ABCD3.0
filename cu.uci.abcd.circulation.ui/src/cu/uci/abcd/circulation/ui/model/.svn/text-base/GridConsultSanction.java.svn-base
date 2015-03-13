package cu.uci.abcd.circulation.ui.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abcd.domain.circulation.Penalty;
import cu.uci.abcd.domain.circulation.PenaltyState;
import cu.uci.abcd.domain.circulation.PenaltyType;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;

public class GridConsultSanction extends Penalty implements IGridViewEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
	public GridConsultSanction(PenaltyType sanctionsType, Date dateUP,Date dateFrom, String motivo, PenaltyState state, LoanUser loanUser) {
		this.setPenaltyType(sanctionsType);
		this.setEffectiveDate(dateUP);
		this.setExpirationDate(dateFrom);
		this.setReason(motivo);
		this.setPenaltyState(state);
		this.setLoanUser(loanUser);
	
	}
	
	public GridConsultSanction(PenaltyType sanctionsType, Date dateUP,Date dateFrom, String motivo, PenaltyState state, BigDecimal amount) {
		this.setPenaltyType(sanctionsType);
		this.setEffectiveDate(dateUP);
		this.setExpirationDate(dateFrom);
		this.setReason(motivo);
		this.setPenaltyState(state);
		this.setAmount(amount);
	
	}

	@TreeTableColumn(index=0,percentWidth = 20)
	public PenaltyType getPenaltyType() {
		return super.getPenaltyType();
	}
	
	@TreeTableColumn(index=1, percentWidth = 20)
	public Date getEffectiveDate() {
	return super.getEffectiveDate();
	}

	@TreeTableColumn(index=2,percentWidth = 20)
	public Date getExpirationDate() {
		return super.getExpirationDate();
	}
	
	@TreeTableColumn(index=3, percentWidth = 20)
	public String getReason() {
		return super.getReason();
	}
	
	@TreeTableColumn(index=4,percentWidth = 20)
	public PenaltyState getPenaltyState() {
		return super.getPenaltyState();
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
