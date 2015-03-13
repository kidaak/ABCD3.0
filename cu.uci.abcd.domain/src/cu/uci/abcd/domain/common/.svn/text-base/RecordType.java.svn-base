package cu.uci.abcd.domain.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "RECORDTYPE")
public class RecordType extends Nomenclator {
	@OneToMany(mappedBy = "recordType")
	private List<LoanObject> loanObjectList;

	public RecordType() {
		super();
		loanObjectList = new ArrayList<>();
	}

	public List<LoanObject> getLoanObjectList() {
		return loanObjectList;
	}

	public void setLoanObjectList(List<LoanObject> loanObjectList) {
		this.loanObjectList = loanObjectList;
	}

}
