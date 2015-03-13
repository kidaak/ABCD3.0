package cu.uci.abcd.domain.circulation;

import java.sql.Timestamp;

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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.common.LoanObject;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dreservation", schema = "abcd")
public class Reservation {
	@Id
	@TableGenerator(name = "RESERVATION_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "RESERVATION_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "RESERVATION_GEN")
	@Column(name = "reservation_id")
	private Long reservationID;
	@Column(name = "reservation_timestamp")
	private Timestamp reservationTimestamp;
	@Column(name = "effective_reservationtime_timestamp")
	private Timestamp effectiveReservationtimeTimestamp;
	@Column(name = "expiration_reservation_timestamp")
	private Timestamp expirationReservationTimestamp;
	@Enumerated(EnumType.STRING)
	@Column(name = "reservation_state")
	private ReservationState reservationState;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_object_id")
	private LoanObject loanObject;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_user_id")
	private LoanUser loanUser;

	public Long getReservationID() {
		return reservationID;
	}

	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
	}

	public Timestamp getReservationTimestamp() {
		return reservationTimestamp;
	}

	public void setReservationTimestamp(Timestamp reservationTimestamp) {
		this.reservationTimestamp = reservationTimestamp;
	}

	public Timestamp getEffectiveReservationtimeTimestamp() {
		return effectiveReservationtimeTimestamp;
	}

	public void setEffectiveReservationtimeTimestamp(
			Timestamp effectiveReservationtimeTimestamp) {
		this.effectiveReservationtimeTimestamp = effectiveReservationtimeTimestamp;
	}

	public Timestamp getExpirationReservationTimestamp() {
		return expirationReservationTimestamp;
	}

	public void setExpirationReservationTimestamp(
			Timestamp expirationReservationTimestamp) {
		this.expirationReservationTimestamp = expirationReservationTimestamp;
	}

	public ReservationState getReservationState() {
		return reservationState;
	}

	public void setReservationState(ReservationState reservationState) {
		this.reservationState = reservationState;
	}

	public LoanObject getLoanObject() {
		return loanObject;
	}

	public void setLoanObject(LoanObject loanObject) {
		this.loanObject = loanObject;
		if (!loanObject.getReservationList().contains(this)) {
			loanObject.getReservationList().add(this);
		}
	}

	public LoanUser getLoanUser() {
		return loanUser;
	}

	public void setLoanUser(LoanUser loanUser) {
		this.loanUser = loanUser;
		if (!loanUser.getReservationList().contains(this)) {
			loanUser.getReservationList().add(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((loanObject == null) ? 0 : loanObject.hashCode());
		result = prime * result
				+ ((loanUser == null) ? 0 : loanUser.hashCode());
		result = prime * result
				+ ((reservationID == null) ? 0 : reservationID.hashCode());
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
		Reservation other = (Reservation) obj;
		if (loanObject == null) {
			if (other.loanObject != null)
				return false;
		} else if (!loanObject.equals(other.loanObject))
			return false;
		if (loanUser == null) {
			if (other.loanUser != null)
				return false;
		} else if (!loanUser.equals(other.loanUser))
			return false;
		if (reservationID == null) {
			if (other.reservationID != null)
				return false;
		} else if (!reservationID.equals(other.reservationID))
			return false;
		return true;
	}

	@PrePersist
	public void generateDefaultValues() {
		this.reservationTimestamp = DomainUtil.CURRENT_TIMESTAMP;
		this.reservationState = ReservationState.PENDING;
	}
}
