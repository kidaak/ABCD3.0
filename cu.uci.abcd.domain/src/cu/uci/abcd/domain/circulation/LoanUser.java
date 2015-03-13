package cu.uci.abcd.domain.circulation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.common.EntityState;
import cu.uci.abcd.domain.common.TangibleActor;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dloanuser", schema = "abcd")
public class LoanUser {
	@Id
	@TableGenerator(name = "LOAN_USER_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "LOAN_USER_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "LOAN_USER_GEN")
	@Column(name = "loan_user_id")
	private Long loanUserID;
	@Column(name = "loan_user")
	private String loanUser;
	@Column(name = "observation")
	private String observation;
	@Column(name = "inactive_state_observation")
	private String inactiveStateObservation;
	@Column(name = "registration_date")
	private Date registrationDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_user_type_id")
	private LoanUserType loanUserType;
	@Column(name = "loan_user_code")
	private String loanUserCode;
	@Enumerated(EnumType.STRING)
	@Column(name = "loan_user_state")
	private EntityState loanUserState;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	private TangibleActor owner;
	@OneToMany(mappedBy = "loanUser")
	private List<Reservation> reservationList;
	@OneToMany(mappedBy = "loanUser")
	private List<Transaction> transactions;
	@OneToMany(mappedBy = "loanUser")
	private List<Penalty> penalties;

	public LoanUser() {
		super();
		reservationList = new ArrayList<>();
		transactions = new ArrayList<>();
		penalties = new ArrayList<>();
	}

	public Long getLoanUserID() {
		return loanUserID;
	}

	public void setLoanUserID(Long loanUserID) {
		this.loanUserID = loanUserID;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public LoanUserType getLoanUserType() {
		return loanUserType;
	}

	public void setLoanUserType(LoanUserType loanUserType) {
		this.loanUserType = loanUserType;
		if (!loanUserType.getLoanUserList().contains(this)) {
			loanUserType.getLoanUserList().add(this);
		}
	}

	public String getLoanUserCode() {
		return loanUserCode;
	}

	public void setLoanUserCode(String loanUserCode) {
		this.loanUserCode = loanUserCode;
	}

	public EntityState getLoanUserState() {
		return loanUserState;
	}

	public void setLoanUserState(EntityState loanUserState) {
		this.loanUserState = loanUserState;
	}

	public TangibleActor getOwner() {
		return owner;
	}

	public void setOwner(TangibleActor owner) {
		this.owner = owner;
	}

	public String getLoanUser() {
		return loanUser;
	}

	public void setLoanUser(String loanUser) {
		this.loanUser = loanUser;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getInactiveStateObservation() {
		return inactiveStateObservation;
	}

	public void setInactiveStateObservation(String inactiveStateObservation) {
		this.inactiveStateObservation = inactiveStateObservation;
	}

	@PrePersist
	public void generateCreationDate() {
		this.registrationDate = DomainUtil.CURRENT_DATE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((loanUserCode == null) ? 0 : loanUserCode.hashCode());
		result = prime * result
				+ ((loanUserID == null) ? 0 : loanUserID.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanUser other = (LoanUser) obj;
		if (loanUserCode == null) {
			if (other.loanUserCode != null)
				return false;
		} else if (!loanUserCode.equals(other.loanUserCode))
			return false;
		if (loanUserID == null) {
			if (other.loanUserID != null)
				return false;
		} else if (!loanUserID.equals(other.loanUserID))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	public Reservation addReservation(Reservation reservation) {
		reservationList.add(reservation);
		if (!reservation.getLoanUser().equals(this)) {
			reservation.setLoanUser(this);
		}
		return reservation;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<Penalty> getPenalties() {
		return penalties;
	}

	public void setPenalties(List<Penalty> penalties) {
		this.penalties = penalties;
	}

}
