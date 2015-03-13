package cu.uci.abcd.circulation.ui.model;

import java.util.List;

import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abcd.domain.common.EntityState;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.circulation.LoanUserType;
import cu.uci.abos.widgets.grid.IGridViewEntity;
import cu.uci.abos.widgets.grid.TreeTableColumn;


public class EntityLoanUser extends LoanUser implements IGridViewEntity{

	private static final long serialVersionUID = 1L;

	String tipo = "";
	
	public EntityLoanUser(String user,
			String excuse, LoanUserType loanUserType, String loanUserCode, EntityState loanUserState, Person actor) {

    	   super();
    	this.setLoanUser(user);
   		this.setObservation(excuse);
   		this.setLoanUserType(loanUserType);
   		this.setLoanUserCode(loanUserCode);
   		this.setLoanUserState(loanUserState);
   		this.setOwner(actor);
   		
	}

	public EntityLoanUser(LoanUserType loanUserType) {
		super();
		this.setLoanUserType(loanUserType);
	}
	
	public EntityLoanUser(String user,
			String excuse, LoanUserType loanUserType,String loanUserCode ,String inactiveStateObservation) {

    	   super();
    	this.setLoanUser(user);
   		this.setObservation(excuse);
   		this.setLoanUserType(loanUserType);
   		this.setLoanUserCode(loanUserCode);
   		this.setInactiveStateObservation(inactiveStateObservation);
   		
	}	
	
	
	@TreeTableColumn(index=0,percentWidth = 20)
	public String getLoanUser() {
		return super.getLoanUser();
	}
	
	@TreeTableColumn(index=1, percentWidth = 20)
	public String getObservation() {
	return super.getObservation();
	}

	
	public LoanUserType getLoanUserType() {
		tipo = super.getLoanUserType().getNomenclatorDescription();
	return super.getLoanUserType();
	}
	
	@TreeTableColumn(index=2, percentWidth = 20)
	public String getTipo() {
		tipo = super.getLoanUserType().getNomeclatorName();
	return tipo;
	}
	
	@TreeTableColumn(index=3, percentWidth = 20)
	public String getloanUserCode() {
	return super.getLoanUserCode();
	}
	
	@TreeTableColumn(index=4, percentWidth = 20)
	public EntityState getLoanUserState() {
	return super.getLoanUserState();
	}

		
	@Override
	public void addChild(IGridViewEntity child) {
		
	}

	@Override
	public List<IGridViewEntity> getChildren() {
		return null;
	}

}
