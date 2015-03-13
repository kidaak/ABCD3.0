package cu.uci.abcd.domain.management.library;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import cu.uci.abcd.domain.common.Nomenclator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "COIN")
@PrimaryKeyJoinColumn(name = "coin_id")
@Table(name = "dcoin", schema = "abcd")
public class Coin extends Nomenclator {
	@Column(name = "exchange_rate", nullable = false)
	private BigDecimal exchangeRate;
	@Column(name = "update_date")
	private Date updatedDate;

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
