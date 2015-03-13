package cu.uci.abcd.domain.circulation;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.common.LoanObject;
import cu.uci.abcd.domain.management.library.Coin;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dpenalty", schema = "abcd")
public class Penalty {
	@Id
	@TableGenerator(name = "PENALTY_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "PENALTY_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PENALTY_GEN")
	@Column(name = "penalty_id")
	private Long penaltyID;
	@Column(name = "effective_date")
	private Date effectiveDate;
	@Column(name = "expiration_date")
	private Date expirationDate;
	@Column(name = "reason")
	private String reason;
	@Enumerated(EnumType.STRING)
	@Column(name = "penalty_type")
	private PenaltyType penaltyType;
	@Enumerated(EnumType.STRING)
	@Column(name = "penalty_state")
	private PenaltyState penaltyState;
	@Column(name = "amount")
	private BigDecimal amount;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coin_id")
	private Coin coin;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_object_id")
	private LoanObject loanObject;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_user_id", nullable = false)
	private LoanUser loanUser;

	public Long getPenaltyID() {
		return penaltyID;
	}

	public void setPenaltyID(Long penaltyID) {
		this.penaltyID = penaltyID;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public PenaltyType getPenaltyType() {
		return penaltyType;
	}

	public void setPenaltyType(PenaltyType penaltyType) {
		this.penaltyType = penaltyType;
	}

	public PenaltyState getPenaltyState() {
		return penaltyState;
	}

	public void setPenaltyState(PenaltyState penaltyState) {
		this.penaltyState = penaltyState;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Coin getCoin() {
		return coin;
	}

	public void setCoin(Coin coin) {
		this.coin = coin;
	}

	public LoanObject getLoanObject() {
		return loanObject;
	}

	public void setLoanObject(LoanObject loanObject) {
		this.loanObject = loanObject;
		if (!loanObject.getPenalties().contains(this)) {
			loanObject.getPenalties().add(this);
		}
	}

	public LoanUser getLoanUser() {
		return loanUser;
	}

	public void setLoanUser(LoanUser loanUser) {
		this.loanUser = loanUser;
		if (!loanUser.getPenalties().contains(this)) {
			loanUser.getPenalties().add(this);
		}
	}

	@Override
	public int hashCode() {
		return penaltyID.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Penalty) {
			return ((Penalty) obj).getPenaltyID() == penaltyID;
		}
		return super.equals(obj);
	}

}
