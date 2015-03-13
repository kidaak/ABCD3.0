package cu.uci.abcd.domain.management.library;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import cu.uci.abcd.domain.common.EntityState;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.TangibleActor;

@Entity
@Table(name = "dprovider", schema = "abcd")
@PrimaryKeyJoinColumn(name = "provider_id")
@DiscriminatorValue(value = "PROVIDER")
public class Provider extends TangibleActor {
	@Column(name = "provider_name", nullable = false, length = 150)
	private String providerName;
	@Column(name = "rif_nit", nullable = false, length = 150)
	private String RIF_NIT;
	@Enumerated(EnumType.STRING)
	@Column(name = "provider_state")
	private EntityState providerState;
	@ElementCollection
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "dprovidertype", schema = "abcd", joinColumns = @JoinColumn(referencedColumnName = "provider_id"))
	@Column(name = "provider_type")
	private List<ProviderType> providerTypeList;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "representative_person_id", nullable = false)
	private Person representativePerson;

	public Provider() {
		super();
		providerTypeList = new ArrayList<>();
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getRIF_NIT() {
		return RIF_NIT;
	}

	public void setRIF_NIT(String rIF_NIT) {
		RIF_NIT = rIF_NIT;
	}

	public EntityState getProviderState() {
		return providerState;
	}

	public void setProviderState(EntityState providerState) {
		this.providerState = providerState;
	}

	public List<ProviderType> getProviderTypeList() {
		return providerTypeList;
	}

	public void setProviderTypeList(List<ProviderType> providerTypeList) {
		this.providerTypeList = providerTypeList;
	}

	public void addProviderType(ProviderType providerType) {
		if (!providerTypeList.contains(providerType)) {
			providerTypeList.add(providerType);
		}
	}

	public Person getRepresentativePerson() {
		return representativePerson;
	}

	public void setRepresentativePerson(Person representativePerson) {
		this.representativePerson = representativePerson;
	}

}
