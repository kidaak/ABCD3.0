package cu.uci.abcd.domain.management.library;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dpenaltyequation", schema = "abcd")
public class PenaltyEquation {
	@Id
	@TableGenerator(name = "PENALTY_EQUATION_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "PENALTY_EQUATION_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PENALTY_EQUATION_GEN")
	@Column(name = "penalty_equation_id")
	private Long penaltyEquationID;
	@Column(name = "delay_amount", nullable = false)
	private BigDecimal delayAmount;
	@Column(name = "lost_amount", nullable = false)
	private BigDecimal lostAmount;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	private Library owner;

	public Long getPenaltyEquationID() {
		return penaltyEquationID;
	}

	public void setPenaltyEquationID(Long penaltyEquationID) {
		this.penaltyEquationID = penaltyEquationID;
	}

	public BigDecimal getDelayAmount() {
		return delayAmount;
	}

	public void setDelayAmount(BigDecimal delayAmount) {
		this.delayAmount = delayAmount;
	}

	public BigDecimal getLostAmount() {
		return lostAmount;
	}

	public void setLostAmount(BigDecimal lostAmount) {
		this.lostAmount = lostAmount;
	}

	public Library getOwner() {
		return owner;
	}

	public void setOwner(Library owner) {
		this.owner = owner;
		if (owner.getPenaltyEquation() == null
				|| !owner.getPenaltyEquation().equals(this)) {
			owner.setPenaltyEquation(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((penaltyEquationID == null) ? 0 : penaltyEquationID
						.hashCode());
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
		PenaltyEquation other = (PenaltyEquation) obj;
		if (penaltyEquationID == null) {
			if (other.getPenaltyEquationID() != null)
				return false;
		} else if (!penaltyEquationID.equals(other.getPenaltyEquationID()))
			return false;
		if (owner == null) {
			if (other.getOwner() != null)
				return false;
		} else if (!owner.equals(other.getOwner()))
			return false;
		return true;
	}

}
