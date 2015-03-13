package cu.uci.abcd.domain.common;

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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import cu.uci.abcd.domain.circulation.Penalty;
import cu.uci.abcd.domain.circulation.Reservation;
import cu.uci.abcd.domain.circulation.Transaction;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.util.DomainUtil;

@Entity
@Table(name = "dloanobject", schema = "abcd")
public class LoanObject {
	@Id
	@TableGenerator(name = "LOAN_OBJECT_GEN", table = DomainUtil.SEQUENCE_TABLE_NAME, pkColumnName = DomainUtil.SEQUENCE_TABLE_PK_COLUMN_NAME, valueColumnName = DomainUtil.SEQUENCE_TABLE_VALUE_COLUMN_NAME, pkColumnValue = "LOAN_OBJECT_SEQ", schema = "abcd")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "LOAN_OBJECT_GEN")
	@Column(name = "loan_object_id")
	private Long loanObjectID;
	@Column(name = "title")
	private String title;
	@Column(name = "author")
	private String author;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "record_type_id")
	private RecordType recordType;
	@Column(name = "registration_date")
	private Date registrationDate;
	@Column(name = "inventory_number")
	private String inventoryNumber;
	@Column(name = "control_number")
	private String controlNumber;
	@Column(name = "edition_number")
	private String editionNumber;
	@Column(name = "isis_db_name")
	private String isisDBName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "library_owner_id")
	private Library libraryOwner;
	@Enumerated(EnumType.STRING)
	@Column(name = "loan_object_state")
	private LoanObjectState loanObjectState;
	@OneToMany(mappedBy = "loanObject")
	private List<Reservation> reservationList;
	@OneToMany(mappedBy = "loanObject")
	private List<Transaction> transactions;
	@OneToMany(mappedBy = "loanObject")
	private List<Penalty> penalties;

	public LoanObject() {
		super();
		reservationList = new ArrayList<>();
		transactions = new ArrayList<>();
		penalties = new ArrayList<>();
	}

	public Long getLoanObjectID() {
		return loanObjectID;
	}

	public void setLoanObjectID(Long loanObjectID) {
		this.loanObjectID = loanObjectID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public RecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(RecordType recordType) {
		this.recordType = recordType;
		if (!recordType.getLoanObjectList().contains(this)) {
			recordType.getLoanObjectList().add(this);
		}
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	public String getEditionNumber() {
		return editionNumber;
	}

	public void setEditionNumber(String editionNumber) {
		this.editionNumber = editionNumber;
	}

	public String getIsisDBName() {
		return isisDBName;
	}

	public void setIsisDBName(String isisDBName) {
		this.isisDBName = isisDBName;
	}

	public Library getLibraryOwner() {
		return libraryOwner;
	}

	public LoanObjectState getLoanObjectState() {
		return loanObjectState;
	}

	public void setLoanObjectState(LoanObjectState loanObjectState) {
		this.loanObjectState = loanObjectState;
	}

	public void setLibraryOwner(Library libraryOwner) {
		this.libraryOwner = libraryOwner;
		if (!libraryOwner.getLoanObjectList().contains(this)) {
			libraryOwner.getLoanObjectList().add(this);
		}
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
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
				+ ((controlNumber == null) ? 0 : controlNumber.hashCode());
		result = prime * result
				+ ((inventoryNumber == null) ? 0 : inventoryNumber.hashCode());
		result = prime * result
				+ ((libraryOwner == null) ? 0 : libraryOwner.hashCode());
		result = prime * result
				+ ((loanObjectID == null) ? 0 : loanObjectID.hashCode());
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
		LoanObject other = (LoanObject) obj;
		if (controlNumber == null) {
			if (other.controlNumber != null)
				return false;
		} else if (!controlNumber.equals(other.controlNumber))
			return false;
		if (inventoryNumber == null) {
			if (other.inventoryNumber != null)
				return false;
		} else if (!inventoryNumber.equals(other.inventoryNumber))
			return false;
		if (libraryOwner == null) {
			if (other.libraryOwner != null)
				return false;
		} else if (!libraryOwner.equals(other.libraryOwner))
			return false;
		if (loanObjectID == null) {
			if (other.loanObjectID != null)
				return false;
		} else if (!loanObjectID.equals(other.loanObjectID))
			return false;
		return true;
	}

	public Reservation addReservation(Reservation reservation) {
		this.reservationList.add(reservation);
		if (!reservation.getLoanObject().equals(this)) {
			reservation.setLoanObject(this);
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
