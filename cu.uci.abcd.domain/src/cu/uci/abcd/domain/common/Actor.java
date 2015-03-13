package cu.uci.abcd.domain.common;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dactor", schema = "abcd")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "actor_discriminator")
public abstract class Actor {
	@Id
	@TableGenerator(name = "ACTOR_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "ACTOR_SEQ", schema="abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ACTOR_GEN")
	@Column(name = "actor_id")
	protected Long actorID;
	@Column(name = "effective_date")
	protected Date effectiveDate;
	@Column(name = "expiration_date")
	protected Date expirationDate;
	@OneToMany(mappedBy = "owner", cascade=CascadeType.ALL)
	protected List<Address> addressList;

	public Actor() {
		super();
		addressList = new ArrayList<>();
	}

	public Long getActorID() {
		return actorID;
	}

	public void setActorID(Long actorID) {
		this.actorID = actorID;
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

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorID == null) ? 0 : actorID.hashCode());
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
		Actor other = (Actor) obj;
		if (actorID == null) {
			if (other.getActorID() != null)
				return false;
		} else if (!actorID.equals(other.getActorID()))
			return false;
		return true;
	}

	public Address addAddress(Address address) {
		this.addressList.add(address);
		if (address.getOwner() != this) {
			address.setOwner(this);
		}
		return address;
	}
}
