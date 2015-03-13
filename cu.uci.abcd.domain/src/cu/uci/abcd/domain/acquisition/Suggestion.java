package cu.uci.abcd.domain.acquisition;

import javax.persistence.Column;
import javax.persistence.Embedded;
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

import cu.uci.abcd.domain.common.Account;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dsuggestion", schema = "abcd")
public class Suggestion {
	@Id
	@TableGenerator(name = "SUGGESTION_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "SUGGESTION_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SUGGESTION_GEN")
	@Column(name = "suggestion_id")
	private Long suggestionID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_account_id", nullable = false)
	private Account userAccount;
	@Embedded
	private MaterialCopy materialCopy;
	@Column(name = "note", length = 1000)
	private String note;
	@Column(name = "suggestion_state")
	@Enumerated(EnumType.STRING)
	private SuggestionState suggestionState;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "suggestion_reason_id", nullable = false)
	private Reason suggestionReason;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_library_id", nullable = false)
	private Library ownerLibrary;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "associate_order_id")
	private Order associateOrder;

	public Long getSuggestionID() {
		return suggestionID;
	}

	public void setSuggestionID(Long suggestionID) {
		this.suggestionID = suggestionID;
	}

	public Account getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(Account userAccount) {
		this.userAccount = userAccount;
	}

	public MaterialCopy getMaterialCopy() {
		return materialCopy;
	}

	public void setMaterialCopy(MaterialCopy materialCopy) {
		this.materialCopy = materialCopy;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public SuggestionState getSuggestionState() {
		return suggestionState;
	}

	public void setSuggestionState(SuggestionState suggestionState) {
		this.suggestionState = suggestionState;
	}

	public Reason getSuggestionReason() {
		return suggestionReason;
	}

	public void setSuggestionReason(Reason suggestionReason) {
		this.suggestionReason = suggestionReason;
	}

	public Library getOwnerLibrary() {
		return ownerLibrary;
	}

	public void setOwnerLibrary(Library ownerLibrary) {
		this.ownerLibrary = ownerLibrary;
	}

	public Order getAssociateOrder() {
		return associateOrder;
	}

	public void setAssociateOrder(Order associateOrder) {
		this.associateOrder = associateOrder;
		if (!associateOrder.getSuggestions().contains(this)) {
			associateOrder.getSuggestions().add(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result
				+ ((suggestionID == null) ? 0 : suggestionID.hashCode());
		result = prime * result
				+ ((userAccount == null) ? 0 : userAccount.hashCode());
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
		Suggestion other = (Suggestion) obj;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (suggestionID == null) {
			if (other.suggestionID != null)
				return false;
		} else if (!suggestionID.equals(other.suggestionID))
			return false;
		if (userAccount == null) {
			if (other.userAccount != null)
				return false;
		} else if (!userAccount.equals(other.userAccount))
			return false;
		return true;
	}

}
