package cu.uci.abcd.domain.common;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Inheritance
@DiscriminatorColumn(name = "nomenclator_code")
@Table(name = "dnomenclator", schema = "abcd")
public abstract class Nomenclator {
	@Id
	@TableGenerator(name = "NOMENCLATOR_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "NOMENCLATOR_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "NOMENCLATOR_GEN")
	@Column(name = "nomenclator_id")
	protected Long nomenclatorID;
	@Column(name = "nomenclator_name")
	protected String nomeclatorName;
	@Column(name = "nomenclator_code")
	protected String nomenclatorCode;
	@Column(name = "nomenclator_description")
	protected String nomenclatorDescription;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_library_id", nullable = false)
	protected Library ownerLibrary;

	public Nomenclator() {
		super();
	}

	public String getNomeclatorName() {
		return nomeclatorName;
	}

	public void setNomeclatorName(String nomeclatorName) {
		this.nomeclatorName = nomeclatorName;
	}

	public String getNomenclatorDescription() {
		return nomenclatorDescription;
	}

	public void setNomenclatorDescription(String nomenclatorDescription) {
		this.nomenclatorDescription = nomenclatorDescription;
	}

	public String getNomenclatorCode() {
		return nomenclatorCode;
	}

	public void setNomenclatorCode(String nomenclatorCode) {
		this.nomenclatorCode = nomenclatorCode;
	}

	public Long getNomenclatorID() {
		return nomenclatorID;
	}

	public void setNomenclatorID(Long nomenclatorID) {
		this.nomenclatorID = nomenclatorID;
	}

	public Library getOwnerLibrary() {
		return ownerLibrary;
	}

	public void setOwnerLibrary(Library ownerLibrary) {
		this.ownerLibrary = ownerLibrary;
		if (!ownerLibrary.getNomenclators().contains(this)) {
			ownerLibrary.getNomenclators().add(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomenclatorID == null) ? 0 : nomeclatorName.hashCode());
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
		Nomenclator other = (Nomenclator) obj;
		if (nomenclatorID == null) {
			if (other.getNomenclatorID() != null)
				return false;
		} else if (!nomenclatorID.equals(other.getNomenclatorID()))
			return false;
		return true;
	}

}
