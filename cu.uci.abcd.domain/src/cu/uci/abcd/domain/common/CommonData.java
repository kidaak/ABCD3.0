package cu.uci.abcd.domain.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommonData {
	@Column(name = "l10n_es", length = 500)
	private String l10nes;
	@Column(name = "l10n_en", length = 500)
	private String l10nen;
	@Column(name = "description", length = 500)
	private String description;

	public String getL10nes() {
		return l10nes;
	}

	public void setL10nes(String l10nes) {
		this.l10nes = l10nes;
	}

	public String getL10nen() {
		return l10nen;
	}

	public void setL10nen(String l10nen) {
		this.l10nen = l10nen;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((l10nen == null) ? 0 : l10nen.hashCode());
		result = prime * result + ((l10nes == null) ? 0 : l10nes.hashCode());
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
		CommonData other = (CommonData) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (l10nen == null) {
			if (other.l10nen != null)
				return false;
		} else if (!l10nen.equals(other.l10nen))
			return false;
		if (l10nes == null) {
			if (other.l10nes != null)
				return false;
		} else if (!l10nes.equals(other.l10nes))
			return false;
		return true;
	}

	public CommonData() {
		super();
	}

}
