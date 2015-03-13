package cu.uci.abcd.domain.common;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "daddress", schema = "abcd")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "address_discriminator")
public abstract class Address {
	@Id
	@TableGenerator(name = "ADDRESS_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "ADDRESS_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ADDRESS_GEN")
	@Column(name = "address_id")
	protected Long addressID;
	@Column(name = "creation_date")
	protected Date creationDate;
	@Column(name = "comment")
	protected String comment;
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	protected Actor owner;

	public Address() {
		super();
	}

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Actor getOwner() {
		return owner;
	}

	public void setOwner(Actor owner) {
		this.owner = owner;
		if (!owner.getAddressList().contains(this)) {
			owner.getAddressList().add(this);
		}
	}

	@Override
	public int hashCode() {
		return this.addressID.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Address) {
			return ((Address) obj).getAddressID() == this.addressID;
		}
		return false;
	}
}
