package cu.uci.abcd.domain.circulation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import cu.uci.abcd.domain.common.Nomenclator;

@Entity
@DiscriminatorValue(value = "LOANUSERTYPE")
public class LoanUserType extends Nomenclator {
	@OneToMany(mappedBy = "loanUserType")
	private List<LoanUser> loanUserList;

	public LoanUserType() {
		super();
		loanUserList = new ArrayList<>();
	}

	public List<LoanUser> getLoanUserList() {
		return loanUserList;
	}

	public void setLoanUserList(List<LoanUser> loanUserList) {
		this.loanUserList = loanUserList;
	}

	@Override
	public int hashCode() {
		return this.nomenclatorID.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public LoanUser addLoanUser(LoanUser loanUser) {
		loanUserList.add(loanUser);
		if (loanUser.getLoanUserType() != this) {
			loanUser.setLoanUserType(this);
		}
		return loanUser;
	}
}
