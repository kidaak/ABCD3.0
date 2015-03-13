package cu.uci.abcd.domain.circulation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.common.LoanObject;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dtransaction", schema = "abcd")
public class Transaction {
	@Id
	@TableGenerator(name = "TRANSACTION_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "TRANSACTION_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TRANSACTION_GEN")
	@Column(name = "transaction_id")
	private Long transactionID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_object_id", nullable = false)
	private LoanObject loanObject;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_user_id", nullable = false)
	private LoanUser loanUser;
	@ElementCollection
	@CollectionTable(name = "dtransactionhistory", schema = "abcd", joinColumns = @JoinColumn(referencedColumnName = "transaction_id"))
	private List<TransactionHistory> transactionHistories;

	public Transaction() {
		super();
		transactionHistories = new ArrayList<>();
	}

	public Long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}

	public LoanObject getLoanObject() {
		return loanObject;
	}

	public void setLoanObject(LoanObject loanObject) {
		this.loanObject = loanObject;
		if (!loanObject.getTransactions().contains(this)) {
			loanObject.getTransactions().add(this);
		}
	}

	public LoanUser getLoanUser() {
		return loanUser;
	}

	public void setLoanUser(LoanUser loanUser) {
		this.loanUser = loanUser;
		if (!loanUser.getTransactions().contains(this)) {
			loanUser.getTransactions().add(this);
		}
	}

	public List<TransactionHistory> getTransactionHistories() {
		return transactionHistories;
	}

	public void setTransactionHistories(
			List<TransactionHistory> transactionHistories) {
		this.transactionHistories = transactionHistories;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
